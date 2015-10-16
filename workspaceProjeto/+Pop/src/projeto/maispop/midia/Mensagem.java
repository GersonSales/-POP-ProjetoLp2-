package projeto.maispop.midia;

import projeto.maispop.excecoes.EntradaException;

public class Mensagem extends Midia {

	public Mensagem(String conteudo) throws EntradaException {
		super(conteudo);
		if (conteudo.length() >= 200) {
			throw new EntradaException(
					"O limite maximo da mensagem sao 200 caracteres.");
		}
	}

	public static String getMarcacao() {
		return "Mensagem";
	}

	@Override
	public String toString() {
		return getConteudo();
	}

}
