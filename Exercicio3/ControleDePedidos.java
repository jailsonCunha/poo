import java.util.ArrayList;
import java.util.List;

public class ControleDePedidos implements InterfaceSistemaDeControle{
    
	private List<Pedido> pedidos;
	
	public ControleDePedidos() {
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public int calculeQuantidadeDePedidosDoCliente(String nomeCliente){
		int total = 0;
		for(Pedido pedido: this.pedidos){
			if(pedido.getCliente().getNome().equalsIgnoreCase(nomeCliente)){
				total++;
			}
		}
		return total;
	}

	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);
		
	}

	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) {
		List<Pedido> pesquisa = new ArrayList<Pedido>();
		for(Pedido pedido : this.pedidos){
			for(ItemDePedido item : pedido.getItens()){
				if(item.getCodProduto().equalsIgnoreCase(codProduto)){
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
