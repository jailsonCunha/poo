import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;

public class GravadorDeContatos {

	public Collection<Contato> lerContato()throws IOException{
		Collection<Contato> contatos = null;
		ObjectInputStream ler = null;
		
		try {
			ler = new ObjectInputStream(new FileInputStream("ListaDeContatos.txt"));
			contatos = (Collection<Contato>) ler.readObject();
			ler.close();
		} catch (ClassNotFoundException e) {
			throw new IOException();
		}
		return (List<Contato>) contatos;
		
	}

	public void gravarContatos(List<Contato> contatos) throws IOException{
		
		ObjectOutputStream escrever = null;
		escrever = new ObjectOutputStream(new FileOutputStream("ListaDeContatos.txt"));
		escrever.writeObject(contatos);
		escrever.close();
	}

}
