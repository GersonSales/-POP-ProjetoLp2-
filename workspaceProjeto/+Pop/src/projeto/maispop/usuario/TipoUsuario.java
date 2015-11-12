package projeto.maispop.usuario;

import java.io.Serializable;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.postagem.Postagem;

public interface TipoUsuario extends Serializable{

	public void curtir(Postagem postagem) throws EntradaException;

	public void descurtir(Postagem postagem) throws EntradaException;

	public int getFeedQtdPostagem();
}
