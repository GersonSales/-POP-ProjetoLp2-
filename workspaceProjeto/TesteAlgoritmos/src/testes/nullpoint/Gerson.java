package testes.nullpoint;

public class Gerson extends Temp {

	private String sobrenome;

	public Gerson(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public static void main(String[] args) {
		Gerson gerson = new Gerson(" Araujo");
		
		System.out.println(gerson.getSobrenome());


	}

}
