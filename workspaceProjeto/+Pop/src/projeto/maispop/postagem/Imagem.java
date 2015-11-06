package projeto.maispop.postagem;

import projeto.maispop.excecoes.EntradaException;

public class Imagem extends Midia {
	
	public static String getMarcacao() {
		return TAG_INICIAL + ".+" + TAG_FINAL;
	}
	private final static String TAG_INICIAL = "<imagem>";
	
	private final static String TAG_FINAL = "</imagem>";
	
	public Imagem(String conteudo) throws EntradaException {
		super(conteudo);
		
		if (!(conteudo.matches(getMarcacao()))) {
			throw new EntradaException("A imagem deve iniciar com "
					+ TAG_INICIAL + " e terminar com " + TAG_FINAL + ".");
		}
	}
	
	@Override
	public String toString() {
		String conteudo;
		conteudo = getConteudo().replace(TAG_INICIAL, "");
		conteudo = conteudo.replace(TAG_FINAL, "");
		conteudo = "$arquivo_imagem:" + conteudo;
		
		return conteudo;
	}


}
