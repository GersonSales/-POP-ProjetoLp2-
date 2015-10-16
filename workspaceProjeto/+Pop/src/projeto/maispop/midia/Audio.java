package projeto.maispop.midia;

public class Audio extends Midia {

	public Audio(String conteudo) {
		super(conteudo);
	}
	
<<<<<<< HEAD
	public String getMarcacao() {
=======
	public static String getMarcacao() {
>>>>>>> objetoMidia
		return "<audio>";
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return getConteudo();
=======
		String conteudo;
		conteudo = getConteudo().replace(getMarcacao(), "");
		conteudo = conteudo.replace(getMarcacao().replace("<", "</"), "");
		conteudo = "$arquivo_audio:" + conteudo;
		
		return conteudo;
>>>>>>> objetoMidia
	}

}
