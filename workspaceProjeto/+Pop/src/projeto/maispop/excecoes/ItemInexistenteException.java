package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class ItemInexistenteException extends LogicaException {
	public ItemInexistenteException() {
		super("Item nao existe!");
	}
	
	public ItemInexistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ItemInexistenteException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}

	public ItemInexistenteException(Throwable erro) {
	    super(erro);
	}

}
