import java.util.ArrayList;
import java.util.List;

public class ControleDePedidos implements InterfaceSistemaDeControle{
	
	private List<Pedido> pedidos;
	
	/*public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}*/
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
		try {
			this.pedidos = gravar.lePedidos();
		} catch (IOException e) {
			this.pedidos = new ArrayList<Pedido>();
			System.out.println("A lista de pedidos nao pode ser lida.");
		}catch (ClassNotFoundException e) {
			System.out.println("A lista nao existe.");
		}
		
	}
	
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int total = 0;
		for(Pedido pedido : this.pedidos){
			if(pedido.getCliente().getNome().equalsIgnoreCase(nomeCliente)){
				total++;
			}
		}
		
		return total;
	}

	public void adicionaPedido(Pedido p) {		
		this.pedidos.add(p);
	}

	public List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto) {
		List<Pedido> pesquisa = new ArrayList<Pedido>();
		for(Pedido pedido : this.pedidos){
			for(ItemDePedido item : pedido.getItens()){
				if(item.getCodProduto() == codProduto){
					pesquisa.add(pedido);
				}
			}
		}
		
		return pesquisa;
	}

	public void removePedido(long numPedido) {
		
		for(Pedido pedido : this.pedidos){
			if(pedido.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(pedido);
			}
		}
		
	}

}
