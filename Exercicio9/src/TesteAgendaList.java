import static org.junit.Assert.*;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteAgendaList {

	private AgendaList agenda;

	@Before
	public void setUp(){
		this.agenda = new AgendaList();
	}

	@After
	public void tearDown(){
		File file = new File("ListaDeContatos.txt");
		if(file.exists()){
			file.delete();
		}
	}

	@Test
	public void testarAdicionaContato(){
		agenda.adicionarContato("jailson", "1236-8745");
		try {
			Contato contato = agenda.pesquisarContato("jailson");
			assertTrue(contato.getNome().equalsIgnoreCase("jailson"));
			assertEquals("jailson", contato.getNome());
		} catch (ContatoInexistenteException e) {
			fail("Não era para dar esse erro");
		}

	}

	@Test
	public void testarRemoveContato(){
		agenda.adicionarContato("jose", "5980-8754");
		try {
			Contato contato = agenda.pesquisarContato("jose");
			assertTrue(contato.getNome().equalsIgnoreCase("jose"));
			assertEquals("jose", contato.getNome());
			agenda.removerContato("jose");
		} catch (ContatoInexistenteException e) {
			fail("Não era para dar esse erro");
		}
	}

	@Test
	public void testarPesquisaContato(){
		agenda.adicionarContato("joão", "2365-7841");
		try {
			Contato contato = agenda.pesquisarContato("joão");
			assertTrue(contato.getNome().equalsIgnoreCase("joão"));
			assertEquals("joão", contato.getNome());
		} catch (ContatoInexistenteException e) {
			fail("Não era para dar esse erro");
		}
	}

	@Test
	public void testarGetContatos(){

		agenda.adicionarContato("Severina", "1935-1573");
		agenda.adicionarContato("Jailson", "6589-4132");
		agenda.adicionarContato("Arnaldo", "7869-3251");
		agenda.adicionarContato("Laisla", "4298-5483");

		Collection<Contato> contatos = agenda.getContatos();
		assertTrue(contatos.size() == 4);
		assertEquals(4, contatos.size());
	}
	
	@Test
	public void testarGetContatosOrdenados(){
		agenda.adicionarContato("Severina", "1935-1573");
		agenda.adicionarContato("Jailson", "6589-4132");
		agenda.adicionarContato("Arnaldo", "7869-3251");
		agenda.adicionarContato("Laisla", "4298-5483");
		
		Iterator<Contato> contatosIte = agenda.getContatoOrdenados();
		assertEquals("Arnaldo", contatosIte.next().getNome());
		assertEquals("Jailson", contatosIte.next().getNome());
		assertEquals("Laisla", contatosIte.next().getNome());
		assertEquals("Severina", contatosIte.next().getNome());
		
	}
	
}
