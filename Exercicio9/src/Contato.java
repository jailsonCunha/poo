import java.io.Serializable;

public class Contato implements Serializable, Comparable<Contato>{
	
	private String nome;
	private String telefone;
	
	public Contato(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int compareTo(Contato contato) {
		if(this.nome.compareToIgnoreCase(contato.getNome()) == 0){
			return 0;
		}else if(this.nome.compareToIgnoreCase(contato.getNome()) < 0){
			return -1;
		}else{
			return 1;
		}
		
	}	
	
	public String toString() {
		return "Nome: "+getNome()+"\n"+"Telefone: "+ getTelefone()+"\n";
	}


}
