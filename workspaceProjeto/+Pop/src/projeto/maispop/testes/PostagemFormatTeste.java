package projeto.maispop.testes;



import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.usuario.IconePop;
import projeto.maispop.usuario.Postagem;
import projeto.maispop.usuario.TipoUsuario;

public class PostagemFormatTeste {

	@Test
	public void test() throws EntradaException {

		
	    Postagem postagemQualquer = new Postagem("Texto qualquer. <audio caminho</audio>  #teste2", "29/08/2015 04:44:23");
	    TipoUsuario usuarioCelebridade = new IconePop();
	    
	    System.out.println(postagemQualquer.getHashTags());
	    
	    usuarioCelebridade.descurtir(postagemQualquer);
	    
	    System.out.println(postagemQualquer.getHashTags());
	    
		

	}
	
	
}