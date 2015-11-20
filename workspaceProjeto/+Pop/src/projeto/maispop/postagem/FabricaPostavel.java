package projeto.maispop.postagem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;

/**
 * A <code>FabricaPostavel</code> e resposavel por criar tipo de midia e
 * qualquer coisa que seja considerada postavel. Seu objetivo e modularizar esse
 * processo e fazer com que o surgimento de novas midias gere o menos impacto
 * possivel.
 * 
 * @author Gerson Sales
 *
 */
public enum FabricaPostavel implements Serializable {

	IMAGEM {
		/**
		 * Criara uma nova instancia de uma imagem com os argumentos recebidos.
		 * 
		 * @param conteudo
		 *            Conteudo da nova imagem.
		 * @return O resultado da criacao(uma nova instancia de imagem).
		 * @throws EntradaException
		 *             Caso haja a tentativa de criar uma imagem com o conteudo
		 *             sem a formatacao correta.
		 */
		@Override
		public Imagem getInstancia(String conteudo) throws EntradaException {
			return new Imagem(conteudo);
		}

		/**
		 * Retorna a representacao da marcacao da imagem.
		 * 
		 * @return A marcacao de imagem.
		 */
		@Override
		public String getMarcacao() {
			return Imagem.getMarcacao();

		}
	},

	AUDIO {
		/**
		 * Criara uma nova instancia de uma Audio com os argumentos recebidos.
		 * 
		 * @param conteudo
		 *            Conteudo do novo Audio.
		 * @return O resultado da criacao(uma nova instancia de Audio).
		 * @throws EntradaException
		 *             Caso haja a tentativa de criar um Audio com o conteudo
		 *             sem a formatacao correta.
		 */
		@Override
		public Audio getInstancia(String conteudo) throws EntradaException {
			return new Audio(conteudo);
		}

		/**
		 * Retorna a representacao da marcacao da Audio.
		 * 
		 * @return A marcacao de Audio.
		 */
		@Override
		public String getMarcacao() {
			return Audio.getMarcacao();
		}
	},
	HASHTAG {

		/**
		 * Criara uma nova instancia de uma Hashtag com os argumentos recebidos.
		 * 
		 * @param conteudo
		 *            Conteudo da nova Hashtag.
		 * @return O resultado da criacao(uma nova instancia de Hashtag).
		 * @throws EntradaException
		 *             Caso haja a tentativa de criar uma Hashtag com o conteudo
		 *             sem a formatacao correta.
		 */
		@Override
		public Hashtag getInstancia(String conteudo) throws EntradaException {
			return new Hashtag(conteudo);
		}

		/**
		 * Retorna a representacao da marcacao da Hashtag.
		 * 
		 * @return A marcacao de Hashtag.
		 */
		@Override
		public String getMarcacao() {
			return Hashtag.getMarcacao();
		}
	},

	MENSAGEM {

		/**
		 * Criara uma nova instancia de uma Mensagem com os argumentos
		 * recebidos.
		 * 
		 * @param conteudo
		 *            Conteudo da nova Mensagem.
		 * @return O resultado da criacao(uma nova instancia de Mensagem).
		 * @throws EntradaException
		 *             Caso haja a tentativa de criar uma Mensagem com o
		 *             conteudo sem a formatacao correta.
		 */
		@Override
		public Mensagem getInstancia(String conteudo) throws EntradaException {
			return new Mensagem(conteudo);
		}

		/**
		 * Retorna a representacao da marcacao da Mensagem.
		 * 
		 * @return A marcacao de Mensagem.
		 */
		@Override
		public String getMarcacao() {
			return Mensagem.getMarcacao();
		}
	};

	/**
	 * Algoritmo responsavel por realizar a busca em uma string recebida para
	 * encontrar modelos de midias e algo que seja considerado postavel.
	 * 
	 * @param conteudo
	 *            String a qual sera realizada a busca.
	 * @return
	 * @throws EntradaException
	 *             Caso seja seja passado parametros com a formatacao invalida
	 *             na tentativa de criar algo postavel.
	 */
	public static List<Postavel> getListaPostavel(String conteudo)
			throws EntradaException {
		List<Postavel> listaPostavel = new ArrayList<>();
		String apenasTexto = conteudo.replaceAll(Midia.getMarcacao(), "");
		listaPostavel.add(MENSAGEM.getInstancia(apenasTexto));
		conteudo = conteudo.replaceAll(Mensagem.getMarcacao(), "");

		String[] postagemSplit = conteudo.split(" ");

		for (String string : postagemSplit) {
			for (FabricaPostavel fabPost : FabricaPostavel.values()) {
				if (string.matches(fabPost.getMarcacao())) {
					listaPostavel.add(fabPost.getInstancia(string));
					break;
				}
			}
		}

		return listaPostavel;
	}

	public abstract Postavel getInstancia(String conteudo)
			throws EntradaException;

	public abstract String getMarcacao();

}
