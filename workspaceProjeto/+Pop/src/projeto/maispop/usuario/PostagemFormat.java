package projeto.maispop.usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;

/**
 * Classe <code>PostagemFormat</code> constituida como uma <i>Singloton</i>. Tem
 * a funcao de oferecer um auxilio para a classe <i>Postagem</i> para que seja
 * feita todas as formatacoes necessarias na mesma. Levando em consideracoes as
 * exigencias dos casos de aceitacao do projeto de LP2: +pop.
 *
 * 
 * @author Gerson Sales
 * @author Adson Cesar
 * @see PostagemString
 * @version 0.3
 *
 */
public final class PostagemFormat {

	/**
	 * Variavel estatica(pertence a classe) que tem a responsabilidade de
	 * armazenar a instacia de <code>PostagemFormat</code>.
	 */
	public static PostagemFormat instancia;

	/**
	 * Construtor da classe <code>PostagemFormat</code> que tem a visibilidade
	 * definida como <i>private</i>, obedecendo um dos principios de uma
	 * <i>Singleton</i>, para que nenhuma outra classe possa criar instancias de
	 * <code>PostagemFormat</code>.
	 */
	private PostagemFormat() {
	}

	/**
	 * Metodo <i>getInstancia</i> responsavel por verificar se o atributo
	 * <i>instancia</i> ja teve valor definido, caso nao, cria uma nova
	 * instancia de <code>PostagemFormat</code>, caso sim, retorna o valor da
	 * varivel em questao.
	 * 
	 * @return PostagemFormat. Referencia unica da propria classe.
	 */
	public static PostagemFormat getInstancia() {
		if (instancia == null) {
			instancia = new PostagemFormat();
		}

		return instancia;
	}

	/**
	 * Metodo <i>getHashTag</i> responsavel por receber um texto como parametro
	 * e extrair dele apenas palavras consideradas como <i>hashtags</i>.
	 * 
	 * @param texto
	 *            . String usada para extrair as <i>hashtags</i>
	 * @return String. Nova String contendo apenas as <i>hashtags</i>
	 *         encontradas.
	 * @throws EntradaException. Caso
	 *             o algoritmo encontre uma palavra que nao contenha hashtag
	 *             apos ja ter encontrado a primeira. <br>
	 *             <b>Exemplo de erro</b>:
	 *             "texto. #primeiraHashTag SegundaHashTag #TerceiraHashTag".
	 */
	public String getHashTag(String texto) throws EntradaException {
		if (!(texto.contains("#"))) {
			return "";
		}

		texto = texto.substring(texto.indexOf("#"), texto.length());
		String[] hashTags = texto.split(" ");
		for (String palavra : hashTags) {
			if (!(palavra.contains("#"))) {
				throw new EntradaException(
						"As hashtags devem comecar com '#'. Erro na hashtag: '"
								+ palavra + "'.");
			}
		}
		return texto.replace(" ", ",");
	}

	/**
	 * Metodo <i>getMidia</i> responsavel por receber um texto como parametro e
	 * utilizar-se de um algoritmo para realizar uma busca em tal texto a
	 * procura de entidades de <i>midias</i>. Desprezando toda e qualquer
	 * informacao adicional, retornando apenas uma lista de <i>String</i>
	 * contendo todos as midias encontradas e devidamente formatadas. <br>
	 * <b>Exemplo de uso</b>: class.getMidia(
	 * "Texto referente ao exemplo &lt;audio&gt;midia.mp3&lt;/audio&gt;"); <br>
	 * <b>retorno</b> Lista: ["$arquivo_audio:midia.mp3"]
	 * 
	 * @param texto
	 *            . String usada para extrair as <i>midias</i>
	 * @return List. Uma nova lista contendo todos os caminhos de <i>midias</i>
	 *         extraidos.
	 */
	public List<String> getMidia(String texto) {
		String marcacao = "";
		texto = texto.replace(">", "> ");
		texto = texto.replace("<", " <");

		String[] textoSplit = texto.split(" ");
		List<String> midia = new ArrayList<>();
		String caminhoMidia = "$arquivo_";

		boolean adicionaPalavra = false;
		for (String palavra : textoSplit) {
			if (palavra.equals(""))
				continue;// .split() nao remove todos os espacacos.

			if (palavra.equals("<audio>") || palavra.equals("<imagem>")) {
				caminhoMidia = caminhoMidia
						+ palavra.substring(1, palavra.length() - 1) + ":";
				marcacao = palavra;

				adicionaPalavra = true;
				continue;
			}

			if (palavra.equals(marcacao.replace("<", "</"))) {
				midia.add(caminhoMidia);
				caminhoMidia = "$arquivo_";

				adicionaPalavra = false;
				continue;
			}

			if (adicionaPalavra) {
				caminhoMidia = caminhoMidia + palavra;
			}
		}
		return midia;
	}

