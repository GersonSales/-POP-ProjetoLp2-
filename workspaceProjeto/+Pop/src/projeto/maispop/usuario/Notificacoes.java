package projeto.maispop.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.ItemInexistenteException;

public class Notificacoes implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2626302444850300572L;
	private List<String> notificacoes;

    public Notificacoes() {
	this.notificacoes = new ArrayList<>();
    }

    public int getNotificacoes() {
	return this.notificacoes.size();
    }

    public String getProxNotificacao() throws ItemInexistenteException {
	if (this.notificacoes.size() == 0) {
	    throw new ItemInexistenteException("Nao ha mais notificacoes.");
	}
	return notificacoes.remove(0);
    }

    public void recebeNotificacao(String notificacao) {
	this.notificacoes.add(notificacao);
    }
    
   
}
