package testes.pop.midia;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class TesteAlgoritmos {

	
	@Test
	public void testeTexto() {
		
		String[] teste = new String[5];
		teste[0] = "t1";
		teste[1] = "t2";
		imprimeStrings(teste);
		
	}

	
	public void imprimeStrings(String... string) {
		int cont = 1;
		for (String string2 : string) {
			System.out.println("Nome: " + string2 + "\nNumero: " + cont);
			System.out.println();
			cont ++;
			
		}
		
		
	}
}
