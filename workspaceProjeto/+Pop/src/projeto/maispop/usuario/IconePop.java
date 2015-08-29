package projeto.maispop.usuario;

public class IconePop implements TipoUsuario {

    @Override
    public void curir(Postagem postagem) {
	postagem.curtir(50);
	postagem.adicionaHashTag("#epicwin");
    }

    @Override
    public void descurtir(Postagem postagem) {
	postagem.descurtir(50);
	postagem.adicionaHashTag("#epicfail");
    }

}
