package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;

public class Mensagem implements Postavel{

	public static String getMarcacao() {
		return "Mensagem";
	}
	
	private String conteudo;

	public Mensagem(String conteudo) throws EntradaException {
		if (conteudo.length() >= 200) {
			throw new EntradaException(
					"O limite maximo da mensagem sao 200 caracteres.");
		}
		
		this.conteudo = conteudo;
	}

	@Override
	public String getConteudo() {
		return this.conteudo;
	}

	@Override
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
		
	}

	@Override
	public String toString() {
		return getConteudo();
	}


}
