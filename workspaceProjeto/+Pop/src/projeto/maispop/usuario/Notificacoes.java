package projeto.maispop.usuario;

import java.util.ArrayList;
import java.util.List;


import projeto.maispop.excecoes.ItemInexistenteException;

//CLASSE INUTILIZADA, FAVOR DESCONSIDERAR.
public class Notificacoes {

    private List<String> notificacoes;

    public Notificacoes() {
	this.notificacoes = new ArrayList<>();
    }

    public void recebeNotificacao(String notificacao) {
	this.notificacoes.add(notificacao);
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
    
   
}
