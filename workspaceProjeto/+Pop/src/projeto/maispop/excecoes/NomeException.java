package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class NomeException extends EntradaException {
	public NomeException() {
		super("Nome invalido!");
	}
	
	public NomeException(String mensagem) {
		super(mensagem);
	}
}
