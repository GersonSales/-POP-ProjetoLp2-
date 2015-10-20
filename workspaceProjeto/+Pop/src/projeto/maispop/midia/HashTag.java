package projeto.maispop.midia;

public class HashTag implements Postavel{
	
	private static final String TAG_INICIAL = "#";
	private String conteudo;

	public HashTag(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public static String getMarcacao() {
		return TAG_INICIAL + "\\S+";
	}
	
	@Override
	public String toString() {
		return getConteudo().replace(" ", ",");
	}

	@Override
	public String getConteudo() {
		return this.conteudo;
	}

	@Override
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
