package projeto.maispop.usuario;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.midia.Postagem;

public interface TipoUsuario {
    
    public void curtir(Postagem postagem) throws EntradaException;
    
    public void descurtir(Postagem postagem) throws EntradaException;
}
