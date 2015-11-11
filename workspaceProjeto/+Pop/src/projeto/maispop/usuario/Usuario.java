package projeto.maispop.usuario;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import projeto.maispop.postagem.Postagem;
import projeto.maispop.excecoes.DataException;
import projeto.maispop.excecoes.EmailException;
import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.ImagemException;
import projeto.maispop.excecoes.ItemInexistenteException;
import projeto.maispop.excecoes.LogicaException;
import projeto.maispop.excecoes.NomeException;
import projeto.maispop.excecoes.SenhaException;

/**
 * Classe <code>Usuario</code> representa individualmente um integrande do
 * sistema de usuarios da rede social <i>+Pop</i>.
 * 
 * @author Gerson Sales
 * @version 0.4
 * @see ListaDeAmigos
 * @see MuralUsuario
 */
public class Usuario implements Amigavel, Comparable<Usuario> {
	private String nome;
	private String email;
	private String senha;
	private String dataNascimento;
	private String imagemPerfil;

	private ListaDeAmigosAmigaveis listaDeAmigos;
	private Notificacoes notificacoes;
	private FeedUsuario feedUsuario;

	private MuralUsuario mural;

	private TipoUsuario tipoUsuario;
	private UsuarioFormat usuarioFormat;

	private static final String IMG_PERFIL_PADRAO = "resources/default.jpg";

	/**
	 * Construtor sobrecarrecado da classe <code>Usuario</code>.<br>
	 * que cria uma nova instancia de <code>Usuario</code> recebendo quase todas
	 * as informacoes necessarias para a acriacao do mesmo, com excecao da
	 * imagem, sendo assim passada uma imagem_padrao como parametro
	 * 
	 * @param nome
	 *            String que define o nome do usuario.
	 * @param email
	 *            String que define o e-mail do usuario.
	 * @param senha
	 *            String que define a senha do usuario.
	 * @param dataNascimento
	 *            String que define a data de nascimento do usuario.
	 * @throws EntradaException. Caso
	 *             o seja recebido como parametro algum atributo de formatacao
	 *             invalida.nome
	 * @throws LogicaException. Caso
	 *             haja algum erro durante o processo de gerenciamento de
	 *             informacoes.
	 */
	public Usuario(String nome, String email, String senha,
			String dataNascimento) throws EntradaException {
		this(nome, email, senha, dataNascimento, IMG_PERFIL_PADRAO);
	}

	/**
	 * Construtor sobrecarrecado da classe <code>Usuario</code>.<br>
	 * que cria uma nova instancia de <code>Usuario</code> recebendo todas as
	 * informacoes necessarias para a acriacao do mesmo.
	 * 
	 * @param nome
	 *            String que define o nome do usuario.
	 * @param email
	 *            String que define o e-mail do usuario.
	 * @param senha
	 *            String que define a senha do usuario.
	 * @param dataNascimento
	 *            String que define a data de nascimento do usuario.
	 * @param imagemPerfil
	 *            String que indica o caminho da imagem que sera usada no
	 *            perfil.
	 * @throws EntradaException. Caso
	 *             o seja recebido como parametro algum atributo de formatacao
	 *             invalida.
	 * @throws LogicaException. Caso
	 *             haja algum erro durante o processo de gerenciamento de
	 *             informacoes.
	 */
	public Usuario(String nome, String email, String senha,
			String dataNascimento, String imagemPerfil) throws EntradaException {
		this.usuarioFormat = UsuarioFormat.getInstancia();

		this.nome = usuarioFormat.validaNome(nome);
		this.email = usuarioFormat.validaEmail(email);
		this.senha = usuarioFormat.validaSenha(senha);
		this.imagemPerfil = usuarioFormat.validaImagem(imagemPerfil);
		this.dataNascimento = usuarioFormat
				.validaDataNascimento(dataNascimento);

		this.listaDeAmigos = new ListaDeAmigosAmigaveis();
		this.notificacoes = new Notificacoes();
		this.feedUsuario = new FeedUsuario(listaDeAmigos);

		this.mural = new MuralUsuario();

		this.tipoUsuario = new NormalPop();
	}

	public void aceitaAmizade(Amigavel amigo) {
		this.listaDeAmigos.aceitaAmizade(amigo);
	}

	// RELACIONAMENTO ENTRE USUARIOS:
	public void adicionaAmigo(Amigavel amigo) {
		this.listaDeAmigos.adicionaAmigo(amigo);
	}

	public void adicionaPops(int popBonus) {
		this.mural.adicionaPops(popBonus);
		atualizaTipo();
	}

	public void atualizaTipo() {
		int popularidade = this.mural.getPopularidade();

		if (popularidade < 500) {
			this.tipoUsuario = new NormalPop();
		} else if (popularidade <= 1000) {
			this.tipoUsuario = new CelebridadePop();
		} else {
			this.tipoUsuario = new IconePop();
		}
	}

	@Override
	public int compareTo(Usuario outroUsuario) {
		if (getPopularidade() == outroUsuario.getPopularidade()) {
			return getEmail().compareToIgnoreCase(outroUsuario.getEmail());
		}
		return getPopularidade() - outroUsuario.getPopularidade();
	}

