import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class GravadorDeContatos {
	
	public Map<String,Contato> lerContato() throws IOException{		
		ObjectInputStream ler = null;		
		try {			
			ler = new ObjectInputStream(new FileInputStream("ListaDeContatos.txt"));
			return  (Map<String, Contato>) ler.readObject();			
		} catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos gravados no arquivo ListaDeContatos.txt não existe ", e);
		}finally{
			if(ler != null){
				ler.close();
			}
		}
	}
	
	public void gravarContato(Map<String,Contato> pedidos) throws IOException{
		ObjectOutputStream escrever = null;
		try{
			escrever = new ObjectOutputStream(new FileOutputStream("ListaDeContatos.txt"));
			escrever.writeObject(pedidos);
		}catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo ListaDeContatos.txt", e);
		}finally{
			if(escrever != null){
				escrever.close();
			}
		}
		
	}

}
