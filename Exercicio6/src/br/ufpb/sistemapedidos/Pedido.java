package br.ufpb.sistemapedidos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable{

	private long numeroDoPedido;
	private Cliente cliente;
	private List<ItemDePedido> itens;

	public Pedido(long numPedido) {
		this.numeroDoPedido = numPedido;
		this.cliente = new Cliente(null);
		this.itens = new ArrayList<ItemDePedido>();
	}

	public List<ItemDePedido> getItens(){
		return this.itens;
	}

	public void adicionaItem(ItemDePedido item){
		this.itens.add(item);
	}

	public long getNumeroDoPedido() {
		return this.numeroDoPedido;
	}
	public void setNumeroDoPedido(long numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		String Pedido = "Nome do Cliente: " +getCliente().getNome()+"\nNúmero do Pedido = " +getNumeroDoPedido()+"\nItens do Pedido "+ this.itens.toString();
		return Pedido;
	}

}
