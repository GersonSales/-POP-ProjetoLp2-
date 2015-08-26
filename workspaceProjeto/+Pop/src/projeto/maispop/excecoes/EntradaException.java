package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class EntradaException extends MaisPopException {
	public EntradaException() {
		super("Entrada Invalida!");
	}
	
	public EntradaException(String mensagem) {
		super(mensagem);
	}
	
	public EntradaException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}
	
	public EntradaException(Throwable erro) {
		super(erro);
	}
}
