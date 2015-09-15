package projeto.maispop.midia;

public class Imagem extends Midia {

	public Imagem(String conteudo) {
		super(conteudo);
	}
	
	public static String getMarcacao() {
		return "<imagem>";
	}
	
	@Override
	public String toString() {
		String conteudo;
		conteudo = getConteudo().replace(getMarcacao(), "");
		conteudo = conteudo.replace(getMarcacao().replace("<", "</"), "");
		conteudo = "$arquivo_imagem:" + conteudo;
		
		return conteudo;
	}


}
