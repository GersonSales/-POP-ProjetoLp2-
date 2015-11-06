package projeto.maispop.testes;

import org.junit.Assert;
import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.postagem.Postagem;

public class TestePostagem {

	@Test
	public void criacaoInvalida() {
		// Quantidade de caracteres invalida
		try {
			@SuppressWarnings("unused")
			Postagem postagem = new Postagem(
					"Hoje o sol me acordou. Foi muito cansativo sair da cama pois ainda estava com muito sono. Gostaria ter mais tempo para dormir. Ainda bem que tinha tapioca e cuscuz no cafe da manha para dar a energia. #cafe #acorda",
					"02/08/2015 09:30:00");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals(
					"O limite maximo da mensagem sao 200 caracteres.",
					erro.getMessage());
		}

		// Erro de hashtag
		try {
			@SuppressWarnings("unused")
			Postagem postagem = new Postagem(
					"Depois do programa vou almocar com a familia. #familia almoco #paz",
					"02/08/2015 11:48:00");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals(
					"As hashtags devem comecar com '#'. Erro na hashtag: 'almoco'.",
					erro.getMessage());
		}

		// Erro de formato data
		try {
			@SuppressWarnings("unused")
			Postagem postagem = new Postagem(
					"Testanto formato de data invalido.",
					"022/08/2015 11:48:00");
			Assert.fail();
		} catch (Exception erro) {
			Assert.assertEquals("Formato de data esta invalida.",
					erro.getMessage());
		}

		// Erro de data inexistente
		try {
			@SuppressWarnings("unused")
			Postagem postagem = new Postagem("Teste em data inexistente",
					"12/15/2015 11:48:00");
			Assert.fail();
		} catch (Exception erro) {
			Assert.assertEquals("Data nao existe.", erro.getMessage());
		}

	}

	@Test
	public void criacaoValida() {
		try {
			Postagem postagem = new Postagem(
					"O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> #encontro #SemPreconceito",
					"01/08/2015 20:12:00");

			Assert.assertEquals(
					"O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola.",
					postagem.getConteudo(0));

			Assert.assertEquals("$arquivo_imagem:imagens/encontro_vinheta.jpg",
					postagem.getConteudo(1));

			Assert.assertEquals("$arquivo_imagem:imagens/encontro_preview.jpg",
					postagem.getConteudo(2));

			Assert.assertEquals(
					"O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem>",
					postagem.getMensagem());

			Assert.assertEquals("#encontro,#SemPreconceito",
					postagem.getHashTags());

			Assert.assertEquals("2015-08-01 20:12:00", postagem.getData());

			Assert.assertEquals(0, postagem.getPopularidade());

			Assert.assertEquals(0, postagem.getCurtir());

			Assert.assertEquals(0, postagem.getDescurtir());

		} catch (Exception erro) {
			Assert.fail();
		}
	}

	@Test
	public void curtirDescurtir() {
		try {
			Postagem postagem = new Postagem("Nova postagem",
					"12/12/2012 12:12:12");

			postagem.curtir(10);
			postagem.curtir(10);
			postagem.curtir(10);

			Assert.assertEquals(3, postagem.getCurtir());

			postagem.descurtir(10);
			postagem.descurtir(15);

			Assert.assertEquals(2, postagem.getDescurtir());

			Assert.assertEquals(5, postagem.getPopularidade());
		} catch (Exception erro) {
			Assert.fail();
		}
	}

	@Test
	public void adicionaHashtag() {
		try {
			Postagem postagem = new Postagem("", "12/12/2012 12:12:12");

			Assert.assertEquals("", postagem.getHashTags());

			postagem.adicionaHashTag("#testar");

			Assert.assertEquals("#testar", postagem.getHashTags());

			postagem.adicionaHashTag("#postagem");

			Assert.assertEquals("#testar,#postagem", postagem.getHashTags());

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			Assert.fail();
		}

	}

	@Test
	public void igualdade() {

		try {
			Postagem postagemUsr1 = new Postagem("", "12/12/2012 12:12:12");
			Postagem postagemUsr2 = new Postagem("", "12/12/2012 12:12:12");

			Assert.assertTrue(postagemUsr1.equals(postagemUsr2));
		} catch (Exception erro) {
			Assert.fail();
		}

		try {
			Postagem postagemUsr1 = new Postagem("Postagem de teste.",
					"12/12/2012 12:12:12");
			Postagem postagemUsr2 = new Postagem(
					"Postagem de teste. <imagem>teste.jpg</imagem>",
					"12/12/2012 12:12:12");

			Assert.assertFalse(postagemUsr1.equals(postagemUsr2));
		} catch (Exception erro) {
			Assert.fail();
		}
	}

}
