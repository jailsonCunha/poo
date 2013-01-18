import java.util.Iterator;

import javax.swing.JOptionPane;

public class PrincipalExercicio8 {
	public static void main(String[] args) {

		Agenda agenda = new Agenda();

		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua opção:\n1-Adicionar Contato\n2-Pesquisar contato pelo nome\n3-Remover contato\n4-Contatos ordenados por nome\n5-Sair da agenda"));
			switch (opcao) {

			case 1:

				/** Dados do contato*/
				String nome = JOptionPane.showInputDialog(null,"Informe o nome do contato: ");
				String telefone = JOptionPane.showInputDialog(null,"Informe o telefone do contato: ");
				Contato contato = new Contato(nome, telefone);
				agenda.adicionarContato(nome, telefone);
				JOptionPane.showMessageDialog(null, "Contato adicionado");
				break;

			case 2:
				nome = JOptionPane.showInputDialog(null, "Pesquisar contato pelo nome\n Informe o nome do contato: ");
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
				
			case 4:
				boolean encontrado = false;
				Iterator<Contato> contatosIte = agenda.getContatoOrdenados();
				while (contatosIte.hasNext()) {
					JOptionPane.showMessageDialog(null, "Contatos ordenados\n"+contatosIte.next().toString());	
					encontrado = true;
					continue;
				}
				if(encontrado == false){
					JOptionPane.showMessageDialog(null, "Lista de contatos vazia");
				}
				break;

			default:
				JOptionPane.showMessageDialog(null, "Você saiu da agenda");
			}

		}while ((opcao >= 1) && (opcao < 5));
		JOptionPane.showMessageDialog(null, "Agenda encerrada\nObrigado\nE volte sempre !");

	}
}
