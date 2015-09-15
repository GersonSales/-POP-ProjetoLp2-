package projeto.maispop.midia;

public class Mensagem extends Midia {

	public Mensagem(String conteudo) {
		super(conteudo);
	}

	public static String getMarcacao() {
		return "Mensagem";
	}
	
	@Override
	public String toString() {
		return getConteudo();
	}

}
