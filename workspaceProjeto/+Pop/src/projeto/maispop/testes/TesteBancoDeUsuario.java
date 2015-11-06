package projeto.maispop.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.LogicaException;
import projeto.maispop.excecoes.UsuarioInexistenteException;
import projeto.maispop.sistema.BancoDeUsuarios;
import projeto.maispop.usuario.Usuario;

public class TesteBancoDeUsuario {

	private BancoDeUsuarios bancoDeUsuarios;

	@Test
	public void atualizaInformacao() {
		// atualiza senha Sara
		try {
			this.bancoDeUsuarios.atualizaPerfil("Senha", "michael_<3", "Origami<3", "sara_t@techgroup.com");
		} catch (Exception erro) {
			Assert.fail();
		}

		// Atualiza nome Lincoln
		try {
			this.bancoDeUsuarios.atualizaPerfil("Nome", "Linc Burrows", "linc_burrows@techgroup.com");
		} catch (Exception erro) {
			Assert.fail();
		}

		// Atualiza email Lincoln
		try {
			this.bancoDeUsuarios.atualizaPerfil("E-mail", "lb_linc@techgroup.com", "linc_burrows@techgroup.com");
		} catch (Exception erro) {
			Assert.fail();
		}

		// atualiza data nascimento Sara
		try {
			this.bancoDeUsuarios.atualizaPerfil("Data de Nascimento", "12/03/1987", "sara_t@techgroup.com");
		} catch (Exception erro) {
			Assert.fail();
		}
	}

	public void cadastroUsuario() {
		try {
			this.bancoDeUsuarios.cadastraUsuario("Michael Scofield", "michael@techgroup.com", "@rlbop#@", "18/08/1984",
					"arquivos/imagens/imagens_da_camera/wp_20150629_001.jpg");
			this.bancoDeUsuarios.cadastraUsuario("Sara Tancredi", "sara_t@techgroup.com", "Origami<3", "12/03/1887",
					"arquivos/imagens/sara.jpg");
			this.bancoDeUsuarios.cadastraUsuario("Lincoln Burrows", "linc_burrows@techgroup.com", "lj_veronicaD",
					"07/02/1978");

			Assert.assertEquals(3, this.bancoDeUsuarios.dimensaoBanco());
		} catch (Exception erro) {
			Assert.fail();
		}
	}

	@Test
	public void informacaoUsuario() {
		try {
			String nome = this.bancoDeUsuarios.getInfoUsuario("Nome", "linc_burrows@techgroup.com");

			String email = this.bancoDeUsuarios.getInfoUsuario("Email", "linc_burrows@techgroup.com");

			String dataNascimento = this.bancoDeUsuarios.getInfoUsuario("Data de Nascimento",
					"linc_burrows@techgroup.com");

			String foto = this.bancoDeUsuarios.getInfoUsuario("Foto", "linc_burrows@techgroup.com");
			
			Assert.assertEquals("Lincoln Burrows", nome);
			Assert.assertEquals("linc_burrows@techgroup.com", email);
			Assert.assertEquals("1978-02-07", dataNascimento);
			Assert.assertEquals("resources/default.jpg", foto);
			

		} catch (EntradaException | LogicaException e) {
			Assert.fail();
		}
	}

	@Before
	public void instancia() {
		this.bancoDeUsuarios = new BancoDeUsuarios();
		cadastroUsuario();
	}

	@Test
	public void ranking() {
		try {
			Usuario saraTancredi = this.bancoDeUsuarios.getUsuario("sara_t@techgroup.com");

			Usuario michaelScofield = this.bancoDeUsuarios.getUsuario("michael@techgroup.com");

			Usuario lincolnBurrows = this.bancoDeUsuarios.getUsuario("linc_burrows@techgroup.com");

			saraTancredi.adicionaPops(1300);
			michaelScofield.adicionaPops(800);
			lincolnBurrows.adicionaPops(400);

			Assert.assertEquals(
					"Mais Populares: (1) Sara Tancredi 1300; (2) Michael Scofield 800; (3) Lincoln Burrows 400;",
					this.bancoDeUsuarios.exibeRanking());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void removeUsuario() {
		try {
			this.bancoDeUsuarios.removeUsuario("tbag@techgroup.com");
			Assert.fail();
		} catch (UsuarioInexistenteException erro) {
			Assert.assertEquals("Um usuarix com email tbag@techgroup.com nao esta cadastradx.", erro.getMessage());
		} catch (Exception erro) {
			Assert.fail();
		}
	}

	@Test
	public void usuarioInexistente() {
		try {
			this.bancoDeUsuarios.getUsuario("tbag@techgroup.com");
			Assert.fail();
		} catch (UsuarioInexistenteException erro) {
			Assert.assertEquals("Um usuarix com email tbag@techgroup.com nao esta cadastradx.", erro.getMessage());
		} catch (Exception erro) {
			Assert.fail();
		}
	}


}
