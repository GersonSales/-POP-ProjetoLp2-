package projeto.maispop.sistema;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.EscritaException;
import projeto.maispop.excecoes.ItemInexistenteException;
import projeto.maispop.excecoes.LogarDeslogarException;
import projeto.maispop.excecoes.LogicaException;
import projeto.maispop.excecoes.MaisPopException;
import projeto.maispop.excecoes.SenhaException;
import projeto.maispop.excecoes.SolicitacaoException;
import projeto.maispop.excecoes.UsuarioException;
import projeto.maispop.excecoes.UsuarioExistenteException;
import projeto.maispop.excecoes.UsuarioInexistenteException;

public class Facade {

	private static final String DIR_LOG = "./Log/";
	private static final String TITULO_LOG = "log.txt";
	private static final String DIR_CONTROL = "./Controller/";
	private static final String TITULO_CONTROL = "controler.dat";

	private Controller controller;

	public Facade() {
	}

	public void aceitaAmizade(String emailUsuario)
			throws UsuarioInexistenteException, SolicitacaoException,
			EscritaException {
		try {
			gravarLog(emailUsuario);
			this.controller.aceitaAmizade(emailUsuario);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public void adicionaAmigo(String emailUsuario)
			throws UsuarioInexistenteException, EscritaException {
		try {
			gravarLog(emailUsuario);
			this.controller.adicionaAmigo(emailUsuario);

		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public void adicionaPops(int popBonus) throws EscritaException {
		gravarLog(popBonus + "");
		this.controller.adicionaPops(popBonus);
	}

	public void atualizaFeed() throws EscritaException {
		gravarLog();
		this.controller.atualizaFeed();
	}

	public void atualizaPerfil(String atributo, String valor)
			throws MaisPopException {
		try {
			gravarLog(atributo, valor);
			this.controller.atualizaPerfil(atributo, valor);
		} catch (MaisPopException erro) {
			gravarLog(erro);
			throw new EntradaException("Erro na atualizacao de perfil. "
					+ erro.getMessage(), erro);
		}
	}

	public void atualizaPerfil(String atributo, String valor, String antigoValor)
			throws MaisPopException {
		try {
			gravarLog(atributo, valor, antigoValor);
			this.controller.atualizaPerfil(atributo, valor, antigoValor);
		} catch (MaisPopException erro) {
			gravarLog(erro);
			throw new MaisPopException("Erro na atualizacao de perfil. "
					+ erro.getMessage(), erro);
		}
	}

	public String atualizaRanking() throws EscritaException {
		gravarLog();
		return this.controller.exibeRanking();
	}

	public String atualizaTrendingTopics() throws EscritaException {
		gravarLog();
		return this.controller.melhoresHashtags();
	}

	public String cadastraUsuario(String nome, String email, String senha,
			String dataNascimento) throws EntradaException,
			UsuarioExistenteException, EscritaException {
		try {
			gravarLog(nome, email, senha, dataNascimento);
			this.controller.cadastraUsuario(nome, email, senha, dataNascimento);
		} catch (EntradaException erro) {
			gravarLog(erro);
			throw new EntradaException("Erro no cadastro de Usuarios. "
					+ erro.getMessage(), erro);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
		return email;
	}

	public String cadastraUsuario(String nome, String email, String senha,
			String dataNascimento, String imagem) throws EntradaException,
			UsuarioExistenteException, EscritaException {
		try {
			gravarLog(nome, email, senha, dataNascimento, imagem);
			this.controller.cadastraUsuario(nome, email, senha, dataNascimento,
					imagem);
		} catch (EntradaException erro) {
			gravarLog(erro);
			throw new EntradaException("Erro no cadastro de Usuarios. "
					+ erro.getMessage(), erro);
		} catch (UsuarioExistenteException erro) {
			gravarLog(erro);
			throw erro;
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}

		return email;
	}

	public void criaPost(String texto, String dataPostagem)
			throws EntradaException, EscritaException {
		try {
			gravarLog(texto, dataPostagem);

			this.controller.postar(texto, dataPostagem);
		} catch (EntradaException erro) {
			gravarLog(erro);
			throw new EntradaException("Nao eh possivel criar o post. "
					+ erro.getMessage(), erro);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;

		}
	}

	public void curtirPost(String emailUsuario, int postagem)
			throws UsuarioInexistenteException, EntradaException,
			EscritaException {
		try {
			gravarLog(emailUsuario, postagem + "");
			this.controller.curtirPost(emailUsuario, postagem);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public void fechaSistema() throws LogicaException {
		try {
			gravarLog();
			this.controller.fechaSistema();
			GerenciadorES.gravaObjeto(DIR_CONTROL, TITULO_CONTROL,
					this.controller);
		} catch (LogicaException erro) {
			gravarLog(erro);
			throw new LogicaException("Nao foi possivel fechar o sistema. "
					+ erro.getMessage());
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}

	}

	public String getConteudoPost(int indice, int postagem)
			throws EntradaException, ItemInexistenteException, EscritaException {
		try {
			gravarLog(indice + "", postagem + "");
			return this.controller.getConteudo(indice, postagem);
		} catch (ItemInexistenteException erro) {
			gravarLog(erro);
			throw new EntradaException("Item #" + indice
					+ " nao existe nesse post, ele possui apenas "
					+ erro.getMessage() + " itens distintos.");

		} catch (EntradaException erro) {
			gravarLog(erro);
			throw new ItemInexistenteException("Requisicao invalida. "
					+ erro.getMessage(), erro);
		}
	}

	public String getInfoUsuario(String atributo) throws EntradaException,
			LogicaException {
		try {
			gravarLog(atributo);
			return this.controller.getInfoUsuario(atributo);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}

	}

	public String getInfoUsuario(String atributo, String email)
			throws EntradaException, LogicaException {

		try {
			gravarLog(atributo, email);
			return this.controller.getInfoUsuario(atributo, email);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public String getNextNotificacao() throws ItemInexistenteException,
			EscritaException {
		try {
			gravarLog();
			return this.controller.getProxNotificacao();
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public int getNotificacoes() throws EscritaException {
		gravarLog();
		return this.controller.getNotificacoes();
	}

	public int getPopsPost(int indice) throws EscritaException {
		gravarLog(indice + "");
		return this.controller.getPopsPost(indice);
	}

	public int getPopsUsuario() throws EscritaException {
		gravarLog();
		return this.controller.getPopsUsuario();
	}

	public int getPopsUsuario(String emailUsuario) throws UsuarioException,
			EscritaException {
		try {
			gravarLog(emailUsuario);
			return this.controller.getPopsUsuario(emailUsuario);
		} catch (UsuarioException erro) {
			gravarLog(erro);
			throw new UsuarioException("Erro na consulta de Pops. "
					+ erro.getMessage(), erro);
		}
	}

	public String getPopularidade() throws EscritaException {
		gravarLog();
		return this.controller.getPopularidade();
	}

	public String getPost(int postagem) throws EscritaException {
		gravarLog(postagem + "");
		return this.controller.getPostagem(postagem);
	}

	public String getPost(String atributo, int indice) throws EscritaException {
		gravarLog(atributo, indice + "");
		return this.controller.getPostagem(atributo, indice);
	}

	public int getQtdAmigos() throws EscritaException {
		gravarLog();
		return this.controller.getQtdAmigos();
	}

	private void gravarLog(String... variaveis) throws EscritaException {
		GerenciadorES.gravarLog(DIR_LOG, TITULO_LOG, variaveis);
	}

	private void gravarLog(Throwable erro) throws EscritaException {
		GerenciadorES.gravarLog(DIR_LOG, TITULO_LOG, erro);
	}

	// Tentatica Feed
	public void imprimeFeed() throws EscritaException {
		gravarLog();
		this.controller.imprimeFeed();
	}

	public void iniciaSistema() throws Exception {
		gravarLog();
		try {
			this.controller = (Controller) GerenciadorES.leObjeto(DIR_CONTROL,
					TITULO_CONTROL);

		} catch (LogicaException erro) {
			gravarLog(erro);
			throw new LogicaException("Nao foi possivel iniciar o sistema. "
					+ erro.getMessage());
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}

		if (this.controller == null) {
			this.controller = new Controller();

		}
	}

	public void login(String email, String senha) throws LogicaException,
			SenhaException {
		try {
			gravarLog(email, senha);
			this.controller.login(email, senha);
		} catch (UsuarioInexistenteException erro) {
			gravarLog(erro);
			throw new UsuarioInexistenteException(
					"Nao foi possivel realizar login. " + erro.getMessage(),
					erro);
		} catch (LogarDeslogarException erro) {
			gravarLog(erro);
			throw new LogarDeslogarException(
					"Nao foi possivel realizar login. " + erro.getMessage(),
					erro);
		}
	}

	public void logout() throws LogarDeslogarException, EscritaException {
		gravarLog();
		this.controller.logout();
	}

	public int qtdCurtidasDePost(int indice) throws ItemInexistenteException,
			EscritaException {
		try {
			gravarLog(indice + "");

			return this.controller.qtdCurtidasDePost(indice);
		} catch (ItemInexistenteException erro) {
			gravarLog(erro);
			throw new ItemInexistenteException("Post #" + indice
					+ " nao existe. " + erro.getMessage(), erro);
		}
	}

	public int qtdRejeicoesDePost(int indice) throws EscritaException {
		gravarLog(indice + "");
		return this.controller.qtdRejeicoesDePost(indice);
	}

	// teste de ranking

	public void rejeitaAmizade(String email)
			throws UsuarioInexistenteException, SolicitacaoException,
			EscritaException {
		try {
			gravarLog(email + "");
			this.controller.rejeitaAmizade(email);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public void rejeitarPost(String email, int postagem)
			throws UsuarioInexistenteException, EntradaException,
			EscritaException {
		try {
			gravarLog(email, postagem + "");
			this.controller.descurtirPost(email, postagem);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public void removeAmigo(String email) throws UsuarioInexistenteException,
			EscritaException {
		try {
			gravarLog(email);
			this.controller.removeAmigo(email);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	public void removeUsuario(String email) throws UsuarioInexistenteException,
			EscritaException {
		try {
			gravarLog(email);
			this.controller.removeUsuario(email);
		} catch (Exception erro) {
			gravarLog(erro);
			throw erro;
		}
	}

	// tentativa arquivos

	public void salvarPostagens() throws EscritaException {
		gravarLog();
		this.controller.salvarPostagens();
	}

	public void salvarPostagensUsuarios() throws EscritaException {
		gravarLog();
		this.controller.salvarPostagensUsuarios();
	}

}
