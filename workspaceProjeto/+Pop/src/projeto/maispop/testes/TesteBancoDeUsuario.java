package projeto.maispop.testes;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.maispop.excecoes.EmailException;
import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.LogicaException;
import projeto.maispop.excecoes.UsuarioExistenteException;
import projeto.maispop.sistema.BancoDeUsuarios;

public class TesteBancoDeUsuario {
	SortedMap<String, Integer> hashtags;

	@Before
	public void testeBancoDeUsuario() {
		this.hashtags = new TreeMap<>();

	}
	
	


	@Test
	public void testeTreeMap() {
		
		String casa = "#casa";
		Integer ocorrenciaCasa = 1;
		
		adicionaHashtag(casa, ocorrenciaCasa);
		imprimeMapa();
		
		String partiu = "#partiu";
		Integer ocorrenciaPartiu = 5;
		
		adicionaHashtag(partiu, ocorrenciaPartiu);
		imprimeMapa();
		
		String partiu2 = "#partiu";
		Integer ocorrenciaPartiu2 = 6;
		
		adicionaHashtag(partiu2, ocorrenciaPartiu2);
		imprimeMapa();
		

	}
	
	
	
	public void imprimeMapa() {
		System.out.println(this.hashtags);
	}
	
	
	public void adicionaHashtag(String hashtag, Integer ocorrencia) {
		this.hashtags.put(hashtag, ocorrencia);
		
	}

	
	
	
//	public void adicionaHashtag(String hashtag, Integer ocorrencia) {
//		
//		if (this.hashtags.containsKey(ocorrencia)) {
//			this.hashtags.get(ocorrencia).add(hashtag);
//		} else {
//			Set<String> setHashtags = new HashSet<>();
//			setHashtags.add(hashtag);
//
//			this.hashtags.put(ocorrencia, setHashtags);
//		}
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
