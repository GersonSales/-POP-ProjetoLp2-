package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class UsuarioExistenteException extends UsuarioException {
	public UsuarioExistenteException() {
		super("Usuario ja existe!");
	}
	
	public UsuarioExistenteException(String mensagem) {
		super(mensagem);
	}
}
