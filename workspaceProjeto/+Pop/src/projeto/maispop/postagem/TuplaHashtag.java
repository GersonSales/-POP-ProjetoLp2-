package projeto.maispop.postagem;

/**
 * A <code>TuplaHashtag</code> class representa o armazenamento em forma de
 * tupla do objeto <code>Hashtag</code> e um campo de ocorrencia. Para ser
 * possivel a contagem de quantas vezes a mesma <code>Hashtag</code> foi
 * instanciada no sistema.
 * 
 * @author Gerson Sales
 *
 */
public class TuplaHashtag implements Comparable<TuplaHashtag> {

	private Hashtag hashtag;
	private Integer contador;

	/**
	 * Construtor da clase <code>TuplaHashtag</code> que recebe como parametro
	 * um objeto <code>Hashtag</code> e um <code>Integer</code>. Fazendo assim a
	 * associacao entre a <code>Hashtag</code> e a quantidade de vezes que ela
	 * foi instanciada.
	 * 
	 * @param hashtag
	 *            objeto do tipo <code>Hashtag</code>.
	 * @param contador
	 *            objeto tipo <code>Integer</code>.
	 */
	public TuplaHashtag(Hashtag hashtag, Integer contador) {
		this.hashtag = hashtag;
		this.contador = contador;
	}

	/**
	 * Compara e decide se dois objetos (<code>TuplaHashtag</code> <i>ou</i>
	 * <code>Hashtag</code>) sao menores, maiores ou iguais uns dos outros.
	 */
	@Override
	public int compareTo(TuplaHashtag outraTupla) {
		if (getContador() == outraTupla.getContador()) {
			return getHashtag().compareTo(outraTupla.getHashtag());
		}
		return getContador() - outraTupla.getContador();
	}

	/**
	 * Indica quando um objeto eh igual ao outro.
	 * 
	 * @return valor boleano para indicar a veracidade da comparacao.
	 */
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Hashtag) {
			Hashtag outraHashtag = (Hashtag) objeto;
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

	/**
	 * Retorna um inteiro representando o numero de ocorrencia do objeto
	 * <code>Hashtag</code>.
	 * 
	 * @return resultado da contagem.
	 */
	public Integer getContador() {
		return this.contador;
	}

	/**
	 * Retorna o objeto <code>Hashtag</code> armazenado no campo da
	 * <code>TuplaHashtag</code>.
	 * 
	 * @return
	 */
	public Hashtag getHashtag() {
		return this.hashtag;
	}

	/**
	 * Responsalvel por incrementar em uma unidade o contador de ocorrencia.
	 */
	public void incrementaEmUm() {
		this.contador++;
	}

	/**
	 * Retorna uma representacao em String do objeto <code>TuplaHashtag</code>.
	 * 
	 * @return getHashtag() + ": " + getContador().
	 */
	@Override
	public String toString() {
		return getHashtag() + ": " + getContador();
	}

}
