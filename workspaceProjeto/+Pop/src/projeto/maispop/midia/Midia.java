package projeto.maispop.midia;

public abstract class Midia {
	private String conteudo; // nome provisorio

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

<<<<<<< HEAD
	public abstract String getMarcacao();
=======
>>>>>>> objetoMidia
}
