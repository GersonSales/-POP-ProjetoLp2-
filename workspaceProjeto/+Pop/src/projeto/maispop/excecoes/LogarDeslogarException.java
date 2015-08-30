package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class LogarDeslogarException extends UsuarioException {
	public LogarDeslogarException() {
		super("Erro ao tentar logar/deslogar no sistema!");
	}
	
	public LogarDeslogarException(String mensagem) {
		super(mensagem);
	}
	
	public LogarDeslogarException(String mensagem, Throwable erro) {
	    super(mensagem, erro);
	}
	
	public LogarDeslogarException(Throwable erro) {
	    super(erro);
	}
}
