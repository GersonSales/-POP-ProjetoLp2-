package projeto.maispop.midia;


import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import projeto.maispop.excecoes.EntradaException;

public class FabMidia {
	
	@SuppressWarnings("unused")
	private Audio fabricaAudio(String conteudo) {
		return new Audio(conteudo);
	}
	
	@SuppressWarnings("unused")
	private Imagem fabricaImagem(String conteudo) {
		return new Imagem(conteudo);
	}
	
	@SuppressWarnings("unused")
	private HashTag fabricaHashTag(String conteudo) {
		return new HashTag(conteudo);
	}
	
	
	@SuppressWarnings("unused")
	private Mensagem fabricaMensagem(String conteudo) throws EntradaException {
		return new Mensagem(conteudo);
	}
	
	
	public Midia fabricaMidia(String conteudo) {
		List<Midia> listaMidia = new ArrayList<>();
		
		String[] listaConteudo= conteudo.split(" ");
		
		
		String texto = "";
		
		for (String string : listaConteudo) {
			
			if (string.contains("<audio>")) {
				
			}
			
			
		}
		
		
		throw new RuntimeErrorException(null);
		
		
		
	}
	
	
	
	

}
