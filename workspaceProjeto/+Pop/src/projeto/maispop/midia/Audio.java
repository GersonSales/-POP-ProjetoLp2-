package projeto.maispop.midia;

public class Audio extends Midia {

	private static final CharSequence TAG_INICIAL = "<audio>";
	private static final CharSequence TAG_FINAL = "</audio>";

	public Audio(String conteudo) {
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
		conteudo = "$arquivo_audio:" + conteudo;
		
		return conteudo;
	}

}