	/**
	 * Metodo <i>getMensagem<i> responsavel por extrair do texto recebido como
	 * parametro apenas a mensagem contida nela, ou seja, desprezar qualquer
	 * informacao alem de um simples texo, como por exeplo <i>midias</i> e
	 * <i>hashtags</i>.
	 * 
	 * @param texto
	 *            . String recebida como parametro para realizacao da busca por
	 *            mensagem.
	 * @return mensagem. String de retorno contendo apenas a mensagem extraida
	 *         do texto original.
	 * @throws EntradaException. Caso
	 *             a mensagem extraida contenha mais do que 200(duzentos)
	 *             caracteres.
	 * @see <i>removeUltimoEspaco(String texto)</i>;
	 */
	public String getMensagem(String texto) throws EntradaException {
		int indexAudio = texto.indexOf("<audio>");
		texto = indexAudio == -1 ? texto : texto.substring(0, indexAudio);

		int indexImagem = texto.indexOf("<imagem>");
		texto = indexImagem == -1 ? texto : texto.substring(0, indexImagem);

		int indexHashTag = texto.indexOf("#");
		texto = indexHashTag == -1 ? texto : texto.substring(0, indexHashTag);

		if (texto.length() > 200) {
			throw new EntradaException(
					"O limite maximo da mensagem sao 200 caracteres.");
		}

		return removeUltimoEspaco(texto);
	}

	/**
	 * Metodo <i>getMensagemMidia<i> responsavel por extrair do texto recebido
	 * como parametro apenas a mensagem e a midia contida nela, ou seja,
	 * desprezar qualquer informacao alem, como por exeplo <i>hashtags</i>.
	 * 
	 * @param texto
	 *            . String de retorno contendo apenas a mensagem e midia
	 *            extraida do texto original.
	 * @return mensagemMidia. String de retorno contendo apenas a mensagem e
	 *         midia extraida do texto original.
	 * @throws EntradaException. Caso
	 *             a mensagem extraida contenha mais do que 200(duzentos)
	 *             caracteres.
	 * @see <i>removeUltimoEspaco(String texto)</i>
	 */
	public String getMensagemMidia(String texto) throws EntradaException {
		int indexHashTag = texto.indexOf("#");
		texto = indexHashTag == -1 ? texto : texto.substring(0, indexHashTag);
		if (texto.length() > 200) {
			throw new EntradaException(
					"O limite maximo da mensagem sao 200 caracteres.");
		}

		return removeUltimoEspaco(texto);

	}

	/**
	 * Metoro <i>removeUltimoEspaco</i> responsavel por receber uma String como
	 * parametro e realizar a retirada de forma recursiva dos ultimos caracteres
	 * contidos na mesmo, caso sejam 'espacos'.
	 * 
	 * @param texto
	 *            . String recebida como parametro para ser submetida a remocao.
	 * @return texto. Mesma String recebida, porem com o numero de 0(zero)
	 *         espacos no final.
	 * @see <i>getMensagem(String texto)</i>;
	 * @see <i>getMensagemMidia(String texto)</i>;
	 */
	private String removeUltimoEspaco(String texto) {
		if (texto.charAt(texto.length() - 1) != ' ') {
			return texto;
		}

		texto = texto.substring(0, texto.length() - 1);
		return removeUltimoEspaco(texto);
	}

	/**
	 * Metodo <i>formatData</i> responsavem por receber uma String representando
	 * uma data no formato dd/MM/aaaa e retornar uma nova String contendo os
	 * mesmos valos apenas ajustados de forma diferente, seguindo o seguinte
	 * padrao: aaaa-MM-dd.
	 * 
	 * @param dataPostagem
	 *            . String recebida como paramero para aplicacao do novo padrao.
	 * @return novaData. String representando uma data como um novo padrao de
	 *         formatacao.
	 */
	public String formatData(String dataPostagem) {
		DateTimeFormatter padrao = DateTimeFormatter
				.ofPattern("dd/MM/yyyy HH:mm:ss");
		DateTimeFormatter novoPadrao = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss");
		String novaData = LocalDateTime.parse(dataPostagem, padrao).format(
				novoPadrao);
		return novaData;
	}

}
