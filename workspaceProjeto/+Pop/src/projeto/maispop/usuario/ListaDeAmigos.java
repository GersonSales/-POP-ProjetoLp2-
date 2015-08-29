package projeto.maispop.usuario;

import java.util.HashSet;
import java.util.Set;

import projeto.maispop.excecoes.ItemInexistenteException;
import projeto.maispop.excecoes.SolicitacaoException;

/**
 * CLASSE ATUALMENTE INUTILIZADA! Classe <code>ListaDeAmigos</code> que serve
 * wrapper da classe <i>HashSet<i> para que o <i>Usuario<i> possia manipular
 * suas amizades na rede social <i>+Pop</i>.
 * 
 * @author Adson Cesar.
 * @author Gerson Sales.
 * @version 0.3
 * @see Usuario
 *
 */
public class ListaDeAmigos {
    private Set<String> listaDeAmigos;
    private Set<String> pendentes;

    public ListaDeAmigos() {
	this.listaDeAmigos = new HashSet<>();
	this.pendentes = new HashSet<>();

    }

    public void adicionaAmigo(String emailUsuario) {
	this.pendentes.add(emailUsuario);
    }

    public void rejeitaAmizade(String emailUsuario) {
	this.pendentes.remove(emailUsuario);

    }

    public void aceitaAmizade(String emailUsuario) {

	this.listaDeAmigos.add(emailUsuario);
	this.pendentes.remove(emailUsuario);
    }
    
    public boolean contemPendencia(String emailUsuario) {
	return this.pendentes.contains(emailUsuario);
    }
    
    public boolean contemAmigo(String emailUsuario) {
	return this.listaDeAmigos.contains(emailUsuario);
    }
    
    public int getQtdAmigos() {
	return this.listaDeAmigos.size();
    }
    
    

}
