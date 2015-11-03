package projeto.maispop.testes;


import org.junit.Assert;
import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.usuario.Usuario;

public class TesteUsuario {

	@Test
	public void criacaoInvalida() {
		// Nome invalido:
		try {
			@SuppressWarnings("unused")
			Usuario marcos = new Usuario("", "marcos@email.com", "senhaMarcos",
					"02/02/1992");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals("Nome dx usuarix nao pode ser vazio.",
					erro.getMessage());
		} catch (Throwable erro) {
			Assert.fail();
		}

		// E-mail invalida:
		try {
			@SuppressWarnings("unused")
			Usuario marcos = new Usuario("marcos", "", "senhaMarcos",
					"02/02/1992");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals("Formato de e-mail esta invalido.",
					erro.getMessage());
		} catch (Throwable erro) {
			Assert.fail();
		}

		// E-mail invalido:
		try {
			@SuppressWarnings("unused")
			Usuario marcos = new Usuario("marcos", "marcos@email",
					"SenhaMarcos", "02/02/1992");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals("Formato de e-mail esta invalido.",
					erro.getMessage());
		} catch (Throwable erro) {
			Assert.fail();
		}

		// Senha invalida:
		try {
			@SuppressWarnings("unused")
			Usuario marcos = new Usuario("marcos", "marcos@email.com", "",
					"02/02/1992");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals("Senha invalida!", erro.getMessage());
		} catch (Throwable erro) {
			Assert.fail();
		}

		// Data invalida:
		try {
			@SuppressWarnings("unused")
			Usuario marcos = new Usuario("marcos", "marcos@email.com",
					"senhaMarcos", "");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals("Formato de data esta invalida.",
					erro.getMessage());
		} catch (Throwable erro) {
			Assert.fail();
		}

		// Data invalida:
		try {
			@SuppressWarnings("unused")
			Usuario marcos = new Usuario("marcos", "marcos@email.com",
					"senhaMarcos", "020/02/1992");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals("Formato de data esta invalida.",
					erro.getMessage());
		} catch (Throwable erro) {
			Assert.fail();
		}

		// Data invalida:
		try {
			@SuppressWarnings("unused")
			Usuario marcos = new Usuario("marcos", "marcos@email.com",
					"senhaMarcos", "29/02/1993");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals("Data nao existe.", erro.getMessage());
		} catch (Throwable erro) {
			Assert.fail();
		}
	}

	@Test
	public void criacaoValida() {
		try {
			Usuario marcos = new Usuario("marcos", "marcos@email.com",
					"senhaMarcos", "02/02/1992");
			Assert.assertEquals("marcos", marcos.getNome());
			Assert.assertEquals("marcos@email.com", marcos.getEmail());
			Assert.assertEquals("senhaMarcos", marcos.getSenha());
			Assert.assertEquals("1992-02-02", marcos.getDataNascimento());
			Assert.assertEquals("resources/default.jpg",
					marcos.getImagemPerfil());
		} catch (Throwable erro) {
			Assert.fail();
		}
	}

	@Test
	public void alteracaoInvalida() {

		try {
			Usuario marcos = new Usuario("marcos", "marcos@email.com",
					"senhaMarcos", "02/02/1992");

			// Nome invalido:
			try {
				marcos.setNome("");
				Assert.fail();
			} catch (EntradaException erro) {
				Assert.assertEquals("Nome dx usuarix nao pode ser vazio.",
						erro.getMessage());
				Assert.assertEquals("marcos", marcos.getNome());
			} catch (Throwable erro) {
				Assert.fail();
			}

			// Senha invalida:
			try {
				marcos.setSenha("");
				Assert.fail();
			} catch (EntradaException erro) {
				Assert.assertEquals("Senha invalida!", erro.getMessage());
				Assert.assertEquals("senhaMarcos", marcos.getSenha());
			} catch (Throwable erro) {
				Assert.fail();
			}

			//E-mail invalido:
			try {
				marcos.setEmail("");
				Assert.fail();
			} catch (EntradaException erro) {
				Assert.assertEquals("Formato de e-mail esta invalido.", erro.getMessage());
				Assert.assertEquals("marcos@email.com", marcos.getEmail());
			} catch (Throwable erro) {
				Assert.fail();
			}

			//Data invalida:
			try {
				marcos.setDataNascimento("");
				Assert.fail();
			} catch (EntradaException erro) {
				Assert.assertEquals("Formato de data esta invalida.", erro.getMessage());
				Assert.assertEquals("1992-02-02", marcos.getDataNascimento());
			} catch (Throwable erro) {
				Assert.fail();
			}
			
			
		} catch (Throwable erro) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void publicacaoTipo() {
		try {
			Usuario marcos = new Usuario("marcos", "marcos@email.com",
					"senhaMarcos", "02/02/1992");
			Assert.assertEquals("Normal Pop", marcos.getTipoUsuario());

			
			Assert.assertEquals(0, marcos.getPopularidade());
			marcos.postar("Primeira postagem de marcos", "02/02/2012 19:20:20");
			
			marcos.curtir(marcos.getPostagem(0));
			
			Assert.assertEquals(10, marcos.getPopularidade());
			
			for (int i = 0; i < 50; i ++) {
				marcos.curtir(marcos.getPostagem(0));
			}
			
			marcos.atualizaTipo();
			Assert.assertEquals("Celebridade Pop", marcos.getTipoUsuario());
			Assert.assertEquals(510, marcos.getPopularidade());
			
			for (int i = 0; i < 20; i ++){
				marcos.curtir(marcos.getPostagem(0));
			}
			
			marcos.atualizaTipo();
			Assert.assertEquals("Icone Pop", marcos.getTipoUsuario());
			Assert.assertEquals(1010, marcos.getPopularidade());
			
		}catch (Throwable erro) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void igualdade() {
		try {
			Usuario marcos = new Usuario("marcos", "marcos@email.com",
					"senhaMarcos", "02/02/1992");
			Usuario joaoMarcos = new Usuario("joaoMarcos", "marcos@email.com",
					"senhaJoaoMarcos", "02/04/1994");
			
			Assert.assertEquals(true, marcos.equals(joaoMarcos));
			
			joaoMarcos.setEmail("joaoMarcos@email.com");
			Assert.assertEquals(false, marcos.equals(joaoMarcos));
			
		}catch(Throwable erro) {
			Assert.fail();
		}
	}
	
	
	
	
	

}