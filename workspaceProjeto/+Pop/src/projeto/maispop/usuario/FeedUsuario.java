package projeto.maispop.usuario;

import java.util.ArrayList;
import java.util.List;

import projeto.maispop.postagem.Postagem;

public class FeedUsuario {

	private ListaDeAmigosAmigaveis listaDeAmigos;
	private List<Postagem> postagens;

	public FeedUsuario(ListaDeAmigosAmigaveis listaDeAmigos) {
		this.listaDeAmigos = listaDeAmigos;
		this.postagens = new ArrayList<>();
	}

	public void atualizar() {
		try {
			this.postagens.clear();
			for (Amigavel amigo : this.listaDeAmigos) {
				this.postagens.addAll(amigo.getFeedPostagem());
			}

		} catch (Exception erro) {
			System.out.println(erro.getMessage() + "<---");
		}
	}

	public void imprimeFeed() {
		System.out.println("INICIO DA IMPRESSAO");
		for (Postagem postagem : this.postagens) {
			System.out.println(postagem);
		}
		System.out.println("FIM DA IMPRESSAO");
	}

}
