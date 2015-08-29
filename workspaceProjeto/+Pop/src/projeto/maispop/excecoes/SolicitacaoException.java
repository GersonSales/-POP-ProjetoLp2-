package projeto.maispop.excecoes;

@SuppressWarnings("serial")
public class SolicitacaoException extends ItemInexistenteException {
    public SolicitacaoException() {
	super("Solicitacao nao encontrada.");
    }
    
    public SolicitacaoException(String mensagem) {
	super(mensagem);
    }
    
    public SolicitacaoException(String mensagem, Throwable erro) {
	super(mensagem, erro);
    }
    
    public SolicitacaoException(Throwable erro) {
	super(erro);
    }

}
