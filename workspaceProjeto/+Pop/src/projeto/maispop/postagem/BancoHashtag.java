package projeto.maispop.postagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class BancoHashtag {

	public static BancoHashtag getInstancia() {
		if (instancia == null) {
			instancia = new BancoHashtag();
		}
		return instancia;
	}
	private static BancoHashtag instancia;

	private List<TuplaHashtag> listaTuplas;

	private BancoHashtag() {
		this.listaTuplas = new ArrayList<>();
	}

	public void adiciona(HashTag hashtag) {
		if (!(this.listaTuplas.contains(hashtag))) {
			TuplaHashtag novaTupla = new TuplaHashtag(hashtag, 1);
			this.listaTuplas.add(novaTupla);
		} else {
			int indiceTupla = this.listaTuplas.indexOf(hashtag);
			TuplaHashtag tupla = this.listaTuplas.get(indiceTupla);
			tupla.incrementaEmUm();

		}
	}

	public void adicionaTodas(Set<HashTag> hashtags) {
		for (HashTag hashTag : hashtags) {
			adiciona(hashTag);
		}
	}

	public String get3Melhores() {
		ordenaDecrescente();
		StringBuilder melhores = new StringBuilder();
		melhores.append("Trending Topics:  ");
		for (int i = 0; i < 3; i++) {
			melhores.append("(" + (i + 1) + ") " + listaTuplas.get(i) + "; ");
		}
		melhores.deleteCharAt(melhores.length() - 1);

		return melhores.toString();
	}

	private void ordenaDecrescente() {
		Collections.sort(this.listaTuplas,
				(tupla, outraTupla) -> (outraTupla.compareTo(tupla)));
	}

}
