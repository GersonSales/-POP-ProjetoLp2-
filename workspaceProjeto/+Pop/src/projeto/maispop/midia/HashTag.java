package projeto.maispop.midia;

public class HashTag extends Midia {

	public HashTag(String conteudo) {
		super(conteudo);
	}
	
	public static String getMarcacao() {
		return "#";
	}
	
	@Override
	public String toString() {
		return getConteudo().replace(" ", ",");
	}

}
