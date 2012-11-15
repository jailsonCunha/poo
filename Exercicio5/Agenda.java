import java.util.ArrayList;
import java.util.List;

public class Agenda implements AgendaIF{
	
	private List<Contato> contatos;
	
	public Agenda(){
		this.contatos = new ArrayList<Contato>();
	}

	public void adicionarContato(String nome, String tel) {
		this.contatos.add(new Contato(nome, tel));		
	}

	public void removerContato(String nomeContato)throws ContatoInexistenteException {
		for(Contato contato : this.contatos){
			if(contato.getNome().equalsIgnoreCase(nomeContato)){
				this.contatos.remove(contato);
				break;
			}
		}
		
		throw new ContatoInexistenteException("Contato não existe");
		
	}

	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException {
		for(Contato contato : this.contatos){
			if(contato.getNome().equalsIgnoreCase(nomeContato)){
				return contato;
			}
		}
		
		throw new ContatoInexistenteException("Contato não existe");
	}
	
	

}
