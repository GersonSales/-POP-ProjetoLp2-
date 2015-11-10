package testes.pop.arquivos;


public class Main {

	public static void main(String[] args) {
		ManipuladorES manipuladorES = new ManipuladorES();
		
		for (int i = 0; i < 5; i ++) {
			manipuladorES.escreveTexto("Linha: " + (i + 1) + "\n");
		}
		
		for (String palavra : manipuladorES.leTexto()) {
			System.out.println(palavra);
		}
		
		
		for (int i = 0; i < 5; i ++) {
			manipuladorES.escreveObjeto(new Pessoa("gerson", 20 + i));
		}
		
		for (Object  objeto : manipuladorES.leObjeto()) {
			System.out.println(objeto);
		}
		
		

	}
}
