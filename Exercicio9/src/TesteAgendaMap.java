import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteAgendaMap {
	
	private AgendaMap agenda;

	@Before
	public void setUp(){
		this.agenda = new AgendaMap();
	}

	@After
	public void tearDown(){
		File file = new File("MapaDeContatos.txt");
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


}
