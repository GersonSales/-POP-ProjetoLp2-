package pessoa;

public class Main {
	public static void main(String[] args) {
		try {
			Pessoa junior = new Pessoa("gerson", 18);
			System.out.println("Construido");
			junior.setIdade(123);
			System.out.println("idade setada");
			System.out.println();
			junior.setNome("casa");
			System.out.println();
			System.out.println("nome setado");
			System.out.println("Finalizado");
		} catch (EntradaException erro) {
			System.out.println(erro.getMessage());
		}

	}
}