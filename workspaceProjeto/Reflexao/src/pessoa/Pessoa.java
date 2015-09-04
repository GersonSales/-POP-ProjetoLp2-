package pessoa;
public class Pessoa extends Object {

	@NotNull()
	private String nome;

	@NotMenor
	private int idade;
	private Validador validador;

	public Pessoa(String nome, int idade) throws EntradaException {
		this.validador = Validador.getInstancia();
		this.nome = nome;
		this.idade = idade;
		validador.validaCampos(this);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws EntradaException {
		this.nome = nome;
		//validador.validaCampos(this);
		validador.validaMetodos(this);
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws EntradaException {
		this.idade = idade;
		//validador.validaCampos(this);
		validador.validaMetodos(this);
	}

}
