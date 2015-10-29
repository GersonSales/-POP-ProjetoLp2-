package projeto.maispop.postagem;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class BancoHashtag {

	private static BancoHashtag instancia;
	private Map<HashTag, Integer> mapaHashtags;
	private Set<HashTag> melhores;

	private BancoHashtag() {
		this.mapaHashtags = new TreeMap<>();
		this.melhores = new HashSet<>();
	}

	public static BancoHashtag getInstancia() {
		if (instancia == null) {
			instancia = new BancoHashtag();
		}
		return instancia;
	}

	public void adicionaHashtag(HashTag hashtag) {
		atualizaMapa(hashtag);
	}

	public void adicionaTodasHashtags(List<HashTag> hashtags) {
		atualizaMapa(hashtags);
	}

	public void printaHashtag() {
		for (Map.Entry<HashTag, Integer> par : this.mapaHashtags.entrySet()) {
			System.out.println(par);
		}
		printTresMelhores();
	}

	private void atualizaMapa(List<HashTag> hashtags) {
		for (HashTag hashTag : hashtags) {
			atualizaMapa(hashTag);
		}
	}

	private void atualizaMapa(HashTag hashtag) {
		if (this.mapaHashtags.containsKey(hashtag)) {
			this.mapaHashtags.put(hashtag, this.mapaHashtags.get(hashtag) + 1);
		}else {
			this.mapaHashtags.put(hashtag, 1);
		}
	}
	
	public void printTresMelhores() {
			
		Set<Entry<HashTag, Integer>> teste = this.mapaHashtags.entrySet();
		Collections.sort(teste);
		System.out.println(teste);
	}

}
