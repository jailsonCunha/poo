package br.ufpb.sistemapedidos;

import java.util.List;
import javax.swing.JOptionPane;

public class PrincipalExercicio6 {

	public static void main(String[] args) {

		ControleDePedidos sistema = new ControleDePedidos();

		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua opção:\n1-Adicionar Pedido\n2-Pesquisar pedido incluido código do produto\n3-Remover pedido\n4-Sair do sistema de Pedidos"));
			switch (opcao) {

			case 1:

				/** Dados do cliente*/
				String nome = JOptionPane.showInputDialog(null,"Informe o nome do cliente ");
				Cliente cliente = new Cliente(nome);

				/**Número do pedido do cliente*/
				long numPedido = Long.parseLong(JOptionPane.showInputDialog(null,"Informe o número do pedido "));
				Pedido pedido = new Pedido(numPedido);
				pedido.setCliente(cliente);

				/**Quantidade de itens do cliente*/				
				int quantPedido = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de itens "));


				/**Quando a lista de pedidos estiver vazia*/
				if(quantPedido == 0){
					JOptionPane.showInputDialog(null,"Lista de pedidos vazia");
					break;
				}

				/**contador para cantar o numero de itens do pedido*/
				int contador = 1;
				while (quantPedido != 0) {

					String nomeProduto = JOptionPane.showInputDialog(null, (contador ++)+"º pedido\nInforme o código do produto");

					int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de produto ?"));

					double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor unitário do produto ?"));

					ItemDePedido pedidos = new ItemDePedido(nomeProduto, quantidade, valorUnitario);
					pedido.adicionaItem(pedidos);

					--quantPedido;// vai eliminado os pedidos
				}

				sistema.adicionaPedido(pedido);

				JOptionPane.showMessageDialog(null, "Pedido comfirmado");
			break;
			
			case 2:
				String nomeProduto = JOptionPane.showInputDialog(null, "Pesquisar pedidos pelo código do produto ?\n Informe o nome do produto: ");

				//Criar uma lista de busca de pedido
				List<Pedido> buscarCodDoProduto =  sistema.pesquisaPedidosIncluindoProduto(nomeProduto);

				//for-each para varrer a lista de busca
				for(Pedido codigo : buscarCodDoProduto){
					JOptionPane.showMessageDialog(null, "Lista com as informações do código informado:\n"+ codigo.toString());
					break;
				}	
			break;
			
			case 3:
				long pedidoRemovido = Long.parseLong(JOptionPane.showInputDialog(null, "Informe o número do pedido que você deseja excluir ? "));
				sistema.removePedido(pedidoRemovido);
				JOptionPane.showMessageDialog(null, "Pedido excluindo com sucesso!");
			break;	

		    default:
		    	JOptionPane.showMessageDialog(null, "Você saiu do sistema");
		    }
		
		}while ((opcao >= 1) && (opcao < 4));
		JOptionPane.showMessageDialog(null, "Programa encerrada\nObrigado\nE volte sempre !");

   }

}
