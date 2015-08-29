package projeto.maispop.usuario;

public class CelebridadePop implements TipoUsuario {

    @Override
    public void curir(Postagem postagem) {
	postagem.curtir(25);
    }

    @Override
    public void descurtir(Postagem postagem) {
	postagem.descurtir(25);
    }

}
