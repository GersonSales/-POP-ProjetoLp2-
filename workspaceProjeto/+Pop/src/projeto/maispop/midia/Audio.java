package projeto.maispop.midia;

public class Audio extends Midia {

	public Audio(String conteudo) {
		super(conteudo);
	}
	
	public String getMarcacao() {
		return "<audio>";
	}
	
	@Override
	public String toString() {
		return getConteudo();
	}

}
