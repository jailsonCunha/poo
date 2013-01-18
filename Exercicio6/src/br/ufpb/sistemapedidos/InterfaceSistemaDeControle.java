package br.ufpb.sistemapedidos;
import java.util.List;

/**
 * Essa interface foi criada para controla uma lista de pedidos
 * com as fun��es de adidiona pedidos, pesquisa o pedido pelo
 * c�digo do produto, ou seja, pelo seu nome e remover o pedido pelo seu n�mero. 
 * @author Jailson
 *
 */

public interface InterfaceSistemaDeControle {
	
	/**
	 * Esse m�todo adiciona o pedido no sistema.
	 * @param p � passado como par�metro da classe Pedido.
	 */
	public void adicionaPedido(Pedido p);
	
	/**
	 * Esse m�todo pesquisar no sistema a lista de pedidos.
	 * @param codProduto � passado como par�metro.
	 * @return A lista de pedidos do par�metro codProduto.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	
	/**
	 * Esse metado remove o pedido, ou seja, apaga o pedido do sistema.
	 * @param numPedido � passado como par�metro do pedido � ser apagado.
	 */
	public void removePedido(long nomePedido);

}
