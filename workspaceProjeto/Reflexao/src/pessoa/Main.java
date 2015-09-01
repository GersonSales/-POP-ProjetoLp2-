package pessoa;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
			Validador.validaObjeto(criaEAltera());
		}catch (Throwable erro) {
			System.out.println(erro.getMessage());
		}
			
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
