package projeto.maispop.midia;

import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;

public class FabMidia {

	private Audio fabricaAudio(String conteudo) {
		return new Audio(conteudo);
	}

	private Imagem fabricaImagem(String conteudo) {
		return new Imagem(conteudo);
	}

	private HashTag fabricaHashTag(String conteudo) {
		return new HashTag(conteudo);
	}

	private Mensagem fabricaMensagem(String conteudo) throws EntradaException {
		return new Mensagem(conteudo);
	}

	public List<Midia> fabricaMidia(String conteudo) throws EntradaException {
		// O Encontro de amanha estara otimo. Vamos falar sobre os problemas do
		// preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem>
		// <imagem>imagens/encontro_preview.jpg</imagem> #encontro
		// #SemPreconceito"
		
		
		//List<Midia> listaMidia = new ArrayList<>();
		String [] conteudoSplit = conteudo.split(" ");
		for (String string : conteudoSplit) {
			System.out.println(string);
		}
		
		return null;
		
		
	}

}
