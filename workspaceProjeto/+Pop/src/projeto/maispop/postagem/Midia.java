package projeto.maispop.postagem;

import java.io.Serializable;

/**
 * O <code>Midia</code> class representa um objeto tipo <code>Midia</code>. Esta
 * classe armazenara todas informacoes necessarias para a verificacao e
 * representacao de um objeto <code>Midia</code>.
 * 
 * @author Gerson Sales
 * @see Postavel
 */
public abstract class Midia implements Postavel, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7288012489040362176L;
	private String conteudo;

	/**
	 * Construtor da classe <code>Midia</code> que recebe uma string como
	 * parametro a string que sera verificada. Caso a string obedeca a forma
	 * adequada de criacao do objeto, uma nova instancia de <code>Midia</code>
	 * sera criada.
	 * 
	 * @param conteudo
	 *            String a ser verificada.
	 */
	public Midia(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * Retorna a representacao de <code>Midia</code> recebida como parametro na
	 * construcao do objeto.
	 * 
	 * @return a string resultante da construcao.
	 */
	public String getConteudo() {
		return this.conteudo;
	}

	/**
	 * Altera o campo conteudo anteriormente inicializado na construcao da
	 * classe <code>Midia</code>.
	 * 
	 * @param string
	 *            que atribuira o novo valor ao campo.
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
