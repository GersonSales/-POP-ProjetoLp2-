package projeto.maispop.testes;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.maispop.sistema.Controller;
import projeto.maispop.usuario.Usuario;

public class TesteController {

	Controller controller;
	
	@Before
	public void test() {
		controller = new Controller();
	}

	@Test
	public void relacionametoUsuarios() {
		try {
			Usuario marcos = new Usuario("marcos", "mercos@email.com", "senhaMarcos", "02/02/1992");
			Usuario maria = new Usuario("maria", "maria@email.com", "senhaMaria", "03/03/1993");
			
			marcos.adicionaAmigo(maria.getEmail());
			Assert.assertEquals(1, maria.getNotificacoes());
			Assert.assertEquals("marcos que sua amizade.", maria.getProxNotificacao());
			Assert.assertEquals(true, maria.contemPendencia(maria.getEmail()));
			Assert.assertEquals(true, marcos.contemPendencia(maria.getEmail()));
			
			maria.rejeitaAmizade(marcos.getEmail());
			Assert.assertEquals("maria rejeitou sua amizade.", marcos.getProxNotificacao());
			Assert.assertEquals(false, maria.contemPendencia(maria.getEmail()));
			Assert.assertEquals(false, marcos.contemPendencia(maria.getEmail()));
			Assert.assertEquals(false, maria.contemAmigo(maria.getEmail()));
			Assert.assertEquals(false, marcos.contemAmigo(maria.getEmail()));
			
			marcos.adicionaAmigo(maria.getEmail());
			maria.aceitaAmizade(marcos.getEmail());
			
			Assert.assertEquals("maria aceitou sua amizade.", marcos.getProxNotificacao());
			Assert.assertEquals(true, marcos.contemAmigo(maria.getEmail()));
			Assert.assertEquals(true, maria.contemAmigo(marcos.getEmail()));

			
			marcos.removeAmigo(maria.getEmail());
			Assert.assertEquals("marcos removeu sua amizade.", maria.getProxNotificacao());
			Assert.assertEquals(false, maria.contemPendencia(maria.getEmail()));
			Assert.assertEquals(false, marcos.contemPendencia(maria.getEmail()));
			Assert.assertEquals(false, maria.contemAmigo(maria.getEmail()));
			Assert.assertEquals(false, maria.contemAmigo(maria.getEmail()));
			
		}catch (Throwable erro) {
			System.out.println(erro.getMessage());
			Assert.fail();
		}
	}
}
