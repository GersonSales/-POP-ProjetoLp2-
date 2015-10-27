package projeto.maispop.usuario;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.midia.Postagem;
public class IconePop implements TipoUsuario {

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

}
