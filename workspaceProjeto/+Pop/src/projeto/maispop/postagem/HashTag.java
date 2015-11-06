package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;

public class HashTag implements Postavel, Comparable<HashTag> {

	public static String getMarcacao() {
		return TAG_INICIAL + "\\S+";
	}
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

	@Override
	public int compareTo(HashTag outraHashtag) {
		return getConteudo().compareTo(outraHashtag.getConteudo());
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
	public String getConteudo() {
		return this.conteudo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conteudo == null) ? 0 : conteudo.hashCode());
		return result;
	}

	@Override
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return getConteudo().replace(" ", ",");
	}

}
