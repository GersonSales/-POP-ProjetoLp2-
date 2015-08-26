package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class UsuarioInexistenteException extends UsuarioException {
	public UsuarioInexistenteException() {
		super("Usuario inexistente!");
	}
	
	public UsuarioInexistenteException(String mensagem) {
		super(mensagem);
	}

	public UsuarioInexistenteException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}
}
