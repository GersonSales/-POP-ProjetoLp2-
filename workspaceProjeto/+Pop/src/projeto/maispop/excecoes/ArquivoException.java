package projeto.maispop.excecoes;

public class ArquivoException extends LogicaException {

	private static final long serialVersionUID = -7501377046356593814L;
	
	public ArquivoException() {
		super("Erro ao manipular arquivo!");
	}
	
	public ArquivoException(String mensagem) {
		super(mensagem);
	}
	
	public ArquivoException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}
	
	public ArquivoException(Throwable erro) {
		super(erro);
	}
	
	

}
