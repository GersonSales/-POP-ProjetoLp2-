package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;

public class HashTag implements Postavel, Comparable<HashTag> {

	private static final String TAG_INICIAL = "#";
	private String conteudo;

	public HashTag(String conteudo) throws EntradaException {
		if (!(conteudo.matches(getMarcacao()))) {
			throw new EntradaException(
					"As hashtags devem comecar com '#'. Erro na hashtag: '"
							+ conteudo + "'.");
		}

		this.conteudo = conteudo;
	}

	public static String getMarcacao() {
		return TAG_INICIAL + "\\S+";
	}

	@Override
	public String toString() {
		return getConteudo().replace(" ", ",");
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
	public boolean equals(Object objeto) {
		if (objeto instanceof TuplaHashtag) {
			TuplaHashtag tuplaHashtag = (TuplaHashtag) objeto;
			return tuplaHashtag.equals(this);
		}

		if (objeto instanceof HashTag) {
			HashTag outraHashtag = (HashTag) objeto;
			if (getConteudo().equals(outraHashtag.getConteudo())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(HashTag outraHashtag) {
		return getConteudo().compareToIgnoreCase(outraHashtag.getConteudo());
	}

}
