package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;

/**
 * O <code>Hashtag</code> class representa a implementacao de um objeto tipo
 * <code>Postavel</code>. Esta classe armazenara todas informacoes necessarias
 * para a verificacao e representacao de um objeto <code>Hashtag</code>.
 * 
 * @author Gerson Sales
 * @see Postavel
 * @see TuplaHashtag
 */
public class Hashtag implements Postavel, Comparable<Hashtag> {

	private static final long serialVersionUID = 5869536888630180039L;

	/**
	 * Retorna a formatacao adequada para a representacao do objeto
	 * <code>Hashtag</code>.
	 * 
	 * @return O resultado da String.
	 */
	public static String getMarcacao() {
		return TAG_INICIAL + "\\S+";
	}

	private static final String TAG_INICIAL = "#";

	private String conteudo;

	/**
	 * Construtor da classe <code>Hashtag</code> que recebe uma string como
	 * parametro a string que sera verificada. Caso a string obedeca a forma
	 * adequada de criacao do objeto, uma nova instancia de <code>Hashtag</code>
	 * sera criada.
	 * 
	 * @param conteudo
	 *            String a ser verificada.
	 * @throws EntradaException
	 *             sera lancada caso o parametro recebido nao obedeca as regras
	 *             de criacao;
	 */
	public Hashtag(String conteudo) throws EntradaException {
		if (!(conteudo.matches(getMarcacao()))) {
			throw new EntradaException(
					"As hashtags devem comecar com '#'. Erro na hashtag: '"
							+ conteudo + "'.");
		}

		this.conteudo = conteudo;
	}

	/** Comparara dois objetos em relacao a grandeza de cada um. */
	@Override
	public int compareTo(Hashtag outraHashtag) {
		return getConteudo().compareToIgnoreCase(outraHashtag.getConteudo());
	}

	/**
	 * Indica quando um objeto eh igual ao outro.
	 * 
	 * @return valor boleano para indicar a veracidade da comparacao.
	 */
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof TuplaHashtag) {
			TuplaHashtag tuplaHashtag = (TuplaHashtag) objeto;
			return tuplaHashtag.equals(this);
		}

		if (objeto instanceof Hashtag) {
			Hashtag outraHashtag = (Hashtag) objeto;
			if (getConteudo().equals(outraHashtag.getConteudo())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna a representacao de <code>Mensagem</code> recebida como parametro
	 * na construcao do objeto.
	 * 
	 * @return a string resultante da construcao.
	 */
	@Override
	public String getConteudo() {
		return this.conteudo;
	}

	/** Retorna o valor "hash code" do objeto. */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conteudo == null) ? 0 : conteudo.hashCode());
		return result;
	}

	/**
	 * Altera o campo conteudo anteriormente inicializado na construcao da
	 * classe <code>Mensagem</code>.
	 * 
	 * @param string
	 *            que atribuira o novo valor ao campo.
	 */
	@Override
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * Retorna uma representacao em String do objeto <code>Hashtag</code>,
	 * seguindo um padrao adotado por <code>Hashtag</code>. <br>
	 * 
	 * @return getConteudo().
	 */
	@Override
	public String toString() {
		return getConteudo().replace(" ", ",");
	}

}
