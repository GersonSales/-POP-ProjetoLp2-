package projeto.maispop.sistema;

import projeto.maispop.excecoes.EntradaException;
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
	private static final String TITULO_LOG = "log";
	private static final String DIR_CONTROL = "./Controller/";
	private static final String TITULO_CONTROL = "controler.dat";

	private Controller controller;

	public Facade() {
	}

	private void gravarLog(String mensagem) {
		GerenciadorES.gravarTexto(DIR_LOG, TITULO_LOG, mensagem, true);
	}

	public void aceitaAmizade(String emailUsuario)
			throws UsuarioInexistenteException, SolicitacaoException {
		try {
			gravarLog("aceitaAmizade(" + emailUsuario + ")");
			this.controller.aceitaAmizade(emailUsuario);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	public void adicionaAmigo(String emailUsuario)
			throws UsuarioInexistenteException {
		try {
			gravarLog("adicionaAmigo(" + emailUsuario + ")");
			this.controller.adicionaAmigo(emailUsuario);

		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	public void adicionaPops(int popBonus) {
		gravarLog("adicionaPops(" + popBonus + ")");
		this.controller.adicionaPops(popBonus);
	}

	public void atualizaPerfil(String atributo, String valor)
			throws MaisPopException {
		try {
			gravarLog("atualizaPerfil(" + atributo + ", " + valor + ")");
			this.controller.atualizaPerfil(atributo, valor);
		} catch (MaisPopException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new EntradaException("Erro na atualizacao de perfil. "
					+ erro.getMessage(), erro);
		}
	}

	public void atualizaPerfil(String atributo, String valor, String antigoValor)
			throws MaisPopException {
		try {
			gravarLog("atualizaPerfil(" + atributo + ", " + valor + ", "
					+ antigoValor + ")");

			this.controller.atualizaPerfil(atributo, valor, antigoValor);
		} catch (MaisPopException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new MaisPopException("Erro na atualizacao de perfil. "
					+ erro.getMessage(), erro);
		}
	}

	public String atualizaRanking() {
		gravarLog("atualizaRanking()");
		return this.controller.exibeRanking();
	}

	public String atualizaTrendingTopics() {
		gravarLog("atualizaTrendingTopics()");
		return this.controller.melhoresHashtags();
	}

	public String cadastraUsuario(String nome, String email, String senha,
			String dataNascimento) throws EntradaException,
			UsuarioExistenteException {
		try {
			gravarLog("cadastraUsuario(" + nome + ", " + email + ", " + senha
					+ ", " + dataNascimento + ")");
			this.controller.cadastraUsuario(nome, email, senha, dataNascimento);
		} catch (EntradaException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new EntradaException("Erro no cadastro de Usuarios. "
					+ erro.getMessage(), erro);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
		return email;
	}

	public String cadastraUsuario(String nome, String email, String senha,
			String dataNascimento, String imagem) throws EntradaException,
			UsuarioExistenteException {
		try {
			gravarLog("cadastraUsuario(" + nome + ", " + email + ", " + senha
					+ ", " + dataNascimento + "," + imagem + ")");
			this.controller.cadastraUsuario(nome, email, senha, dataNascimento,
					imagem);
		} catch (EntradaException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new EntradaException("Erro no cadastro de Usuarios. "
					+ erro.getMessage(), erro);
		} catch (UsuarioExistenteException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}

		return email;
	}

	public void criaPost(String texto, String dataPostagem)
			throws EntradaException {
		try {
			gravarLog("criaPost(" + texto + ", " + dataPostagem + ")");

			this.controller.postar(texto, dataPostagem);
		} catch (EntradaException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new EntradaException("Nao eh possivel criar o post. "
					+ erro.getMessage(), erro);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;

		}
	}

	public void curtirPost(String emailUsuario, int postagem)
			throws UsuarioInexistenteException, EntradaException {
		try {
			gravarLog("curtirPost(" + emailUsuario + ", " + postagem + ")");
			this.controller.curtirPost(emailUsuario, postagem);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	public void fechaSistema() throws LogicaException {
		try {
			gravarLog("fechaSistema()");
			this.controller.fechaSistema();
			GerenciadorES.gravaObjeto(DIR_CONTROL, TITULO_CONTROL,
					this.controller);
			gravarLog("===============");
		} catch (LogicaException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new LogicaException("Nao foi possivel fechar o sistema. "
					+ erro.getMessage());
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}

	}

	public String getConteudoPost(int indice, int postagem)
			throws EntradaException, ItemInexistenteException {
		try {
			gravarLog("getConteudoPost(" + indice + ", " + postagem + ")");
			return this.controller.getConteudo(indice, postagem);
		} catch (ItemInexistenteException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new EntradaException("Item #" + indice
					+ " nao existe nesse post, ele possui apenas "
					+ erro.getMessage() + " itens distintos.");

		} catch (EntradaException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new ItemInexistenteException("Requisicao invalida. "
					+ erro.getMessage(), erro);
		}
	}

	public String getInfoUsuario(String atributo) throws EntradaException,
			LogicaException {
		try {
			gravarLog("getInfoUsuario( " + atributo + ")");
			return this.controller.getInfoUsuario(atributo);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}

	}

	public String getInfoUsuario(String atributo, String email)
			throws EntradaException, LogicaException {
		try {
			gravarLog("getInfoUsuario(" + atributo + ", " + "email" + ")");
			return this.controller.getInfoUsuario(atributo, email);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	public String getNextNotificacao() throws ItemInexistenteException {
		try {
			gravarLog("getNextNotificacao()");
			return this.controller.getProxNotificacao();
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	public int getNotificacoes() {
		gravarLog("getNotificacoes()");
		return this.controller.getNotificacoes();
	}

	public int getPopsPost(int indice) {
		gravarLog("getPopsPost(" + indice + ")");
		return this.controller.getPopsPost(indice);
	}

	public int getPopsUsuario() {
		gravarLog("getPopsUsuario()");
		return this.controller.getPopsUsuario();
	}

	public int getPopsUsuario(String emailUsuario) throws UsuarioException {
		try {
			gravarLog("getPopsUsuario(" + emailUsuario + ")");
			return this.controller.getPopsUsuario(emailUsuario);
		} catch (UsuarioException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new UsuarioException("Erro na consulta de Pops. "
					+ erro.getMessage(), erro);
		}
	}

	public String getPopularidade() {
		gravarLog("getPopularidade()");
		return this.controller.getPopularidade();
	}

	public String getPost(int postagem) {
		gravarLog("getPost(" + postagem + ")");
		return this.controller.getPostagem(postagem);
	}

	public String getPost(String atributo, int indice) {
		gravarLog("getPost(" + atributo + ", " + indice + ")");
		return this.controller.getPostagem(atributo, indice);
	}

	public int getQtdAmigos() {
		gravarLog("getQtdAmigos()");
		return this.controller.getQtdAmigos();
	}

	public void iniciaSistema() {
		gravarLog("+++++++++++++++");
		gravarLog("iniciaSistema()");
		this.controller = (Controller) GerenciadorES.leObjeto(DIR_CONTROL,
				TITULO_CONTROL);
		
		if (this.controller == null) {
			this.controller = new Controller();
		}
	}

	public void login(String email, String senha) throws LogicaException,
			SenhaException {
		try {
			gravarLog("login(" + email + "," + senha + ")");
			this.controller.login(email, senha);
		} catch (UsuarioInexistenteException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new UsuarioInexistenteException(
					"Nao foi possivel realizar login. " + erro.getMessage(),
					erro);
		} catch (LogarDeslogarException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new LogarDeslogarException(
					"Nao foi possivel realizar login. " + erro.getMessage(),
					erro);
		}
	}

	public void logout() throws LogarDeslogarException {
		gravarLog("logout()");
		this.controller.logout();
	}

	public int qtdCurtidasDePost(int indice) throws ItemInexistenteException {
		try {
			gravarLog("qtdCurtidasDePost(" + indice + ")");

			return this.controller.qtdCurtidasDePost(indice);
		} catch (ItemInexistenteException erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw new ItemInexistenteException("Post #" + indice
					+ " nao existe. " + erro.getMessage(), erro);
		}
	}

	public int qtdRejeicoesDePost(int indice) {
		gravarLog("qtdRejeicoesDePost(" + indice + ")");
		return this.controller.qtdRejeicoesDePost(indice);
	}

	public void rejeitaAmizade(String email)
			throws UsuarioInexistenteException, SolicitacaoException {
		try {
			gravarLog("rejeitaAmizade(" + email + ")");
			this.controller.rejeitaAmizade(email);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	public void rejeitarPost(String email, int postagem)
			throws UsuarioInexistenteException, EntradaException {
		try {
			gravarLog("rejeitarPost(" + email + ", " + postagem + ")");
			this.controller.descurtirPost(email, postagem);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	// teste de ranking

	public void removeAmigo(String email) throws UsuarioInexistenteException {
		try {
			gravarLog("removeAmigo(" + email + ")");
			this.controller.removeAmigo(email);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	public void removeUsuario(String email) throws UsuarioInexistenteException {
		try {
			gravarLog("removeUsuario(" + email + ")");
			this.controller.removeUsuario(email);
		} catch (Exception erro) {
			gravarLog("ERRO: " + erro.getMessage());
			throw erro;
		}
	}

	// Tentatica Feed
	public void imprimeFeed() {
		gravarLog("imprimeFeed()");
		this.controller.imprimeFeed();
	}

	public void atualizaFeed() {
		gravarLog("atualizaFeed()");
		this.controller.atualizaFeed();
	}

	// tentativa arquivos

	public void salvarPostagens() {
		gravarLog("salvarPostagens()");
		this.controller.salvarPostagens();
	}

	public void salvarPostagensUsuarios() {
		gravarLog("salvarPostagensUsuarios()");
		this.controller.salvarPostagensUsuarios();
	}

}
