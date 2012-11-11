public class SistemaPrincipal {
	public static void main(String[] args) {
		
		ControleDePedidos controle = new ControleDePedidos();
		Pedido p1 = new Pedido(1);
		Pedido p2 = new Pedido(2);
		Cliente c = new Cliente("JAILSON");
		
		p1.setCliente(c);
		p2.setCliente(c);
		
		ItemDePedido it1 = new ItemDePedido(1, 3, 5.00);
		ItemDePedido it2 = new ItemDePedido(2, 4, 3.50);		
		p1.adicionaItem(it1);
		p2.adicionaItem(it2);
		
		controle.adicionaPedido(p1);
		controle.adicionaPedido(p2);
				
		int quantPedido = controle.calculaQuantidadeDePedidosDoCliente("jailson");
		if(quantPedido == 2){
			System.out.println("Programa correto!");
		}else{
			System.out.println("Programa incorreto!");
		}
		
	}

}
