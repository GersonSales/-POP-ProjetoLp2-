package projeto.maispop.postagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.ItemInexistenteException;

public class Postagem {

	private List<Postavel> listaMidia;
	private List<HashTag> hashtags;
	
	private String dataPostagem;

	private int popularidade;
	private int curtir;
	private int descurtir;
	
	private BancoHashtag bancoHashtag;
	
	public Postagem(String conteudo, String dataPostagem)
			throws EntradaException {
		this.listaMidia = new ArrayList<>();
		this.hashtags = new ArrayList<>();
		this.bancoHashtag = BancoHashtag.getInstancia();
		
		organizaPostagem(conteudo);
		this.dataPostagem = formatData(dataPostagem);
		
		bancoHashtag.adicionaTodas(hashtags);
		
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

	/**
	 * Metodo <i>organizaPostagem</i> responsavel por atribuir a
	 * <code>FabricaMidia</code> a resposabilidade de 'qubrar' a string passada
	 * como parametro e transforma-la em <code>Midia</code>.
	 * 
	 * @param conteudo; String a ser pecorrida.
	 * @throws EntradaException; Caso o conteudo passado nao atenda os requisitos.
	 */
	private void organizaPostagem(String conteudo) throws EntradaException {
		//this.listaMidia = FabricaPostavel.getListaMidia(conteudo);
		
		for (Postavel postavel : FabricaPostavel.getListaMidia(conteudo)) {
			if (postavel instanceof HashTag) {
				this.hashtags.add((HashTag)postavel);
			}else {
				this.listaMidia.add(postavel);
			}
			
		}
	}

	
	public String getMensagem() {
		String saida = "";
		for (Postavel midia : this.listaMidia) {
			if (!(midia instanceof HashTag)) {
				saida = saida == "" ? midia.getConteudo() : saida + " "
						+ midia.getConteudo();
			}
		}

		return saida;

	}

	public String getHashTags() {
		String saida = "";

		for (HashTag hashtag: this.hashtags) {
			if (hashtag instanceof HashTag) {
				saida = saida == "" ? hashtag.getConteudo() : saida + ","
						+ hashtag.getConteudo();
			}
		}

		return saida;
	}
	
	private int dimensaoListaMidia() {
		return this.listaMidia.size();
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

	public void adicionaHashTag(String hashTag) throws EntradaException {
		Postavel novaHashTag = new HashTag(hashTag);
		this.listaMidia.add(novaHashTag);
	}

	@Override
	public String toString() {
		String postagem = "";
		for (Postavel postavel : this.listaMidia) {
			postagem = postagem == "" ? postavel.toString() : postagem + " "
					+ postavel.getConteudo();
		}
		for (HashTag hashTag : hashtags) {
			postagem = postagem == "" ? hashTag.toString() : postagem + " "
					+ hashTag.getConteudo();

		}
		postagem = postagem + " (" + this.dataPostagem + ")";
		return postagem;
	}

}
