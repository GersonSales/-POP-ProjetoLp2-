package projeto.maispop.eatestes;

import easyaccept.EasyAccept;
public class TesteEA {

	public static void main(String[] args) {
		args = new String[] { "projeto.maispop.sistema.Facade",
				"EasyAccept/CasoDeUso_1.txt", "EasyAccept/CasoDeUso_2.txt",
				"EasyAccept/CasoDeUso_3.txt", "EasyAccept/CasoDeUso_4.txt",
				"EasyAccept/CasoDeUso_5.txt", "EasyAccept/CasoDeUso_6.txt",
				"EasyAccept/CasoDeUso_7.txt"};
		EasyAccept.main(args);
	}

}
