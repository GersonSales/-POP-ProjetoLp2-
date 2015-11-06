package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;


public class Audio extends Midia {

	private static final CharSequence TAG_INICIAL = "<audio>";
	private static final CharSequence TAG_FINAL = "</audio>";

	public Audio(String conteudo) throws EntradaException {
		super(conteudo);

		if (!(conteudo.matches(getMarcacao()))) {
			throw new EntradaException("O audio deve iniciar com "
					+ TAG_INICIAL + " e terminar com " + TAG_FINAL + ".");
		}
	}

	public static String getMarcacao() {
		return TAG_INICIAL + ".+" + TAG_FINAL;
	}

	@Override
	public String toString() {
		String conteudo;
		conteudo = getConteudo().replace(TAG_INICIAL, "");
		conteudo = conteudo.replace(TAG_FINAL, "");
		conteudo = "$arquivo_audio:" + conteudo;

		return conteudo;
	}

}
