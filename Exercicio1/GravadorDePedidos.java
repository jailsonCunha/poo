import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GravadorDePedidos {
	
	public List<Pedido> lePedidos() throws IOException, ClassNotFoundException{
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		ObjectInputStream ler = new ObjectInputStream(new FileInputStream("ListaDePedidos.txt"));
		pedidos = (List<Pedido>) ler.readObject();
		ler.close(); 
		
		return pedidos;		
	}
	
	public void gravaPedidos(List<Pedido> pedidos) throws IOException{
		ObjectOutputStream escrever = new ObjectOutputStream(new FileOutputStream("ListaDePedidos.txt"));
		escrever.writeObject(pedidos);
		escrever.close();
	}

}
