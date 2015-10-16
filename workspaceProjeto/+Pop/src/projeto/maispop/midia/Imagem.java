package projeto.maispop.midia;

public class Imagem extends Midia {

	public Imagem(String conteudo) {
		super(conteudo);
	}
	
<<<<<<< HEAD
	public String getMarcacao() {
=======
	public static String getMarcacao() {
>>>>>>> objetoMidia
		return "<imagem>";
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return getConteudo();
	}

=======
		String conteudo;
		conteudo = getConteudo().replace(getMarcacao(), "");
		conteudo = conteudo.replace(getMarcacao().replace("<", "</"), "");
		conteudo = "$arquivo_imagem:" + conteudo;
		
		return conteudo;
	}


>>>>>>> objetoMidia
}
