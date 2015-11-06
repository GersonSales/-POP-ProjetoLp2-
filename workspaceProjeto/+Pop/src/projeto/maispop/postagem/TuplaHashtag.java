package projeto.maispop.postagem;

public class TuplaHashtag implements Comparable<TuplaHashtag> {

	private HashTag hashtag;
	private Integer contador;

	public TuplaHashtag(HashTag hashtag, Integer contador) {
		this.hashtag = hashtag;
		this.contador = contador;
	}

	@Override
	public int compareTo(TuplaHashtag outraTupla) {
		if (getContador() == outraTupla.getContador()) {
			return getHashtag().compareTo(outraTupla.getHashtag());
		}
		return getContador() - outraTupla.getContador();
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof HashTag) {
			HashTag outraHashtag = (HashTag) objeto;
			return outraHashtag.equals(getHashtag());
		}

		if (objeto instanceof TuplaHashtag) {
			TuplaHashtag outraTupla = (TuplaHashtag) objeto;
			if (outraTupla.getHashtag().equals(getHashtag())) {
				return true;
			}
		}
		return false;
	}

	public Integer getContador() {
		return this.contador;
	}

	public HashTag getHashtag() {
		return this.hashtag;
	}

	public void incrementaEmUm() {
		this.contador++;
	}

	@Override
	public String toString() {
		return getHashtag() + ": " + getContador();
	}

}
