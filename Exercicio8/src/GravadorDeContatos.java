import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

public class GravadorDeContatos {

	public Collection<Contato> lerContato()throws IOException, ClassNotFoundException{
		Collection<Contato> contatos = null;

		ObjectInputStream ler= new ObjectInputStream(new FileInputStream("ListaDeContatos.txt"));
		contatos = (Collection<Contato>) ler.readObject();
		ler.close();
		return contatos;
	}

	public void gravarContatos(Collection<Contato> contatos) throws IOException{
		ObjectOutputStream escrever = new ObjectOutputStream(new FileOutputStream("ListaDeContatos.txt"));
		escrever.writeObject(contatos);
		escrever.close();
	}

}
