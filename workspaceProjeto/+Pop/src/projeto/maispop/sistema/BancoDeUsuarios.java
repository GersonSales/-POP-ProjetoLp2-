package projeto.maispop.sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.EscritaException;
import projeto.maispop.excecoes.LogicaException;
import projeto.maispop.excecoes.RequisicaoException;
import projeto.maispop.excecoes.SenhaException;
import projeto.maispop.excecoes.UsuarioExistenteException;
import projeto.maispop.excecoes.UsuarioInexistenteException;
import projeto.maispop.usuario.Usuario;

/**
 * A classe <code>BancoDeUsuario</code> é responsavel por realizar o cadastro de
 * usuarios no sistema e mante-los armazenados. E de sua responsabilidade tambem
 * classificar os usuarios para que seja possivel a insercao dos usuarios em um
 * sistema de ranking.
 * 
 * @author Gerson Sales
 *
 */
public class BancoDeUsuarios implements Serializable {

	private static final long serialVersionUID = 648341662953227140L;
	private List<Usuario> usuarios;
	private Set<Usuario> ranking;

	/**
	 * Construtor do BancoDeUsuarios que apenas da incio a suas listas de
	 * armazenamento.
	 */
	public BancoDeUsuarios() {
		this.usuarios = new ArrayList<>();
		this.ranking = new LinkedHashSet<>();
	}

	/**
	 * Metodo responsavel por realizar modificações no cadastro original de um
	 * usuario.
	 * 
	 * @param atributo
	 *            Representa o atributo a ser modificado.
	 * @param valor
	 *            Novo valor do atributo especificado.
	 * @param email
	 *            Email do usuario a que sera aplicado as alteracoes.
	 * @throws EntradaException
	 *             Caso o atributo inserido nao exista ou o valor seja recebido
	 *             com formatacao indevida.
	 * @throws UsuarioInexistenteException
	 *             Caso o email recebido como parametro nao esteja associado a
	 *             nenhuma conta.
	 */
	public void atualizaPerfil(String atributo, String valor, String email)
			throws EntradaException, UsuarioInexistenteException {
		Usuario usuario = getUsuario(email);
		if (usuario == null) {
			throw new UsuarioInexistenteException("Usuario nao logado.");
		}

		switch (atributo) {
		case "Nome":
			usuario.setNome(valor);
			break;
		case "E-mail":
			usuario.setEmail(valor);
			break;
		case "Data de Nascimento":
			usuario.setDataNascimento(valor);
			break;
		case "Foto":
			usuario.setImagemPerfil(valor);
			break;
		default:
			throw new EntradaException();
		}
	}

	/**
	 * Metodo responsavel por realizar modificações no cadastro original de um
	 * usuario. Com objeto de modificacao sendo a senha de um usuario.
	 * 
	 * @param atributo
	 *            Valor inutilizado que serve apenas para a mudanca de
	 *            assinatura do metodo.
	 * @param valor
	 *            Nova senha que sera atribuida a conta do usuario.
	 * @param antigoValor
	 *            Antiga senha do usuario para que seja comfirmado que o
	 *            proprietario e quem deseja alterar suas informacoes.
	 * @param email
	 *            Email do usuario a que sera aplicado as alteracoes.
	 * @throws EntradaException
	 *             Caso o atributo inserido nao exista ou o valor seja recebido
	 *             com formatacao indevida.
	 * @throws UsuarioInexistenteException
	 *             Caso o email recebido como parametro nao esteja associado a
	 *             nenhuma conta.
	 */
	public void atualizaPerfil(String atributo, String valor,
			String antigoValor, String email) throws SenhaException,
			UsuarioInexistenteException {
		Usuario usuario = getUsuario(email);

		if (usuario.getSenha().equals(antigoValor)) {
			usuario.setSenha(valor);
		} else {
			throw new SenhaException("A senha fornecida esta incorreta.");
		}
	}

	/**
	 * Meotodo responsavel por realizar a insercao de um novo usuario no
	 * sistema.
	 * 
	 * @param nome
	 *            Nome do novo usuario.
	 * @param email
	 *            Email do novo usuario.
	 * @param senha
	 *            Senha do novo usuario.
	 * @param dataNascimento
	 *            Data de nascimento do novo usuario.
	 * @throws EntradaException
	 *             Caso algum dado seja recebido com a formatacao indevida.
	 * @throws UsuarioExistenteException
	 *             Caso exista um usuario com mesmo email ja cadastrado no
	 *             sistema.
	 */
	public void cadastraUsuario(String nome, String email, String senha,
			String dataNascimento) throws EntradaException,
			UsuarioExistenteException {
		if (verificaEmailExistente(email)) {
			throw new UsuarioExistenteException();
		}

		Usuario novoUsuario = new Usuario(nome, email, senha, dataNascimento);
		this.usuarios.add(novoUsuario);
	}

	/**
	 * Meotodo responsavel por realizar a insercao de um novo usuario no
	 * sistema.
	 * 
	 * @param nome
	 *            Nome do novo usuario.
	 * @param email
	 *            Email do novo usuario.
	 * @param senha
	 *            Senha do novo usuario.
	 * @param dataNascimento
	 *            Data de nascimento do novo usuario.
	 * @param imagem
	 *            Foto que estara presente na imagem de perfil do usuario.
	 * @throws EntradaException
	 *             Caso algum dado seja recebido com a formatacao indevida.
	 * @throws UsuarioExistenteException
	 *             Caso exista um usuario com mesmo email ja cadastrado no
	 *             sistema.
	 */
	public void cadastraUsuario(String nome, String email, String senha,
			String dataNascimento, String imagem) throws EntradaException,
			UsuarioExistenteException {

		if (verificaEmailExistente(email)) {
			throw new UsuarioExistenteException();
		}

		Usuario novoUsuario = new Usuario(nome, email, senha, dataNascimento,
				imagem);
		this.usuarios.add(novoUsuario);

	}

