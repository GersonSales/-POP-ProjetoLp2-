package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class SenhaException extends EntradaException {
	public SenhaException() {
		super("Senha invalida!");
	}
	
	public SenhaException(String mensagem) {
		super(mensagem);
	}
}
