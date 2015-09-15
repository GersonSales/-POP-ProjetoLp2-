package projeto.maispop.testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import projeto.maispop.midia.Audio;
import projeto.maispop.midia.HashTag;
import projeto.maispop.midia.Imagem;
import projeto.maispop.midia.Mensagem;
import projeto.maispop.midia.Midia;
import projeto.maispop.midia.FabricaMidia;

public class TestePublicacao {

	@Test
	public void teste() {
		Midia audio = new Audio("<audio>musicas/poderosas.mp3</audio>");
		System.out.println("syso audio: " + audio);
		System.out.println("syso audio.getConteudo(): " + audio.getConteudo());

		System.out.println();

		Midia imagem = new Imagem(
				"<imagem>imagens/encontro_vinheta.jpg</imagem>");
		System.out.println("syso imagem: " + imagem);
		System.out
				.println("syso imagem.getConteudo(): " + imagem.getConteudo());

		System.out.println();

		Midia hashTag = new HashTag("#casa #de #joao");
		System.out.println("syso hashTag: " + hashTag);
		System.out.println("syso hashTag.getConteudo(): "
				+ hashTag.getConteudo());

		System.out.println();

		Midia mensagem = new Mensagem("Teste de mensagem padrao.");
		System.out.println("syso mensagem: " + mensagem);
		System.out.println("syso mensagem.getConteudo(): "
				+ mensagem.getConteudo());

		System.out.println();

		System.out.println(mensagem + " " + audio.getConteudo());

		System.out.println();

		String postagem = "O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> #encontro SemPreconceito";
		quebraPostagem(postagem);
		
	}

	public List<Midia> quebraPostagem(String postagem) {
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
			}

			if (adiciona) {
				texto = texto == "" ? texto + string : texto + " " + string;
			}
			
		}

		listaMidia.add(0, FabricaMidia.MENSAGEM.getMidia(texto));
		System.out.println(listaMidia);

		return listaMidia;
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
		}else {
			return conteudo.getConteudo();
		}
		
	}

}
