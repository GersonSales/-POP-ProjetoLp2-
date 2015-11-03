package projeto.maispop.postagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	public void adicionaTodas(List<HashTag> hashtags) {
		for (HashTag hashTag : hashtags) {
			adiciona(hashTag);
		}
	}

	@SuppressWarnings("unused")
	private void ordenaCrescente() {
		Collections.sort(this.listaTuplas);
	}

	private void ordenaDecrescente() {
		Collections.sort(this.listaTuplas, new Comparator<TuplaHashtag>() {
			@Override
			public int compare(TuplaHashtag tupla, TuplaHashtag outraTupla) {
				return outraTupla.compareTo(tupla);
			}

		});
	}

	public void get3Melhores() {
		ordenaDecrescente();
		int cont = 0;
		for (TuplaHashtag tuplaHashtag : listaTuplas) {
			if (cont == 3)
				break;
			System.out.println(tuplaHashtag);
			cont++;

		}

	}

}
