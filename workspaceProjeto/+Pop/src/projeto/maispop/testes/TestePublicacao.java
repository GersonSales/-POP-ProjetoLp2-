package projeto.maispop.testes;

import org.junit.Test;


public class TestePublicacao {

	@Test
	public void teste() {
		String texto = "sdasd asd asd s                          ";
		System.out.println(texto);
		System.out.println(removeUltimoEspaco(texto));
	}

	private String removeUltimoEspaco(String texto) {
		if (texto.charAt(texto.length() - 1) != ' ') {
			return texto;
		}

		texto = texto.substring(0, texto.length() - 1);
		return removeUltimoEspaco(texto);
	}
}
