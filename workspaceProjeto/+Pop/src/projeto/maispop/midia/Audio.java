package projeto.maispop.midia;

public class Audio extends Midia {

	public Audio(String conteudo) {
		super(conteudo);
	}
	
	public static String getMarcacao() {
		return "<audio>";
	}
	
	@Override
	public String toString() {
		String conteudo;
		conteudo = getConteudo().replace(getMarcacao(), "");
		conteudo = conteudo.replace(getMarcacao().replace("<", "</"), "");
		conteudo = "$arquivo_audio:" + conteudo;
		
		return conteudo;
	}

}
