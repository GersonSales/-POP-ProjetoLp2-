package projeto.maispop.midia;

public class Imagem extends Midia {

	public Imagem(String conteudo) {
		super(conteudo);
	}
	
	public String getMarcacao() {
		return "<imagem>";
	}
	
	@Override
	public String toString() {
		return getConteudo();
	}

}
