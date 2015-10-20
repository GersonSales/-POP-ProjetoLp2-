package projeto.maispop.midia;

public class Imagem extends Midia {
	
	private final static String TAG_INICIAL = "<imagem>";
	private final static String TAG_FINAL = "</imagem>";
	
	public Imagem(String conteudo) {
		super(conteudo);
	}
	
	public static String getMarcacao() {
		return TAG_INICIAL + ".+" + TAG_FINAL;
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
