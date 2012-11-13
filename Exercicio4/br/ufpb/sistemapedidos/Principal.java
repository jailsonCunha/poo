package br.ufpb.sistemapedidos;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		double valorTotal = 0;
		Pedido pedido = new Pedido(1);
		String codigoProduto, quantidade, valor;
		
		while (!(codigoProduto = entrada.nextLine()).equals("0")){
			quantidade = entrada.nextLine();
			valor = entrada.nextLine();	
			ItemDePedido itens= new ItemDePedido(codigoProduto, Integer.parseInt(quantidade), Double.parseDouble(valor));
			pedido.adicionaItem(itens);
			valorTotal += (Double.parseDouble(valor) * Integer.parseInt(quantidade));
		}
		System.out.println("Valor total:R$ "+valorTotal);
			
	}

}
