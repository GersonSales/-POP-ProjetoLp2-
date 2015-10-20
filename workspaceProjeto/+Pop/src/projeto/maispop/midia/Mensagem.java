package projeto.maispop.midia;

import projeto.maispop.excecoes.EntradaException;

public class Mensagem implements Postavel{

	private String conteudo;
	
	public Mensagem(String conteudo) throws EntradaException {
		if (conteudo.length() >= 200) {
			throw new EntradaException(
					"O limite maximo da mensagem sao 200 caracteres.");
		}
		
		this.conteudo = conteudo;
	}

	public static String getMarcacao() {
		return "Mensagem";
	}

	@Override
	public String toString() {
		return getConteudo();
	}

	@Override
	public String getConteudo() {
		return this.conteudo;
	}

	@Override
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
		
	}


}
