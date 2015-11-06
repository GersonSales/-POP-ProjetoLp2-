package projeto.maispop.testes;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.postagem.FabricaPostavel;
import projeto.maispop.postagem.Postavel;

public class TesteFabricaPostavel {

	@Test
	public void criacaoEmConjunto() {
		try {
			List<Postavel> listaPostavel = FabricaPostavel
					.getListaPostavel("O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> #encontro #SemPreconceito");

			Assert.assertEquals(
					"O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola.",
					listaPostavel.get(0).toString());

			Assert.assertEquals("$arquivo_imagem:imagens/encontro_vinheta.jpg",
					listaPostavel.get(1).toString());

			Assert.assertEquals("$arquivo_imagem:imagens/encontro_preview.jpg",
					listaPostavel.get(2).toString());

			Assert.assertEquals("#encontro", listaPostavel.get(3).toString());

			Assert.assertEquals("#SemPreconceito", listaPostavel.get(4)
					.toString());
		} catch (Exception erro) {
			Assert.fail();
		}

	}

	@Test
	public void criacaoIndividualInvalida() {
		// criacao Hashtag
		try {
			FabricaPostavel.HASHTAG.getInstancia("hashtag");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals(
					"As hashtags devem comecar com '#'. Erro na hashtag: 'hashtag'.",
					erro.getMessage());
		} catch (Exception erro) {
			Assert.fail();
		}

		// criacao audio
		try {
			FabricaPostavel.AUDIO.getInstancia("<audio>musica.mp3<audio>");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals(
					"O audio deve iniciar com <audio> e terminar com </audio>.",
					erro.getMessage());
		} catch (Exception erro) {
			Assert.fail();
		}

		// criacao imagem
		try {
			FabricaPostavel.IMAGEM.getInstancia("<imagem>imagem.jpg<imagem");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals(
					"A imagem deve iniciar com <imagem> e terminar com </imagem>.",
					erro.getMessage());
		} catch (Exception erro) {
			Assert.fail();
		}

		// criacao mensagem
		try {
			FabricaPostavel.MENSAGEM
					.getInstancia("“Em ciência da computação, programação funcional é um paradigma de programação que trata a computação como uma avaliação de funções matemáticas e que evita estados ou dados mutáveis. Ela enfatiza a aplicação de funções, em contraste da programação imperativa, que enfatiza mudanças no estado do programa.”");
			Assert.fail();
		} catch (EntradaException erro) {
			Assert.assertEquals(
					"O limite maximo da mensagem sao 200 caracteres.",
					erro.getMessage());
		} catch (Exception erro) {
			Assert.fail();
		}
	}

	@Test
	public void criacaoValida() {
		try {
			Postavel hashtag = FabricaPostavel.HASHTAG.getInstancia("#hashtag");
			Assert.assertEquals("#hashtag", hashtag.toString());
			Assert.assertEquals("#hashtag", hashtag.getConteudo());

			Postavel audio = FabricaPostavel.AUDIO
					.getInstancia("<audio>musica.mp3</audio>");
			Assert.assertEquals("$arquivo_audio:musica.mp3", audio.toString());
			Assert.assertEquals("<audio>musica.mp3</audio>",
					audio.getConteudo());

			Postavel imagem = FabricaPostavel.IMAGEM
					.getInstancia("<imagem>imagem.jpg</imagem>");
			Assert.assertEquals("$arquivo_imagem:imagem.jpg", imagem.toString());
			Assert.assertEquals("<imagem>imagem.jpg</imagem>",
					imagem.getConteudo());

			Postavel mensagem = FabricaPostavel.MENSAGEM
					.getInstancia("O limite maximo da mensagem sao 200 caracteres.");
			Assert.assertEquals(
					"O limite maximo da mensagem sao 200 caracteres.",
					mensagem.toString());
			Assert.assertEquals(
					"O limite maximo da mensagem sao 200 caracteres.",
					mensagem.getConteudo());

		} catch (Exception erro) {
			Assert.fail();
		}
	}
}
