package projeto.maispop.testes;

import org.junit.Assert;
import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.LogicaException;
import projeto.maispop.excecoes.NomeException;
import projeto.maispop.excecoes.UsuarioException;
import projeto.maispop.excecoes.UsuarioExistenteException;
import projeto.maispop.sistema.BancoDeUsuarios;
import projeto.maispop.sistema.Controller;
import projeto.maispop.sistema.Facade;
import projeto.maispop.usuario.Usuario;

public class TesteUsuario {

	Usuario gerson;
	Usuario mirella;
	BancoDeUsuarios BancoDeUsuarios;
	Controller controller;
	Facade facade;

	public void criacao() throws EntradaException, LogicaException {
		this.BancoDeUsuarios = new BancoDeUsuarios();
		this.controller = new Controller();
		this.facade = new Facade();

		try {
			this.gerson = new Usuario("Gerson", "gerson@ermail.com", "SenhaGerson", "24/02/2014");
			//this.BancoDeUsuarios.cadastraUsuario("Gerson", "gerson@ermail.com", "SenhaGerson", "24/02/1995");
			//this.controller.cadastraUsuario("Gerson", "gerson@ermail.com", "SenhaGerson", "24/02/1995");
			//System.out.println(gerson.getDataNascimento());

		}catch(NomeException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void testaException() throws UsuarioException {
		try {
			testaException2();
		}catch (UsuarioException e) {
			throw new UsuarioException("Teste1 " + e.getMessage(), e);
		}
	}
	
	public void testaException2() throws UsuarioException {
		throw new UsuarioException("Teste 2");
	}

	
	@Test
	public void testaUsoException() {
		try {
			testaException();
		}catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	
	
	
}
