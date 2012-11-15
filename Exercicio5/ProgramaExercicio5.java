public class ProgramaExercicio5 {
	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		agenda.adicionarContato("JAILSON", "2222-2222");

		try {
			agenda.pesquisarContato("jailson");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}

		try {
			agenda.pesquisarContato("Tonho");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}

	}

}
