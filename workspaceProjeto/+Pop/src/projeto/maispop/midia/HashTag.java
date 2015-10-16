package projeto.maispop.midia;

public class HashTag extends Midia {

	public HashTag(String conteudo) {
		super(conteudo);
	}
	
<<<<<<< HEAD
	public String getMarcacao() {
=======
	public static String getMarcacao() {
>>>>>>> objetoMidia
		return "#";
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return getConteudo();
=======
		return getConteudo().replace(" ", ",");
>>>>>>> objetoMidia
	}

}
