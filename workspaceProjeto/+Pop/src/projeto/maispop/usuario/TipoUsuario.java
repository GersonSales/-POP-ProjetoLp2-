package projeto.maispop.usuario;

import projeto.maispop.midia.Postagem;

public interface TipoUsuario {
    
    public void curtir(Postagem postagem);
    
    public void descurtir(Postagem postagem);
}
