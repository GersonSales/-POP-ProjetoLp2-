package testes.pop.arquivos;


public class Main {

	public static void main(String[] args) {
		ManipuladorES manipuladorES = new ManipuladorES();

		for (int i = 0; i < 3; i++) {
			manipuladorES.escreveObjeto(new Pessoa("Gerson", 20));
		}
		
		for (Object pessoa : manipuladorES.leArquivoObjeto()) {
			System.out.print(pessoa);
		}

	}
}
