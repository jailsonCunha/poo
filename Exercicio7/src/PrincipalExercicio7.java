import javax.swing.JOptionPane;

public class PrincipalExercicio7 {
	public static void main(String[] args) {

		Agenda agenda = new Agenda();

		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua opção:\n1-Adicionar Contato\n2-Pesquisar contato pelo nome\n3-Remover contato\n4-Sair da agenda"));
			switch (opcao) {

			case 1:

				/** Dados do contato*/
				String nome = JOptionPane.showInputDialog(null,"Informe o nome do contato: ");
				String telefone = JOptionPane.showInputDialog(null,"Informe o telefone do contato: ");
				Contato contato = new Contato(nome, telefone);
				agenda.adicionarContato(contato.getNome(), contato.getTelefone());
				JOptionPane.showMessageDialog(null, "Contato adicionado");
				break;

			case 2:
				nome = JOptionPane.showInputDialog(null, "Pesquisar contato pelo nome\n Informe o nome do contato: ");
				//Contato contato1 = null;
				try {
					contato = agenda.pesquisarContato(nome);
					JOptionPane.showMessageDialog(null, "Lista com as informações do contato:\n"+ contato.toString());
				} catch (ContatoInexistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case 3:
				nome = JOptionPane.showInputDialog(null, "Informe o nome do contato que você deseja excluir ? ");
				try {
					agenda.removerContato(nome);
					JOptionPane.showMessageDialog(null, "Contato excluindo com sucesso!");
				} catch (ContatoInexistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;	

			default:
				JOptionPane.showMessageDialog(null, "Você saiu da agenda");
			}

		}while ((opcao >= 1) && (opcao < 4));
		JOptionPane.showMessageDialog(null, "Agenda encerrada\nObrigado\nE volte sempre !");

	}
}
