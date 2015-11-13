package projeto.maispop.usuario;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.postagem.Postagem;

public class IconePop implements TipoUsuario {
	private static final long serialVersionUID = 4267898189282577383L;
	private static final int QTD_FEED = 6;

	
	@Override
	public void curtir(Postagem postagem) throws EntradaException {
		postagem.curtir(50);
		postagem.adicionaHashTag("#epicwin");
	}

	@Override
	public void descurtir(Postagem postagem) throws EntradaException {
		postagem.descurtir(50);
		postagem.adicionaHashTag("#epicfail");
	}

	@Override
	public String toString() {
		return "Icone Pop";
	}

	@Override
	public int getFeedQtdPostagem() {
		return QTD_FEED;
	}

}
