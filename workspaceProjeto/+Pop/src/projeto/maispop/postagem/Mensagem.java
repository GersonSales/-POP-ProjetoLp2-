package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;

/**
 * O <code>Mensagem</code> class representa a implementacao de um objeto tipo
 * <code>Postavel</code>. Esta classe armazenara todas informacoes necessarias
 * para a verificacao e representacao de um objeto <code>Mensagem</code>.
 * 
 * @author Gerson Sales
 * @see Postavel
 */
public class Mensagem implements Postavel {

	private static final long serialVersionUID = -8593602982356135802L;

	/**
	 * Retorna a formatacao adequada para a representacao do objeto
	 * <code>Mensagem</code>.
	 * 
	 * @return O resultado da String.
	 */
	public static String getMarcacao() {
		return "Mensagem";
	}

	private String conteudo;

	/**
	 * Construtor da classe <code>Mensagem</code> que recebe uma string como
	 * parametro a string que sera verificada. Caso a string obedeca a forma
	 * adequada de criacao do objeto, uma nova instancia de
	 * <code>Mensagem</code> sera criada.
	 * 
	 * @param conteudo
	 *            String a ser verificada.
	 * @throws EntradaException
	 *             sera lancada caso o parametro recebido nao obedeca as regras
	 *             de criacao;
	 */
	public Mensagem(String conteudo) throws EntradaException {
		if (conteudo.length() >= 200) {
			throw new EntradaException(
					"O limite maximo da mensagem sao 200 caracteres.");
		}

		this.conteudo = conteudo;
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

	/**
	 * Altera o campo conteudo anteriormente inicializado na construcao da classe <code>Mensagem</code>. 
	 * @param string que atribuira o novo valor ao campo.
	 */
	@Override
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;

	}

	/**
	 * Retorna uma representacao em String do objeto <code>Audio</code>,
	 * seguindo um padrao adotado por <code>Midia</code>. <br> 
	 * 
	 * @return getConteudo().
	 */
	@Override
	public String toString() {
		return getConteudo();
	}

}
