package projeto.maispop.midia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.ItemInexistenteException;

public class Postagem {

	List<Midia> listaMidia;
	String dataPostagem;

	private int popularidade;
	private int curtir;
	private int descurtir;

	public Postagem(String conteudo, String dataPostagem)
			throws EntradaException {
		this.listaMidia = new ArrayList<>();
		organizaPostagem(conteudo);
		this.dataPostagem = formatData(dataPostagem);
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

	private void organizaPostagem(String conteudo) throws EntradaException {
		String[] postagemSplit = conteudo.split(" ");
		String texto = "";

		boolean adiciona = true;
		for (String string : postagemSplit) {

			for (FabricaMidia fabMidia : FabricaMidia.values()) {
				if (string.contains(fabMidia.getMarcacao())) {
					this.listaMidia.add(fabMidia.getMidia(string));
					adiciona = false;
					break;
				}
				if (fabMidia == FabricaMidia.HASHTAG && !adiciona) {
					throw new EntradaException(
							"As hashtags devem comecar com '#'. Erro na hashtag: '"
									+ string + "'.");
				}
			}
			if (adiciona) {
				texto = texto == "" ? texto + string : texto + " " + string;
				continue;
			}
		}
		this.listaMidia.add(0, FabricaMidia.MENSAGEM.getMidia(texto));

	}

	public String getMensagem() {
		String saida = "";
		for (Midia midia : this.listaMidia) {
			if (!(midia instanceof HashTag)) {
				saida = saida == "" ? midia.getConteudo() : saida + " "
						+ midia.getConteudo();
			}
		}

		return saida;

	}

	public String getHashTags() {
		String saida = "";

		for (Midia midia : this.listaMidia) {
			if (midia instanceof HashTag) {
				saida = saida == "" ? midia.getConteudo() : saida + ","
						+ midia.getConteudo();
			}
		}

		return saida;
	}

	private int ultimoIndiceValido(int indice) {
		if (this.listaMidia.get(indice - 1) instanceof HashTag) {
			return ultimoIndiceValido(indice - 1);
		}

		return indice - 1;

	}

	public String getConteudo(int indice) throws ItemInexistenteException, EntradaException {
		if (indice < 0) {
			throw new EntradaException(
					"O indice deve ser maior ou igual a zero.");
		}
		Integer ultimoIndiceValido = ultimoIndiceValido(this.listaMidia.size());
		if (indice > ultimoIndiceValido) {
			ultimoIndiceValido++;
			throw new ItemInexistenteException(ultimoIndiceValido.toString());

		}
		Midia conteudo = this.listaMidia.get(indice);
		if (conteudo instanceof HashTag) {
			return null;
		} else {
			return conteudo.toString();
		}

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

	// <Metodos temporariamente em desuso>

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
	 * Metodo <i>getCurtir</i> responsavel por retornar um inteiro representando
	 * as 'curtidas' da postagem.
	 * 
	 * @return curtir. Inteiro representante de curtir.
	 */
	public int getCurtir() {
		return this.curtir;
	}

	public int getDescurtir() {
		return this.descurtir;
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

	public void adicionaHashTag(String hashTag) {
		Midia novaHashTag = new HashTag(hashTag);
		this.listaMidia.add(novaHashTag);
	}

	@Override
	public String toString() {
		String postagem = "";
		for (Midia midia : this.listaMidia) {
			postagem = postagem == "" ? midia.toString() : postagem + " "
					+ midia.getConteudo();
		}
		postagem = postagem + " (" + this.dataPostagem + ")";
		return postagem;
	}

}
