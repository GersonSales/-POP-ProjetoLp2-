package pessoa;

public class Pessoa {
	
	private String nome;
	private int idade;
	
	public Pessoa(@NotNull String nome, @NotMenor int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(@NotNull String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(@NotMenor int idade) {
		this.idade = idade;
	}
	
	

}
