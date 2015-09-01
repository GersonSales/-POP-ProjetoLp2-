package pessoa;

public class Main {
	public static void main(String[] args) throws Exception {
		Pessoa junior = new Pessoa(null, 20);
		try {
			Validador.validaObjeto(junior);
		}catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		System.out.println("Finalizado");
			
	}

	public static Pessoa criaEAltera() {
		Pessoa junior = new Pessoa(null, 19);
		System.out.println("Construido...");

		junior.setNome("gerson");
		System.out.println("Alterado...");

		System.out.println("Finalizado...");
		return junior;
	}

}