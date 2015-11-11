package projeto.maispop.usuario;

import projeto.maispop.postagem.Postagem;

public class NormalPop implements TipoUsuario {
	
	private static final int QTD_FEED = 2;

    @Override
    public void curtir(Postagem postagem) {
	postagem.curtir(10);
    }

    @Override
    public void descurtir(Postagem postagem) {
	postagem.descurtir(10);
    }

    @Override
    public String toString() {
    	return "Normal Pop";
    }

	@Override
	public int getFeedQtdPostagem() {
		return QTD_FEED;
	}
}
