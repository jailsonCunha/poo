package br.ufpb.sistemapedidos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class GravadorDePedidos {

	public List<Pedido> lePedidos() throws IOException{		
		ObjectInputStream ler = null;		
		try {			
			ler = new ObjectInputStream(new FileInputStream("ListaDePedidos.txt"));
			return (List<Pedido>) ler.readObject();			
		} catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos gravados no arquivo ListaDePedidos.txt não existe ", e);
		}finally{
			if(ler != null){
				ler.close();
			}
		}
	}
	
	public void gravaPedidos(List<Pedido> pedidos) throws IOException{
		ObjectOutputStream escrever = null;
		try{
			escrever = new ObjectOutputStream(new FileOutputStream("ListaDePedidos.txt"));
			escrever.writeObject(pedidos);
		}catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo ListaDePedidos.txt", e);
		}finally{
			if(escrever != null){
				escrever.close();
			}
		}
		
	}

}
