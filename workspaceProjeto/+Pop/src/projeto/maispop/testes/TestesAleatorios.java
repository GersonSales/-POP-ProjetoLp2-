package projeto.maispop.testes;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.postagem.HashTag;

public class TestesAleatorios {

	@Test
	public void test() {
		try {
			HashTag casa= new HashTag("#epicfail");
			HashTag partiu= new HashTag("#epicfail");
			HashTag dormir = new HashTag("#epicfail");

			
			Set<HashTag> hashtags = new HashSet<>();
			
			HashTag epicfail = new HashTag("#epicfail");
			System.out.println("adiciona epicfail: " + hashtags.add(epicfail));
			System.out.println("adiciona epicfail: " + hashtags.add(epicfail));
			
			
			HashTag epicfail2 = new HashTag("#epicfail");
			System.out.println("adiciona epicfail: " + hashtags.add(epicfail2));
			System.out.println("adiciona epicfail: " + hashtags.add(epicfail2));
			
			
			
			HashTag epicfail3 = new HashTag("#epicfail");
			System.out.println("adiciona epicfail: " + hashtags.add(epicfail3));
			System.out.println("adiciona epicfail: " + hashtags.add(epicfail3));

			

			
			

			
			
			

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

	}

}
