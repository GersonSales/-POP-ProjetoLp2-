package projeto.maispop.midia;

public abstract class Midia implements Postavel{
	private String conteudo;

	public Midia(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void reproduzir() {
		System.out.println("Reproduzindo: " + this.conteudo);
	}

}
