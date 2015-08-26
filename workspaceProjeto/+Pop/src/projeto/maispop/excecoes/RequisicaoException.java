package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class RequisicaoException extends LogicaException {
	public RequisicaoException() {
		super("Requisicao invalida!");
	}
	
	public RequisicaoException(String mensagem) {
		super(mensagem);
	}

}
