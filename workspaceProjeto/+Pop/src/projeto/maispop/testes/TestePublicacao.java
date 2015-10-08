package projeto.maispop.testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.midia.Audio;
import projeto.maispop.midia.FabMidia;
import projeto.maispop.midia.HashTag;
import projeto.maispop.midia.Imagem;
import projeto.maispop.midia.Mensagem;
import projeto.maispop.midia.Midia;
import projeto.maispop.midia.FabricaMidia;

public class TestePublicacao {

	
	@Test
	public void testeFabMidia() throws EntradaException {
		FabMidia fabMidia = new FabMidia();
		String postagem = "Nao sei porque tanto recalque, o que eh bonito eh pra se mostrar. <audio>musicas/poderosas.mp3</audio> #soulinda #naza";
		
		System.out.println(fabMidia.fabricaMidia(postagem));
		
		
	}
	
	
	
	public void teste() throws EntradaException {
		String postagem = "O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> encontro #SemPreconceito";
		quebraPostagem(postagem);

		String erroHashTag = "Depois do programa vou almocar com a familia. #familia almoco #paz";
		quebraPostagem(erroHashTag);

		String postagemNaza = "Nao sei porque tanto recalque, o que eh bonito eh pra se mostrar. <audio>musicas/poderosas.mp3</audio> #soulinda #naza";
		System.out.println(getPostagem(quebraPostagem(postagemNaza),
				"03/08/2015 08:21:00"));
		
		Assert.assertEquals("Nao sei porque tanto recalque, o que eh bonito eh pra se mostrar. <audio>musicas/poderosas.mp3</audio> #soulinda #naza (2015-08-03 08:21:00)", getPostagem(quebraPostagem(postagemNaza),
				"2015-08-03 08:21:00"));
		
		Assert.assertEquals("Nao sei porque tanto recalque, o que eh bonito eh pra se mostrar. <audio>musicas/poderosas.mp3</audio>", getMensagem(quebraPostagem(postagemNaza)));
		
		System.out.println();
		System.out.println("TesteLista: ");
		
		
		List<Midia> listaTeste = new ArrayList<>();
		Midia mensagem = new Mensagem("mensagem");
		Midia audio = new Audio("<audio>audio.mp3</audio>");
		Midia imagem = new Imagem("<imagem>imagem.jpg</imagem>");
		Midia hashtag = new HashTag("#hashTag");
		
		listaTeste.add(mensagem);
//		listaTeste.add(audio);
//		listaTeste.add(imagem);
		listaTeste.add(hashtag);
		listaTeste.add(hashtag);
		listaTeste.add(hashtag);
		listaTeste.add(hashtag);
		listaTeste.add(hashtag);
		listaTeste.add(hashtag);
		
		System.out.println("Lista: " + listaTeste);
		
		
		System.out.println();
		System.out.println(ultimoIndiceValido(listaTeste, listaTeste.size()));

		
		
		
	}

	public List<Midia> quebraPostagem(String postagem) throws EntradaException {
		List<Midia> listaMidia = new ArrayList<>();

		String[] postagemSplit = postagem.split(" ");
		String texto = "";

		boolean adiciona = true;
		for (String string : postagemSplit) {

			for (FabricaMidia fabMidia : FabricaMidia.values()) {
				if (string.contains(fabMidia.toString())) {
					listaMidia.add(fabMidia.getMidia(string));
					adiciona = false;
					break;
				}

				if (fabMidia == FabricaMidia.HASHTAG && !adiciona) {
					// throw new EntradaException();
					System.out
							.println("Nao eh possivel criar o post. As hashtags devem comecar com '#'. Erro na hashtag: '"
									+ string + "'.");
				}

			}

			if (adiciona) {
				texto = texto == "" ? texto + string : texto + " " + string;
				continue;
			}

		}

		listaMidia.add(0, FabricaMidia.MENSAGEM.getMidia(texto));

		return listaMidia;
	}

	private int ultimoIndiceValido(List<Midia> listaMidia, int indice) {
		if (listaMidia.get(indice - 1) instanceof HashTag) {
			return ultimoIndiceValido(listaMidia, indice - 1);
		}
		
		return indice - 1;
		
	}
	
	public String getMensagem(List<Midia> lista) {
		String saida = "";
		for (Midia midia : lista) {
			if (!(midia instanceof HashTag)) {
				saida = saida == "" ? midia.getConteudo() : saida + " "
						+ midia.getConteudo();
			}
		}

		return saida;

	}

	public String getHashTag(List<Midia> lista) {
		String saida = "";

		for (Midia midia : lista) {
			if (midia instanceof HashTag) {
				saida = saida == "" ? midia.getConteudo() : saida + ","
						+ midia.getConteudo();
			}
		}

		return saida;
	}

	public String getIndicePostagem(List<Midia> listaMidia, int indice) {
		Midia conteudo = listaMidia.get(indice);
		if (conteudo instanceof HashTag) {
			return null;
		} else {
			return conteudo.getConteudo();
		}

	}

	public String getPostagem(List<Midia> listaMidia, String dataPostagem) {
		String postagem = "";
		for (Midia midia : listaMidia) {
			postagem = postagem == "" ? midia.toString() : postagem + " "
					+ midia.getConteudo();
		}
		postagem = postagem + " (" + dataPostagem + ")";
		return postagem;
	}

}
