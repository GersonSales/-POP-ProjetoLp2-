package testes.pop.arquivos;

import java.io.Serializable;

public class Pessoa extends Object implements Serializable {

	private static final long serialVersionUID = 4553548454779902499L;
	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String fdl = System.getProperty("line.separator");
		sb.append("Nome: " + this.nome + fdl + "Idade: " + this.idade + fdl
				+ "");

		return sb.toString();

	}

}
