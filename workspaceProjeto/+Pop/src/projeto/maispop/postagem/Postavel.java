package projeto.maispop.postagem;

import java.io.Serializable;

/**
 * Interface que representa um objeto <code>Postavel</code>. Fazendo com que a
 * classe que implemente-a possa fazer parte de uma <code>Postagem</code>.
 * 
 * @author Gerson Sales
 * @see Postagem
 *
 */
public interface Postavel extends Serializable{
	/**
	 * Tem o intuito de retornar a representacao em forma de string de
	 * <code>Postavel</code>.
	 * 
	 * @return a string resultante.
	 */
	public String getConteudo();

	/**
	 * Tem o intuito de alterar o campo conteudo anteriormente definido.
	 * 
	 * @param string
	 *            que atribuira o novo valor ao campo.
	 */
	public void setConteudo(String conteudo);
}
