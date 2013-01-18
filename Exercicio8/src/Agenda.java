import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Agenda implements AgendaIF{

	private List<Contato> contatos;
	GravadorDeContatos gravar = new GravadorDeContatos();

	public Agenda() {

		try {
			this.contatos = (List<Contato>) gravar.lerContato();
		} catch (ClassNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			System.out.println("Houve erro na leitura do arquivo");
			this.contatos = new ArrayList<Contato>();
		}


	}

	public void gravador(){
		try {
			gravar.gravarContatos(this.contatos);
		}  catch (IOException e) {
			System.err.println("Erro na gravação do contato? "+ e.getMessage());
		}
	}
	
	public void adicionarContato(String nome, String tel) {
		this.contatos.add(new Contato(nome, tel));
		gravador();
	}

	public void removerContato(String nomeContato) throws ContatoInexistenteException {
		boolean encontrado = false;
		for(Contato contato : this.contatos){
			if(contato.getNome().equalsIgnoreCase(nomeContato)){
				this.contatos.remove(contato);
				encontrado = true;
				break;
			}
		}
		
		if(encontrado == false){
			throw new ContatoInexistenteException("Contato não cadastrado "+ nomeContato);
		}
		gravador();
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
