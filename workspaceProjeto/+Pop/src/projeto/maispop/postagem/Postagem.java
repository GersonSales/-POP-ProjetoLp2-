package projeto.maispop.postagem;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import projeto.maispop.excecoes.DataException;
import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.ItemInexistenteException;

public class Postagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2347003503715322665L;
	private List<Postavel> listaMidia;
	private Set<Hashtag> hashtags;

	private String dataPostagem;

	private int popularidade;
	private int curtir;
	private int descurtir;

	public Postagem(String conteudo, String dataPostagem)
			throws EntradaException {
		this.listaMidia = new ArrayList<>();
		this.hashtags = new LinkedHashSet<>();

		organizaPostagem(conteudo);
		this.dataPostagem = formatData(dataPostagem);

		BancoHashtag.getInstancia().adicionaTodas(hashtags);

	}

	public void adicionaHashTag(String hashTag) throws EntradaException {
		Hashtag novaHashTag = new Hashtag(hashTag);
		if (this.hashtags.add(novaHashTag)) {
			BancoHashtag.getInstancia().adiciona(novaHashTag);
		}
	}

	/**
	 * Metodo <i>curtir</i> responsavel por incrementar as 'curtidas' da
	 * postagem na quantidade recebida como parametro.
	 * 
	 * @param curtida
	 *            . Inteiro a servir de incremento.
	 */
	public void curtir(int curtir) {
		this.popularidade = getPopularidade() + curtir;
		this.curtir = getCurtir() + 1;
	}

	public void descurtir(int descurtir) {
		this.popularidade = getPopularidade() - descurtir;
		this.descurtir = getDescurtir() + 1;
	}

	private int dimensaoListaMidia() {
		return this.listaMidia.size();
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Postagem) {
			Postagem outraPostagem = (Postagem) objeto;
			if (getData().equals(outraPostagem.getData())) {
				if (getMensagem().equals(outraPostagem.getMensagem())) {
					return true;
				}
			}
		}
		return false;
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
	 * @throws DataException
	 */
	public String formatData(String dataPostagem) throws DataException {

		String padraoData = "[0-9]{2,2}/[0-9]{2,2}/[0-9]{4,4} [0-2]{1}[0-9]{1}:[0-6]{1}[0-9]{1}:[0-6]{1}[0-9]{1}";

		if (!(dataPostagem.matches(padraoData))) {
			throw new DataException("Formato de data esta invalida.");
		}

		try {
			DateTimeFormatter padrao = DateTimeFormatter
					.ofPattern("dd/MM/yyyy HH:mm:ss");
			DateTimeFormatter novoPadrao = DateTimeFormatter
					.ofPattern("yyyy-MM-dd HH:mm:ss");
			String novaData = LocalDateTime.parse(dataPostagem, padrao).format(
					novoPadrao);
			return novaData;

		} catch (DateTimeException erro) {
			throw new DataException("Data nao existe.");
		}

	}

	public String getConteudo(int indice) throws ItemInexistenteException,
			EntradaException {
		if (indice < 0) {
			throw new EntradaException(
					"O indice deve ser maior ou igual a zero.");
		}
		Integer ultimoIndiceValido = dimensaoListaMidia();
		if (indice > this.listaMidia.size() - 1) {
			throw new ItemInexistenteException(ultimoIndiceValido.toString());

		}
		Postavel conteudo = this.listaMidia.get(indice);
		if (conteudo instanceof Hashtag) {
			return null;
		} else {
			return conteudo.toString();
		}

	}

	// <Metodos temporariamente em desuso>

	/**
	 * Metodo <i>getCurtir</i> responsavel por retornar um inteiro representando
	 * as 'curtidas' da postagem.
	 * 
	 * @return curtir. Inteiro representante de curtir.
	 */
	public int getCurtir() {
		return this.curtir;
	}

	/**
	 * Metodo <i>getData</i> responsavel por retornar uma String representendo a
	 * data de criacao da postagem.
	 * 
	 * @return dataPostagem. String representando Data e Hora da postagem.
	 */
	public String getData() {
		return this.dataPostagem;
	}

	public int getDescurtir() {
		return this.descurtir;
	}

	public String getHashTags() {
		String saida = "";
		for (Hashtag hashtag : this.hashtags) {
			saida = saida == "" ? hashtag.getConteudo() : saida + ","
					+ hashtag.getConteudo();
		}

		return saida;
	}

	public String getMensagem() {
		String saida = "";
		for (Postavel midia : this.listaMidia) {
			if (!(midia instanceof Hashtag)) {
				saida = saida == "" ? midia.getConteudo() : saida + " "
						+ midia.getConteudo();
			}
		}

		return saida;

	}

	public String getAudio() {
		StringBuilder audios = new StringBuilder();
		for (Postavel postavel : this.listaMidia) {
			if (postavel instanceof Audio) {
				audios.append(postavel + " ");
			}

		}
		return audios.toString();
	}

	public String getImagem() {
		StringBuilder imagens = new StringBuilder();
		for (Postavel postavel : this.listaMidia) {
			if (postavel instanceof Imagem) {
				imagens.append(postavel + " ");

			}

		}
		return imagens.toString();
	}

	public String getTexto() {
		StringBuilder texto = new StringBuilder();
		for (Postavel postavel : this.listaMidia) {
			if (postavel instanceof Mensagem) {
				texto.append(postavel + " ");

			}

		}
		return texto.toString();

	}

	/**
	 * Metodo <i>getPoularidade</i> responsavel por retornar um numero inteiro
	 * representando a popularidade da postagem.
	 * 
	 * @return popularidade. Inteiro representante de popularidade.
	 */
	public int getPopularidade() {
		return this.popularidade;
	}

	/**
	 * Metodo <i>organizaPostagem</i> responsavel por atribuir a
	 * <code>FabricaMidia</code> a resposabilidade de 'qubrar' a string passada
	 * como parametro e transforma-la em <code>Midia</code>.
	 * 
	 * @param conteudo
	 *            ; String a ser pecorrida.
	 * @throws EntradaException
	 *             ; Caso o conteudo passado nao atenda os requisitos.
	 */
	private void organizaPostagem(String conteudo) throws EntradaException {
		// this.listaMidia = FabricaPostavel.getListaMidia(conteudo);

		for (Postavel postavel : FabricaPostavel.getListaPostavel(conteudo)) {
			if (postavel instanceof Hashtag) {
				this.hashtags.add((Hashtag) postavel);
			} else {
				this.listaMidia.add(postavel);
			}

		}
	}

	@Override
	public String toString() {
		String postagem = "";
		for (Postavel postavel : this.listaMidia) {
			postagem = postagem == "" ? postavel.toString() : postagem + " "
					+ postavel.getConteudo();
		}
		for (Hashtag hashTag : hashtags) {
			postagem = postagem == "" ? hashTag.toString() : postagem + " "
					+ hashTag.getConteudo();

		}
		postagem = postagem + " (" + this.dataPostagem + ")";
		return postagem;
	}

}
