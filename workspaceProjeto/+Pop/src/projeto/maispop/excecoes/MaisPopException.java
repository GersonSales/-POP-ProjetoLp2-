package projeto.maispop.excecoes;

/**
 * Hierarquia de excecoes nao definida completamente. Todas as classes de
 * 'Exception' estao sujeitas as alteracoes, exclusao e mudanca de parenteso.
 * 
 * @author gersonsales
 *
 */
@SuppressWarnings("serial")
public class MaisPopException extends Exception {
    public MaisPopException() {
	super("Erro na execucao do programa!");
    }

    public MaisPopException(String mensagem) {
	super(mensagem);
    }

    public MaisPopException(String mensagem, Throwable erro) {
	super(mensagem, erro);
    }

    public MaisPopException(Throwable erro) {
	super(erro);
    }

}
