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

	private Controller controller;

	public Facade() {
		this.controller = new Controller();
	}

	public void aceitaAmizade(String emailUsuario)
			throws UsuarioInexistenteException, SolicitacaoException {
		this.controller.aceitaAmizade(emailUsuario);
	}

	public void adicionaAmigo(String emailUsuario)
			throws UsuarioInexistenteException {
		this.controller.adicionaAmigo(emailUsuario);
	}

	public void adicionaPops(int popBonus) {
		this.controller.adicionaPops(popBonus);
	}

	public void atualizaPerfil(String atributo, String valor)
			throws MaisPopException {
		try {
			this.controller.atualizaPerfil(atributo, valor);
		} catch (MaisPopException erro) {
			throw new EntradaException("Erro na atualizacao de perfil. "
					+ erro.getMessage(), erro);
		}
	}

	public void atualizaPerfil(String atributo, String valor, String antigoValor)
			throws MaisPopException {
		try {
			this.controller.atualizaPerfil(atributo, valor, antigoValor);
		} catch (MaisPopException erro) {
			throw new MaisPopException("Erro na atualizacao de perfil. "
					+ erro.getMessage(), erro);
		}
	}

	public String atualizaRanking() {
		return this.controller.exibeRanking();
	}

	public String atualizaTrendingTopics() {
		return this.controller.melhoresHashtags();
	}

	public String cadastraUsuario(String nome, String email, String senha,
			String dataNascimento) throws EntradaException,
			UsuarioExistenteException {
		try {
			this.controller.cadastraUsuario(nome, email, senha, dataNascimento);
		} catch (EntradaException erro) {
			throw new EntradaException("Erro no cadastro de Usuarios. "
					+ erro.getMessage(), erro);
		} catch (UsuarioExistenteException erro) {
			throw erro;
		}
		return email;
	}

	public String cadastraUsuario(String nome, String email, String senha,
			String dataNascimento, String imagem) throws EntradaException,
			UsuarioExistenteException {
		try {
			this.controller.cadastraUsuario(nome, email, senha, dataNascimento,
					imagem);
		} catch (EntradaException erro) {
			throw new EntradaException("Erro no cadastro de Usuarios. "
					+ erro.getMessage(), erro);
		} catch (UsuarioExistenteException erro) {
			throw erro;
		}

		return email;
	}

	public void criaPost(String texto, String dataPostagem)
			throws EntradaException {
		try {
			this.controller.postar(texto, dataPostagem);
		} catch (EntradaException erro) {
			throw new EntradaException("Nao eh possivel criar o post. "
					+ erro.getMessage(), erro);
		}
	}

	public void curtirPost(String emailUsuario, int postagem)
			throws UsuarioInexistenteException, EntradaException {
		this.controller.curtirPost(emailUsuario, postagem);
	}

	public void fechaSistema() throws LogicaException {
		this.controller.fechaSistema();

	}

	public String getConteudoPost(int indice, int postagem)
			throws EntradaException, ItemInexistenteException {
		try {
			return this.controller.getConteudo(indice, postagem);
		} catch (ItemInexistenteException erro) {
			throw new EntradaException("Item #" + indice
					+ " nao existe nesse post, ele possui apenas "
					+ erro.getMessage() + " itens distintos.");

		} catch (EntradaException erro) {
			throw new ItemInexistenteException("Requisicao invalida. "
					+ erro.getMessage(), erro);
		}
	}

	public String getInfoUsuario(String atributo) throws EntradaException,
			LogicaException {
		return this.controller.getInfoUsuario(atributo);

	}

	public String getInfoUsuario(String atributo, String email)
			throws EntradaException, LogicaException {
		return this.controller.getInfoUsuario(atributo, email);
	}

	public String getNextNotificacao() throws ItemInexistenteException {
		return this.controller.getProxNotificacao();
	}

	public int getNotificacoes() {
		return this.controller.getNotificacoes();
	}

	public int getPopsPost(int indice) {
		return this.controller.getPopsPost(indice);
	}

	public int getPopsUsuario() {
		return this.controller.getPopsUsuario();
	}

	public int getPopsUsuario(String emailUsuario) throws UsuarioException {
		try {
			return this.controller.getPopsUsuario(emailUsuario);
		} catch (UsuarioException erro) {
			throw new UsuarioException("Erro na consulta de Pops. "
					+ erro.getMessage(), erro);
		}
	}

	public String getPopularidade() {
		return this.controller.getPopularidade();
	}

	public String getPost(int postagem) {
		return this.controller.getPostagem(postagem);
	}

	public String getPost(String atributo, int indice) {
		return this.controller.getPostagem(atributo, indice);
	}
	
	public int getQtdAmigos() {
		return this.controller.getQtdAmigos();
	}

	public void iniciaSistema() {

	}

	public void login(String email, String senha) throws LogicaException,
			SenhaException {
		try {
			this.controller.login(email, senha);
		} catch (UsuarioInexistenteException erro) {
			throw new UsuarioInexistenteException(
					"Nao foi possivel realizar login. " + erro.getMessage(),
					erro);
		} catch (LogarDeslogarException erro) {
			throw new LogarDeslogarException(
					"Nao foi possivel realizar login. " + erro.getMessage(),
					erro);
		}
	}

	public void logout() throws LogarDeslogarException {
		this.controller.logout();
	}

	public int qtdCurtidasDePost(int indice) throws ItemInexistenteException {
		try {
			return this.controller.qtdCurtidasDePost(indice);
		} catch (ItemInexistenteException erro) {
			throw new ItemInexistenteException("Post #" + indice
					+ " nao existe. " + erro.getMessage(), erro);
		}
	}

	public int qtdRejeicoesDePost(int indice) {
		return this.controller.qtdRejeicoesDePost(indice);
	}
	
	


	public void rejeitaAmizade(String emailUsuario)
			throws UsuarioInexistenteException, SolicitacaoException {
		this.controller.rejeitaAmizade(emailUsuario);
	}

	public void rejeitarPost(String emailUsuario, int postagem)
			throws UsuarioInexistenteException, EntradaException {
		this.controller.descurtirPost(emailUsuario, postagem);
	}

	// teste de ranking

	public void removeAmigo(String emailUsuario)
			throws UsuarioInexistenteException {
		this.controller.removeAmigo(emailUsuario);
	}

	public void removeUsuario(String email) throws UsuarioInexistenteException {
		this.controller.removeUsuario(email);
	}
	
	
	//Tentatica Feed
	public void imprimeFeed() {
		this.controller.imprimeFeed();
	}
	
	public void atualizaFeed() {
		this.controller.atualizaFeed();
	}
	
}
