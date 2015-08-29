package projeto.maispop.usuario;

import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;
import projeto.maispop.excecoes.ItemInexistenteException;

/**
 * @author Adson Cesar
 * @author Gerson Sales
 * @version 0.3
 * @see PostagemFormat
 * @see MuralUsuario
 *
 */
public class Postagem {

    private String texto;
    private String mensagem;
    private String hashTags;
    private String dataPostagem;
    private List<String> postagem;

    private PostagemFormat postagemFormat;

    private int popularidade;
    private int curtir;
    private int descurtir;

    /**
     * Construtor da classe <code>Postagem</code> que tem como funcao receber
     * duas Strigs(texto, dataPostagem) como parametro e organiza-las de acordo
     * com os seguintes parametros:
     * <ul>
     * <li>DataPostagem: Conjunto de numeros e caracteres que representa a data
     * e hora da postagem.</li>
     * <li>HashTags: Conjunto de palavras que sejam iniciadas pela <i>tag</i>#.</li>
     * 
     * <li>Mensagem: Todas as midias e qualquer caractere antecedido por elas.</li>
     * <li>Texto: Mensagem, midia, hashTag, data</li>
     * </ul>
     * Armazenando-os respectivamente numa lista.
     * 
     * @param texto
     *            . String de onde sera extraida toda informacao(exceto data)
     *            necessaria para construcao de uma postagem.
     * @param dataPostagem
     *            . String que representa a data e hora, para associa-la a
     *            postagem.
     * @throws EntradaException. Caso
     *             as Strings(texto, dataPostagem) sejam inseridos de forma
     *             incorreta.
     */
    public Postagem(String texto, String dataPostagem) throws EntradaException {
	this.postagemFormat = PostagemFormat.getInstancia();
	this.postagem = new ArrayList<>();

	this.hashTags = postagemFormat.getHashTag(texto);
	this.mensagem = postagemFormat.getMensagemMidia(texto);
	this.dataPostagem = postagemFormat.formatData(dataPostagem);
	this.texto = texto + " (" + this.dataPostagem + ")";

	this.postagem.add(postagemFormat.getMensagem(texto));
	this.postagem.addAll(postagemFormat.getMidia(texto));

    }

    /**
     * Metodo <i>getMensagem</i> responsavel por retonar uma String
     * representando a mensagem da postagem.
     * 
     * @return mensagem.
     */
    public String getMensagem() {
	return this.mensagem;
    }

    /**
     * Metodo <i>getHashTags</i> responsavel por retornar uma Strinf
     * representando todas as <i>hashtags</i> contidas na <code>Postagem</code>.
     * 
     * @return hashtags.
     */
    public String getHashTags() {
	return this.hashTags;
    }

    /**
     * Metodo <i>getConteudo</i> responsavel por receber um inteiro como
     * parametro e retornar o respectivo representante(indice) da lista de
     * postagem.
     * 
     * @param indice
     *            . Inteiro que servira para acessar a lista da postagem.
     * @return item. String que podera ser uma mensagem ou midia.
     * @throws EntradaException. Caso
     *             seja recebido um numero menor que 0(zero).
     * @throws ItemInexistenteException. Caso
     *             seja recebido um numero maior ou igual ao tamanho da lista de
     *             postagem.
     */
    public String getConteudo(int indice) throws EntradaException,
	    ItemInexistenteException {
	Integer postagemTam = this.postagem.size();
	String strTPostagemTam = postagemTam.toString();

	if (indice < 0) {
	    throw new EntradaException(
		    "O indice deve ser maior ou igual a zero.");
	} else if (indice >= postagemTam) {
	    throw new ItemInexistenteException(strTPostagemTam);
	}

	return this.postagem.get(indice);
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
     * Metodo <i>getData</i> responsavel por retornar uma String representendo a
     * data de criacao da postagem.
     * 
     * @return dataPostagem. String representando Data e Hora da postagem.
     */
    public String getData() {
	return this.dataPostagem;
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





    // </Metodos temporariamente em desuso>

    /**
     * Metodo <i>toString</i> responsavel por representar a entidade
     * <code>Postagem</code> de formar esteticamente agradavel.
     */
    @Override
    public String toString() {
	return this.texto;
    }



}
