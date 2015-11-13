package projeto.maispop.excecoes;

public class EscritaException extends ArquivoException {

	private static final long serialVersionUID = 8118685297198076141L;
	
	public EscritaException() {
		super("Erro na escrita do arquivo!");
	}
	
	public EscritaException(String mensagem) {
		super(mensagem);
	}
	
	public EscritaException(Throwable erro) {
		super(erro);
	}
	
	
	public EscritaException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}

}
