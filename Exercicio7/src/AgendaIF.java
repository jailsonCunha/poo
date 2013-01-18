public interface AgendaIF {
	
	public void adicionarContato(String nome, String tel);
	public void removerContato(String nomeContato)throws ContatoInexistenteException;
	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException;
	
}
