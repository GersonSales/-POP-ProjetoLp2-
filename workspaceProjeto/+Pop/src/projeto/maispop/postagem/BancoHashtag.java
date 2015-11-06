package projeto.maispop.postagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * A <code>BancoHashtag</code> class eh responsavel por administrar todas as
 * informacoes relacionadas a todos os objetos do tipo <code>Hashtag</code>
 * presentes no sistema.
 * 
 * @author Gerson Sales
 * @see TuplaHashtag
 * @see Hashtag
 */
public class BancoHashtag {

	/**
	 * Metodo pertencente a classe, responsavel por retornar a instancia de
	 * <code>BancoHashtag</code> caso ela exista ou criar uma nova caso nao.
	 * 
	 * @return instancia de <code>BancoHashtag</code>.
	 */
	public static BancoHashtag getInstancia() {
		if (instancia == null) {
			instancia = new BancoHashtag();
		}
		return instancia;
	}

	private static BancoHashtag instancia;

	private List<TuplaHashtag> listaTuplas;

	/**
	 * Construtor privado da classe <code>BancoHashtag</code>. Responsavel por
	 * deixar sua contrucao exclusiva a si propria, tendo assim apenas uma
	 * instancia da mesma em todo tempo de execucao.
	 */
	private BancoHashtag() {
		this.listaTuplas = new ArrayList<>();
	}

	/**
	 * Responsavel por receber como parametro um objeto do tipo
	 * <code>Hashtag</code> e adicionalo ao campo de armazenamento de
	 * <code>TuplaHashtag</code>. Caso exista, o contador de ocorrencias da
	 * mesma sera incrementada em 1(um). Caso nao, sera criado um novo objeto do
	 * tipo <code>TuplaHashtag</code> e adiciona-lo ao campo de armazenamento.
	 * 
	 * @param hashtag
	 *            objeto <code>Hashtag</code> que sera inserido no campo de
	 *            armazenamento.
	 */
	public void adiciona(Hashtag hashtag) {
		if (!(this.listaTuplas.contains(hashtag))) {
			TuplaHashtag novaTupla = new TuplaHashtag(hashtag, 1);
			this.listaTuplas.add(novaTupla);
		} else {
			int indiceTupla = this.listaTuplas.indexOf(hashtag);
			TuplaHashtag tupla = this.listaTuplas.get(indiceTupla);
			tupla.incrementaEmUm();

		}
	}

	/**
	 * Responsavel por adicionar todas os objetos do tipo <code>Hashtag</code>
	 * presentes em uma colecao recebida como parametro.
	 * 
	 * @param hashtags
	 *            <code>Set</code> contendo uma serie de objetos
	 *            <code>Hashtag</code>'s.
	 */
	public void adicionaTodas(Set<Hashtag> hashtags) {
		for (Hashtag hashTag : hashtags) {
			adiciona(hashTag);
		}
	}

	/**
	 * Responsavel por retornar uma representacao em string das principais
	 * <code>Hashtag</code>'s presente no <code>BancoHashtag</code>, ou seja, as
	 * que tiverem o maior numero de ocorrencia.
	 * 
	 * @return string que representa as tres <code>Hashtag</code>'s mais
	 *         utilizadas.
	 */
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

	/**
	 * Responsaval por ordenar o campo de armazenamento de forma decrescente.
	 */
	private void ordenaDecrescente() {
		Collections.sort(this.listaTuplas,
				(tupla, outraTupla) -> (outraTupla.compareTo(tupla)));
	}

}
