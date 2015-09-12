package pessoa;
public class Pessoa extends Object {

	@NotNull
	@NotMenor
	private String nome;
	
	private int idade;
	private Validador validador;

	public Pessoa(@NotNull String nome, int idade) throws EntradaException {
		this.validador = Validador.getInstancia();
		this.nome = nome;
		this.idade = idade;
		validador.validaCampos(this);
	}

	public String getNome() {
		return nome;
	}
	
	
	public void setNome(@NotNull String nome) throws EntradaException {
		this.nome = nome;
		//validador.validaCampos(this);
		validador.validaMetodos(this);
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(@NotMenor(idade = 18) int idade) throws EntradaException {
		this.idade = idade;
		//validador.validaCampos(this);
		validador.validaMetodos(this);
	}
	@Override 
	public String toString() {
		return "";
	}

}
