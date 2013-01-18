package br.ufpb.sistemapedidos;
import java.util.List;

/**
 * Essa interface foi criada para controla uma lista de pedidos
 * com as funções de adidiona pedidos, pesquisa o pedido pelo
 * código do produto, ou seja, pelo seu nome e remover o pedido pelo seu número. 
 * @author Jailson
 *
 */

public interface InterfaceSistemaDeControle {
	
	/**
	 * Esse método adiciona o pedido no sistema.
	 * @param p é passado como parâmetro da classe Pedido.
	 */
	public void adicionaPedido(Pedido p);
	
	/**
	 * Esse método pesquisar no sistema a lista de pedidos.
	 * @param codProduto é passado como parâmetro.
	 * @return A lista de pedidos do parâmetro codProduto.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	
	/**
	 * Esse metado remove o pedido, ou seja, apaga o pedido do sistema.
	 * @param numPedido é passado como parâmetro do pedido à ser apagado.
	 */
	public void removePedido(long nomePedido);

}
