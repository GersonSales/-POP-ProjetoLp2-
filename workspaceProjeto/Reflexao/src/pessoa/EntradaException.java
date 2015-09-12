package pessoa;

@SuppressWarnings("serial")
public class EntradaException extends Exception {
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