	public boolean contemAmigo(String emailUsuario) {
		return this.listaDeAmigos.contemAmigo(emailUsuario);
	}

	public boolean contemPendencia(String emailUsuario) {
		return this.listaDeAmigos.contemPendencia(emailUsuario);
	}

	public void curtir(Postagem postagem) throws EntradaException {
		this.tipoUsuario.curtir(postagem);
	}

	public void descurtir(Postagem postagem) throws EntradaException {
		this.tipoUsuario.descurtir(postagem);
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Usuario) {
			Usuario outroUsuario = (Usuario) objeto;
			if (getEmail().equals(outroUsuario.getEmail())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo <i>getConteudoPost</i> responsavel por receber dois Inteiros como
	 * parametro, um representando a postagem escolhida da lista de postagens e
	 * outro representando o conteudo da postagem escolhida. Delegando toda a
	 * tarefa a <code>MuralDeUsuario</code>.
	 * 
	 * @param indice
	 *            . Inteiro representante do conteudo da postagem.
	 * @param postagem
	 *            . Inteiro representando a postagem a ser escolhida da lista de
	 *            postagens.
	 * @return conteudo. String representante do conteudo escolhido pelo indice.
	 * 
	 * @throws EntradaException. Caso
	 *             o usuario digite uma uma entrada desconhecida.
	 * @throws ItemInexistenteException. Caso
	 *             o item nao exista na <code>Postagem</code>.
	 */
	public String getConteudoPost(int indice, int postagem)
			throws EntradaException, ItemInexistenteException {
		return this.mural.getConteudoPost(indice, postagem);
	}

	/**
	 * Metodo <i>getDataNascimento</i> responsavel por retornar a String que
	 * representa a data de nascimento do <code>Usuario</code>.
	 * 
	 * @return dataDeNascimento. String representante da data em que o
	 *         <code>Usuario</code> nasceu.
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Metodo <i>getEmail</i> responsavel por retornar a String que representa o
	 * email do <code>Usuario</code>.
	 * 
	 * @return email. String representante do email do <code>Usuario</code>.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo <i>getImagemPerfil</i> responsavel por retornar a String que
	 * representa o caminho da imagem de perfil do <code>Usuario</code>.
	 * 
	 * @return imagemPerfil. String representante a imagem de perfil do
	 *         <code>Usuario</code>.
	 */
	public String getImagemPerfil() {
		return imagemPerfil;
	}

	/**
	 * Metodo <i>getNome</i> responsavel por retornar a String que representa o
	 * nome do <code>Usuario</code>.
	 * 
	 * @return nome. String representante do nome de <code>Usuario</code>.
	 */
	public String getNome() {
		return nome;
	}

	public int getNotificacoes() {
		return this.notificacoes.getNotificacoes();
	}

	public int getPopsPost(int indice) {
		return this.mural.getPopsPost(indice);
	}

	public int getPopularidade() {
		return this.mural.getPopularidade();
	}

	/**
	 * Metodo sobrecarregado <i>getPostagem</i> responsavel por receber como
	 * parametro um Inteiro que representa um indice a ser escolhido da lista de
	 * postagens. Delegando toda a tarefa a <code>MuralDeUsuario</code>.
	 * 
	 * @param indice
	 *            . Inteiro represntando um indice.
	 * @return <i>Postagem</i>. String de uma <i>Postagem</i>.
	 */
	public Postagem getPostagem(int indice) {
		return this.mural.getPostagem(indice);
	}

	/**
	 * Metodo sobrecarregado <i>getPostagem</i> responsavel por receber um
	 * String como parametro que representa o atributo a ser pesquisado e um
	 * Inteiro que representa o indice da lista de postagens a ser pesquisado.
	 * Retornando assim a postagem e sua respectiva informacao. Delegando toda a
	 * tarefa a <code>MuralDeUsuario</code>.
	 * 
	 * @param atributo
	 *            . String que representa o atributo a ser pesquisado.
	 * @param indice
	 *            . Inteiro que identificara qual postagem sera escolhida.
	 * @return mensagem/data/hashtag. String de informacoes cotida em
	 *         <code>Postagem</code>.
	 * @see <i>getPostagem(int indice);</i>.
	 */
	public String getPostagem(String atributo, int indice) {
		return this.mural.getPostagem(atributo, indice);
	}

	public String getProxNotificacao() throws ItemInexistenteException {
		return this.notificacoes.getProxNotificacao();
	}

	public int getQtdAmigos() {
		return this.listaDeAmigos.getQtdAmigos();
	}

	/**
	 * Metodo <i>getSenha</i> responsavel por retornar a String que representa a
	 * senha do <code>Usuario</code>.
	 * 
	 * @return senha. String representante da senha do <code>Usuario</code>.
	 */
	public String getSenha() {
		return senha;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario.toString();
	}

	public void notificaMe(String notificacao) {
		this.notificacoes.recebeNotificacao(notificacao);
	}

	/**
	 * Metodo <i>postar</i> responsavel por delegar ao
	 * <code>MuralDeUsuario</code> uma criacao de uma nova <code>Postagem</code>
	 * .
	 * 
	 * @param texto
	 *            . String representante do texto da postagem.
	 * @param dataPostagem
	 *            . String que representa a data da postagem.
	 * @throws EntradaException. Caso
	 *             seja recebido alguma String com informacoes invalidas.
	 */
	public void postar(String texto, String dataPostagem)
			throws EntradaException {
		this.mural.postar(texto, dataPostagem);
	}

	public int qtdCurtidasDePost(int indice) throws ItemInexistenteException {
		return this.mural.qtdCurtidasDePost(indice);
	}

	public int qtdRejeicoesDePost(int indice) {
		return this.mural.qtdRejeicoesDePost(indice);
	}

	public void rejeitaAmizade(Amigavel amigo) {
		this.listaDeAmigos.rejeitaAmizade(amigo);
	}

	public void removeAmigo(Amigavel amigo) {
		this.listaDeAmigos.removeAmigo(amigo);
	}

	/**
	 * Metodo <code>removeImagemPerfil</code> responsavel por modificar a imagem
	 * do perfil para uma imagem definida como padrao.
	 */
	public void removeImagemPerfil() {
		this.imagemPerfil = IMG_PERFIL_PADRAO;
	}

	/**
	 * Metodo <i>setDataNascimento</i> responsavel tentar atribuir uma nova data
	 * de nascimento <code>Usuario</code>. Recebendo uma String(nova
	 * dataDeNascimento) como parametro e verificando-a.
	 * 
	 * @param dataDeNascimento
	 *            . String representante do nova data de nascimento do
	 *            <code>Usuario</code>.
	 * @throws DataException. Caso
	 *             nao seja recebido uma data de nascimento valida.
	 */
	public void setDataNascimento(String dataNascimento) throws DataException {
		this.dataNascimento = usuarioFormat
				.validaDataNascimento(dataNascimento);
	}

	/**
	 * Metodo <i>setEmail</i> responsavel tentar atribuir um novo email ao
	 * <code>Usuario</code>. Recebendo uma String(novo email) como parametro e
	 * verificando-o.
	 * 
	 * @param email
	 *            . String representante do novo email do <code>Usuario</code>.
	 * @throws EmailException. Caso
	 *             nao seja recebido uma email valido.
	 */
	public void setEmail(String email) throws EmailException {
		this.email = usuarioFormat.validaEmail(email);
	}

	/**
	 * Metodo <i>setImagemPerfil</i> responsavel tentar atribuir uma nova imagem
	 * de perfil ao <code>Usuario</code>. Recebendo uma String(nova
	 * imagemPerfil) como parametro e verificando-a.
	 * 
	 * @param imagemPerfil
	 *            . String representante da nova imagem de perfil do
	 *            <code>Usuario</code>.
	 * @throws ImagemException. Caso
	 *             nao seja recebido uma imagem valida.
	 */
	public void setImagemPerfil(String imagemPerfil) throws ImagemException {
		this.imagemPerfil = usuarioFormat.validaImagem(imagemPerfil);
	}

	/**
	 * Metodo <i>setNome</i> responsavel tentar atribuir um novo nome ao
	 * <code>Usuario</code>. Recebendo uma String(novo nome) como parametro e
	 * verificando-o.
	 * 
	 * @param nome
	 *            . String representante do novo nome do <code>Usuario</code>.
	 * @throws NomeException. Caso
	 *             nao seja recebido uma nome valido.
	 */
	public void setNome(String nome) throws NomeException {
		this.nome = usuarioFormat.validaNome(nome);
	}

	/**
	 * Metodo <i>setSenha</i> responsavel tentar atribuir uma nova senha ao
	 * <code>Usuario</code>. Recebendo uma String(novo senha) como parametro e
	 * verificando-a.
	 * 
	 * @param senha
	 *            . String representante do novo senha do <code>Usuario</code>.
	 * @throws SenhaException. Caso
	 *             nao seja recebido uma senha valido.
	 */
	public void setSenha(String senha) throws SenhaException {
		this.senha = usuarioFormat.validaSenha(senha);
	}

	@Override
	public String toString() {
		String fdl = System.getProperty("line.separator");
		int idade = Period.between(LocalDate.parse(getDataNascimento()),
				LocalDate.now()).getYears();

		return "Nome: " + getNome() + fdl + "Idade: " + idade + fdl
				+ "E-mail: " + getEmail() + fdl + "Tipo: " + getTipoUsuario()
				+ fdl + "Popularidade: " + getPopularidade();
	}

	// tentativa de implementar o feed
	public List<Postagem> getFeedPostagem() {
		List<Postagem> postagens = new ArrayList<>();
		for (int i = 0; i < this.tipoUsuario.getFeedQtdPostagem(); i++) {
			postagens.add(this.mural.getPostagem(i));
		}

		return postagens;
	}

	public void imprimeFeed() {
		this.feedUsuario.imprimeFeed();
	}

	public void atualizaFeed() {
		this.feedUsuario.atualizar();
		
	}

}