	/**
	 * Metodo que retorna a quantidade de usuarios cadastrados no sistema.
	 * 
	 * @return Tamanho da lista de cadastro.
	 */
	public int dimensaoBanco() {
		return this.usuarios.size();
	}

	/**
	 * Metodo que retorna a representacao em string do ranking de usuarios.
	 * 
	 * @return A string resultante.
	 */
	public String exibeRanking() {
		preencheRanking();
		int cont = 1;
		StringBuilder ranking = new StringBuilder();
		ranking.append("Mais Populares: ");
		for (Usuario usuario : this.ranking) {
			if (cont == 4) {
				cont = 1;
				ranking.append("| Menos Populares: ");
			}

			ranking.append("(" + cont + ") " + usuario.getNome() + " "
					+ usuario.getPopularidade() + "; ");
			cont++;
		}
		ranking.deleteCharAt(ranking.length() - 1);
		return ranking.toString();
	}

	/**
	 * Metodo que retorna o atributo solicitado pelo usuario. Dele mesmo ou de
	 * um amigo.
	 * 
	 * @param atributo
	 *            Atributo que sera retornado.
	 * @param email
	 *            Email do usuario que tera suas informacoes exibidas.
	 * @return A resultado da busca.
	 * @throws EntradaException
	 *             Caso atributo recebido nao exista.
	 * @throws LogicaException
	 *             Caso o usuario com o email recebido nao seja encontrado no
	 *             sistema ou tente-se acessar a senha do usuario.
	 */
	public String getInfoUsuario(String atributo, String email)
			throws EntradaException, LogicaException {
		Usuario usuario = getUsuario(email);
		if (usuario == null) {
			throw new UsuarioInexistenteException("Um usuarix com email "
					+ email + " nao esta cadastradx.");
		}

		switch (atributo) {
		case "Nome":
			return usuario.getNome();
		case "Email":
			return usuario.getEmail();
		case "Senha":
			throw new RequisicaoException("A senha dx usuarix eh protegida.");
		case "Data de Nascimento":
			return usuario.getDataNascimento();
		case "Foto":
			return usuario.getImagemPerfil();
		default:
			throw new EntradaException();
		}
	}

	/**
	 * Busca no sistema um usuario cadastrado com o email recebido como
	 * parametro.
	 * 
	 * @param emailUsuario
	 *            Email a qual a busca partira.
	 * @return O usuario proprietario do email, caso seja encontrado.
	 * @throws UsuarioInexistenteException
	 *             Caso nao exista no sistema nenhum usuario com o este email.
	 */
	public Usuario getUsuario(String emailUsuario)
			throws UsuarioInexistenteException {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(emailUsuario)) {
				return usuario;
			}
		}
		throw new UsuarioInexistenteException("Um usuarix com email "
				+ emailUsuario + " nao esta cadastradx.");
	}

	/**
	 * Ordena o lista de usuarios cadastrados de forma crescente.
	 */
	private void ordenaCrescente() {
		Collections.sort(this.usuarios);
	}

	/**
	 * Ordena o lista de usuarios cadastrados de forma decrescente.
	 */
	private void ordenaDecrescente() {
		this.usuarios.sort((usuario, outroUsuario) -> (outroUsuario
				.compareTo(usuario)));
	}

	/**
	 * Poe os primeiros tres usuarios da lista de cadastrados e poe no ranking.
	 */
	private void poe3primeiros() {
		for (int i = 0; i < 3; i++) {
			this.ranking.add(this.usuarios.get(i));
		}
	}

	/**
	 * Preenche o ranking de forma que ele contenha as tres melhores e as tres
	 * piores colocacoes.
	 */
	private void preencheRanking() {
		this.ranking.clear();

		ordenaDecrescente();
		poe3primeiros();

		ordenaCrescente();
		poe3primeiros();

	}

	/**
	 * Remove da lista de cadastrados o usuario detentor do email passado como
	 * parametro.
	 * 
	 * @param email
	 *            Email do usuario que sera removido.
	 * @throws UsuarioInexistenteException
	 *             Caso o usuario com tal email nao esteja cadastrado no
	 *             sistema.
	 */
	public void removeUsuario(String email) throws UsuarioInexistenteException {
		this.usuarios.remove(getUsuario(email));
	}

	/**
	 * Salva em um arquivo persistente todas as postagens de todos os usuarios
	 * cadastrados no sistema.
	 * 
	 * @throws EscritaException
	 *             Caso ocorra algum erro durante o processo de escrita no
	 *             arquivo.
	 */
	public void salvarPostagensUsuarios() throws EscritaException {
		for (Usuario usuario : this.usuarios) {
			usuario.salvarPostagens();
		}
	}

	/**
	 * Verifica se ja existe certo email cadastrado no sistema.
	 * 
	 * @param email
	 *            Email que sera o alvo da busca.
	 * @return Retorna true caso ja exista algum usuario cadastrado com este
	 *         email e retorna false caso nao exista.
	 */
	private boolean verificaEmailExistente(String email) {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

}
