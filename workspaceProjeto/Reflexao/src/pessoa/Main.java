package pessoa;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
			String nome = null;
			Pessoa junior = new Pessoa("Junior", 17);
			Validador.validaObjeto(junior);
			System.out.println("Construido...");

			junior.setNome(nome);
			Validador.validaObjeto(junior);
			System.out.println("Alterado...");

			System.out.println("Finalizado...");
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	

}
