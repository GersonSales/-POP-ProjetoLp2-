package projeto.maispop.testes;


import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.midia.FabricaPostavel;

public class TestePostagem {

	@Test
	public void test() throws EntradaException {
		String teste = "Hoje o sol me acordou. Foi muito cansativo sair da cama pois ainda estava com muito sono. Gostaria ter mais tempo para dormir. Ainda bem que tinha tapioca e cuscuz no cafe da manha para dar energia. #cafe #acorda";
		try {
			FabricaPostavel.getListaMidia(teste);
		}catch(Throwable erro) {
			System.out.println(erro.getMessage());
		}
	}
}
