package projeto.maispop.sistema;

import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.ItemInexistenteException;
import projeto.maispop.excecoes.LogicaException;
import projeto.maispop.excecoes.RequisicaoException;
import projeto.maispop.excecoes.SenhaException;
import projeto.maispop.excecoes.UsuarioExistenteException;
import projeto.maispop.excecoes.UsuarioInexistenteException;
import projeto.maispop.usuario.Usuario;

public class BancoDeUsuarios {

    private List<Usuario> usuarios;

    public BancoDeUsuarios() {
	this.usuarios = new ArrayList<>();
    }

    public void cadastraUsuario(String nome, String email, String senha,
	    String dataNascimento, String imagem) throws EntradaException,
	    UsuarioExistenteException {

	if (verificaEmailExistente(email)) {
	    throw new UsuarioExistenteException();
	}

	Usuario novoUsuario = new Usuario(nome, email, senha, dataNascimento,
		imagem);
	this.usuarios.add(novoUsuario);

    }

    public void cadastraUsuario(String nome, String email, String senha,
	    String dataNascimento) throws EntradaException,
	    UsuarioExistenteException {
	if (verificaEmailExistente(email)) {
	    throw new UsuarioExistenteException();
	}

	Usuario novoUsuario = new Usuario(nome, email, senha, dataNascimento);
	this.usuarios.add(novoUsuario);
    }

    public void removeUsuario(String email) throws UsuarioInexistenteException {
	this.usuarios.remove(getUsuario(email));
    }

    private boolean verificaEmailExistente(String email) {
	for (Usuario usuario : usuarios) {
	    if (usuario.getEmail().equals(email)) {
		return true;
	    }
	}
	return false;
    }

    public Usuario getUsuario(String emailUsuario) throws UsuarioInexistenteException{
	for (Usuario usuario : usuarios) {
	    if (usuario.getEmail().equals(emailUsuario)) {
		return usuario;
	    }
	}
	throw new UsuarioInexistenteException("Um usuarix com email " + emailUsuario + " nao esta cadastradx.");
    }

    public String getInfoUsuario(String atributo, String email)
	    throws EntradaException, LogicaException{
	Usuario usuario = getUsuario(email);
	if (usuario == null) {
	    throw new UsuarioInexistenteException("Um usuarix com email "
		    + email + " nao esta cadastradx.");
	}

	switch (atributo) {
	case "Nome":
	    return usuario.getNome();
	case "Email":
	    return usuario.getEmail();
	case "Senha":
	    throw new RequisicaoException("A senha dx usuarix eh protegida.");
	case "Data de Nascimento":
	    return usuario.getDataNascimento();
	case "Foto":
	    return usuario.getImagemPerfil();
	default:
	    throw new EntradaException();
	}
    }

    public void atualizaPerfil(String atributo, String valor,
	    String antigoValor, String email) throws SenhaException, UsuarioInexistenteException {
	Usuario usuario = getUsuario(email);

	if (usuario.getSenha().equals(antigoValor)) {
	    usuario.setSenha(valor);
	} else {
	    throw new SenhaException("A senha fornecida esta incorreta.");
	}
    }

    public void atualizaPerfil(String atributo, String valor, String email)
	    throws EntradaException, UsuarioInexistenteException {
	Usuario usuario = getUsuario(email);
	if (usuario == null) {
	    throw new UsuarioInexistenteException("Usuario nao logado.");
	}

	switch (atributo) {
	case "Nome":
	    usuario.setNome(valor);
	    break;
	case "E-mail":
	    usuario.setEmail(valor);
	    break;
	case "Data de Nascimento":
	    usuario.setDataNascimento(valor);
	    break;
	case "Foto":
	    usuario.setImagemPerfil(valor);
	    break;
	default:
	    throw new EntradaException();
	}
    }

    //RELACIONAMENTO ENTRE USUARIOS:
    
    
    
    
}
