package testes.nullpoint;


public abstract class  Pessoa {
	private String nome;
	
	public Pessoa() {
		this.nome = "Sales";
	}
	
	public final String getNome() {
		return this.nome + getSobrenome();
	}
	
	public abstract String getSobrenome();


}
