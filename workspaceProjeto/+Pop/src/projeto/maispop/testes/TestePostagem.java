package projeto.maispop.testes;


import java.util.HashMap;

import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.postagem.FabricaPostavel;
import projeto.maispop.postagem.HashTag;

public class TestePostagem {

	public void test() throws EntradaException {
		String teste = "Hoje o sol me acordou. Foi muito cansativo sair da cama pois ainda estava com muito sono. Gostaria ter mais tempo para dormir. Ainda bem que tinha tapioca e cuscuz no cafe da manha para dar energia. #cafe #acorda";
		try {
			FabricaPostavel.getListaMidia(teste);
		}catch(Throwable erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	
	@Test
	public void testeHashTag() {
		try {
			HashTag casa= new HashTag("#casa");
			HashTag casa2 = new HashTag("#casa");

			System.out.println("casa".compareTo("Ca3"));
			System.out.println(casa.equals(casa2));
		} catch (EntradaException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test 
	public void testeTupla() throws EntradaException {
		
		HashTag hashtag = new HashTag("#teste");
		Integer inteiro = new Integer(10);
		
		
		
		
		
	}
}
