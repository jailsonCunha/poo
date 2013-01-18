import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AgendaList implements AgendaIF{

	private List<Contato> contatos;
	private GravadorDeContatos gravar = new GravadorDeContatos();

	public AgendaList() {
		
		try {
			this.contatos = (List<Contato>) gravar.lerContato();
		} catch (IOException e) {
			System.out.println("Houve erro na leitura do arquivo");
			this.contatos = new ArrayList<Contato>();
		}
		
		
	}

	public void adicionarContato(String nome, String tel) {
		this.contatos.add(new Contato(nome, tel));
		try {
			gravar.gravarContatos(this.contatos);
		} catch (IOException e) {
			System.err.println("Erro na gravação do contato? "+ e.getMessage());
		}

	}

	public void removerContato(String nomeContato) throws ContatoInexistenteException {
		for(Contato contato : this.contatos){
			if(contato.getNome().equalsIgnoreCase(nomeContato)){
				this.contatos.remove(contato);
				try {
					gravar.gravarContatos(contatos);
					return;
				} catch (IOException e) {
					System.err.println("Erro na remoção do arquivo"+ e.getMessage());
				}
			}
		}

		throw new ContatoInexistenteException("Contato não cadastrado "+ nomeContato);

	}

	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException {
		for(Contato contato : this.contatos){
			if(contato.getNome().equalsIgnoreCase(nomeContato)){
				return contato;
			}
		}

		throw new ContatoInexistenteException("Contato não existe");
	}

	public Iterator<Contato> getContatoOrdenados() {
		Collections.sort(this.contatos);		
		return this.contatos.iterator();
	}

	public Collection<Contato> getContatos() {
		Collection<Contato> contato = new ArrayList<Contato>();		
		contato.addAll(this.contatos);		
		return contato;
	}

		
}
