package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class EmailException extends EntradaException {
	public EmailException() {
		super("Email invalido!");
	}
	
	public EmailException(String mensagem) {
		super(mensagem);
	}

}
