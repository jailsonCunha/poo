import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControleDePedidos implements InterfaceSistemaDeControle{

	private List<Pedido> pedidos;
	private GravadorDePedidos gravar = new GravadorDePedidos();

	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}

	/**public ControleDePedidos(){

		this.pedidos = new ArrayList<Pedido>();

		try {

			this.pedidos = gravar.lePedidos();

		} catch (IOException e) {
			this.pedidos = new ArrayList<Pedido>();
			System.err.println("O arquivo não pode ser lido");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}*/

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

		for(Pedido pedido: this.pedidos){
			for(ItemDePedido item: pedido.getItens()){
				if(item.getCodProduto() == codProduto){
					pesquisa.add(pedido);
				}
			}
		}
		return pesquisa;
	}

	public void removePedido(long numPedido) {
		for(Pedido pedido: this.pedidos){
			if(pedido.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(pedido);
			}
		}

	}	
	
}
