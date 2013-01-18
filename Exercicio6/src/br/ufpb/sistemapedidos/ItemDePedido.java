package br.ufpb.sistemapedidos;

import java.io.Serializable;

public class ItemDePedido implements Serializable{
	
	private int quantidade;
	private String codProduto;
	private double valorUnitario;
	
	public ItemDePedido(String codDoProduto, int quant, double valor){
		this.codProduto = codDoProduto;
		this.quantidade = quant;
		this.valorUnitario = valor;
	}

	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodProduto() {
		return this.codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public double getValorUnitario() {
		return this.valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String toString() {
		String item = " quantidade do produto = " + getQuantidade() + "\ncódigo do produto = "
				+ getCodProduto() + "\nvalor unitário do produto = " + getValorUnitario()+"\n";
		return item;
	}
	
	
	
}
