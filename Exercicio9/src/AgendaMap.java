import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AgendaMap implements AgendaIF{
	
	private Map<String,Contato> contatos;
	private GravadorDeContatosMap gravar = new GravadorDeContatosMap();

	public AgendaMap() {
		try {
			this.contatos = gravar.lerContato();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			this.contatos = new HashMap<String, Contato>();
		}
	}
	
	public void gravador(){
		try {
			gravar.gravarContato(this.contatos);
		} catch (IOException e) {
			System.err.println("Erro na gravação do arquivo " + e);
		}
	}

	public void adicionarContato(String nome, String tel) {
		this.contatos.put(nome, new Contato(nome, tel));
		gravador();
	}

	public void removerContato(String nomeContato) throws ContatoInexistenteException {
		boolean encontrado = false;
		for(Contato contato: this.contatos.values()){
			if(contato.getNome().contains(nomeContato)){
				this.contatos.remove(nomeContato);
				encontrado = true;
				break;
			}
		}
		if (encontrado == false) {
			throw new ContatoInexistenteException("Contato não cadastrado");
		}
		gravador();
	}

	public Contato pesquisarContato(String nomeContato) throws ContatoInexistenteException {
		for(Contato contato : this.contatos.values()){
			if(contato.getNome().contains(nomeContato)){
				return contato;
			}
		}
		throw new ContatoInexistenteException("Contato não cadastrado");
	}

	@Override
	public Iterator<Contato> getContatoOrdenados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Contato> getContatos() {
		// TODO Auto-generated method stub
		return null;
	}


}
