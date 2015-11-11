package projeto.maispop.usuario;

import java.util.List;

import projeto.maispop.postagem.Postagem;

public interface Amigavel {
	public List<Postagem> getFeedPostagem();
	public String getEmail();
	public String getNome();
	public void aceitaAmizade(Amigavel amigo);
	public void rejeitaAmizade(Amigavel amigo);
	public void notificaMe(String mensagem);
}
