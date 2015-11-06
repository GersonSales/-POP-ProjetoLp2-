package projeto.maispop.usuario;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe <code>ListaDeAmigos</code> que serve
 * wrapper da classe <i>HashSet<i> para que o <i>Usuario<i> possia manipular
 * suas amizades na rede social <i>+Pop</i>.
 * 
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

    public void aceitaAmizade(String emailUsuario) {
	this.listaDeAmigos.add(emailUsuario);
	this.pendentes.remove(emailUsuario);
    }

    public void adicionaAmigo(String emailUsuario) {
	this.pendentes.add(emailUsuario);
    }

    public boolean contemAmigo(String emailUsuario) {
	return this.listaDeAmigos.contains(emailUsuario);
    }
    
    public boolean contemPendencia(String emailUsuario) {
	return this.pendentes.contains(emailUsuario);
    }
    
    public int getQtdAmigos() {
	return this.listaDeAmigos.size();
    }
    
    public void rejeitaAmizade(String emailUsuario) {
	this.pendentes.remove(emailUsuario);

    }

    public void removeAmigo(String emailUsuario) {
	this.listaDeAmigos.remove(emailUsuario);
    }
    
    

}
