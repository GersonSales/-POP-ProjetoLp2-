package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;

/**
 * O <code>Audio</code> class representa um objeto tipo <code>Midia</code>. Esta
 * classe armazenara todas informacoes necessarias para a verificacao e
 * representacao de um objeto <code>Audio</code>.
 * 
 * @author Gerson Sales
 * @see Midia
 */
public class Audio extends Midia {

	private static final long serialVersionUID = -3158309023696281505L;

	/**
	 * Retorna a formatacao adequada para a representacao do objeto
	 * <code>Audio</code>.
	 * 
	 * @return O resultado da String.
	 */
	public static String getMarcacao() {
		return TAG_INICIAL + ".+" + TAG_FINAL;
	}

	/** Marcacao inicial para a representacao de <code>Audio</code> */
	private static final CharSequence TAG_INICIAL = "<audio>";

	/** Marcacao final para a representacao de <code>Audio</code> */
	private static final CharSequence TAG_FINAL = "</audio>";

	/**
	 * Construtor da classe <code>Audio</code> que recebe uma string como
	 * parametro a string que sera verificada. Caso a string obedeca a forma
	 * adequada de criacao do objeto, uma nova instancia de <code>Audio</code>
	 * sera criada.
	 * 
	 * @param conteudo
	 *            String a ser verificada.
	 * @throws EntradaException
	 *             sera lancada caso o parametro recebido nao obedeca as regras
	 *             de criacao;
	 */
	public Audio(String conteudo) throws EntradaException {
		super(conteudo);

		if (!(conteudo.matches(getMarcacao()))) {
			throw new EntradaException("O audio deve iniciar com "
					+ TAG_INICIAL + " e terminar com " + TAG_FINAL + ".");
		}
	}

	/**
	 * Retorna uma representacao em String do objeto <code>Audio</code>,
	 * seguindo um padrao adotado por <code>Midia</code>. <br>"$arquivo_" +
	 * getClass.getName().toLowerCase() + ":" + getConteudo()
	 */
	@Override
	public String toString() {
		String conteudo;
		conteudo = getConteudo().replace(TAG_INICIAL, "");
		conteudo = conteudo.replace(TAG_FINAL, "");
		conteudo = "$arquivo_audio:" + conteudo;
		return conteudo;
	}

}
