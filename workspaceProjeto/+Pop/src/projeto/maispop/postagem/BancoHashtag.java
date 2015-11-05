package projeto.maispop.postagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class BancoHashtag {

	private static BancoHashtag instancia;
	private List<TuplaHashtag> listaTuplas;

	public static BancoHashtag getInstancia() {
		if (instancia == null) {
			instancia = new BancoHashtag();
		}
		return instancia;
	}

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

	private void ordenaDecrescente() {
		Collections.sort(this.listaTuplas, new Comparator<TuplaHashtag>() {
			@Override
			public int compare(TuplaHashtag tupla, TuplaHashtag outraTupla) {
				return outraTupla.compareTo(tupla);
			}

		});
	}

	public String get3Melhores() {
		ordenaDecrescente();
		StringBuilder melhores = new StringBuilder();
		melhores.append("Trending Topics:  ");
		for (int i = 0; i < 3; i++) {
			melhores.append("(");
			melhores.append((i + 1));
			melhores.append(") ");
			melhores.append(listaTuplas.get(i));
			melhores.append("; ");
		}
		melhores.deleteCharAt(melhores.length() - 1);

		return melhores.toString();
	}

}
