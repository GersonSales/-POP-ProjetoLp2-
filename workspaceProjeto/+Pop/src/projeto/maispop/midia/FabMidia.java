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
		List<Midia> listaMidia = new ArrayList<>();
		
		String[] listaConteudo= conteudo.split(" ");
		
		
		for (String string : listaConteudo) {
			
			if (string.contains("<audio>")) {
				listaMidia.add(fabricaAudio(string));
				conteudo.replace(string, "");
				conteudo.replace('a', 'x');
				
			}else if (string.contains("<imagem")) {
				listaMidia.add(fabricaImagem(string));
				conteudo.replace(string, "");
				
			}else if (string.contains("#")) {
				listaMidia.add(fabricaHashTag(string));
				conteudo.replace(string, "");
			}
			
			
			
			
		}
		
		listaMidia.add(0, fabricaMensagem(conteudo));
		
		
		return listaMidia;
		
	}
	
	
	
	

}
