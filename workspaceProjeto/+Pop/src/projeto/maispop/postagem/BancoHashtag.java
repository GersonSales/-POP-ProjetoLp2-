package projeto.maispop.postagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoHashtag {

	private static BancoHashtag instancia;
	private Map<HashTag, Integer> mapaHashtags;

	private BancoHashtag() {
		this.mapaHashtags = new HashMap<>();
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
		for (HashTag hashTag : this.mapaHashtags.keySet()) {
			System.out.println(hashTag);
			System.out.println(this.mapaHashtags.get(hashTag));
			System.out.println();
		}
	}
	
	
	private void atualizaMapa(List<HashTag> hashtags) {
		for (HashTag hashTag : hashtags) {
			atualizaMapa(hashTag);
		}
	}
	
	private void atualizaMapa(HashTag hashtag) {
		for (Map.Entry<HashTag, Integer> par : this.mapaHashtags.entrySet()) {
			if (this.mapaHashtags.containsKey(hashtag)) {
				par.setValue(par.getValue() + 1);
			}else {
				this.mapaHashtags.put(hashtag, 1);
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
