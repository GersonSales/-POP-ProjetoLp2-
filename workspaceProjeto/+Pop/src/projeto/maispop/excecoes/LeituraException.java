package projeto.maispop.excecoes;

public class LeituraException extends ArquivoException {

	private static final long serialVersionUID = 1270850325126247474L;
	public LeituraException() {
		super("Erro na leitura do arquivo!");
	}
	
	public LeituraException(String mensagem) {
		super(mensagem);
	}
	
	public LeituraException(Throwable erro) {
		super(erro);
	}
	
	public LeituraException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}
	
	

}
