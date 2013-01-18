package br.ufpb.sistemapedidos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Essa classe implementa a interface sistema de controle.
 * @author Jailson
 *
 */
public class ControleDePedidos implements InterfaceSistemaDeControle{

	/**
	 * Esse � o seu atributo.
	 */
	private List<Pedido> pedidos;
	//Criando um objeto do tipo GravadorDePedidos
	GravadorDePedidos gravar = new GravadorDePedidos();

	/**
	 * Esse � o seu construtor para inicializar a classe.
	 */
	public ControleDePedidos() {
		try {
			this.pedidos = gravar.lePedidos();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			this.pedidos = new ArrayList<Pedido>();
		}
	}
	/**
	 * Esse m�todo � para gravar o pedido no arquivo
	 * @throws IOException 
	 * */
	public void gravador(){		
		try {
			gravar.gravaPedidos(this.pedidos);
		} catch (IOException e) {
			System.out.println("Erro na grava��o do arquivo " + e);
		}
	}

	/**
	 * Esse m�todo � para ler pedido no aqquivo
	 * @return O pedido do arquivo
	 * @throws IOException
	 */
	public List<Pedido> leitor() throws IOException{
		return gravar.lePedidos();		
	}

	/**
	 * Esse m�todo calcula a quantidade de pedidos de um serto cliente.
	 * @param nomeCliente � passado como par�metro no m�todo. 
	 * @return O total de pedidos do cliente passado no par�metro.
	 */
	public int calculeQuantidadeDePedidosDoCliente(String nomeCliente){
		int total = 0;
		for(Pedido pedido: this.pedidos){
			if(pedido.getCliente().getNome().equalsIgnoreCase(nomeCliente)){
				total++;
			}
		}
		return total;
	}

	/**
	 * Esse m�todo adiciona de fato o pedido na lista e � um dos
	 * m�todos da interface.
	 */
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);
		gravador();
	}

	/**
	 * Esse m�todo pesquisa os pedidos do cliente incluindo o c�digo do produto, esse tamb�m
	 * � um dos m�todos da interface.
	 */

	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) {
		List<Pedido> pesquisa = new ArrayList<Pedido>();// cria uma lista vazia.
		//for que varre a lista de pedidos.
		for(Pedido pedido : this.pedidos){
			//for que varre a lista de itens.
			for(ItemDePedido item : pedido.getItens()){
				if(item.getCodProduto().equalsIgnoreCase(codProduto)){
					pesquisa.add(pedido);
				}
			}
		}
		return pesquisa;
	}

	/**
	 * Esse m�todo remove o pedido incluindo seu numero, esse � m�todo da interface.
	 */
	public void removePedido(long numPedido) {
		for(Pedido pedido : this.pedidos){
			if(pedido.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(pedido);
				break;
			}
		}
		gravador();
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
