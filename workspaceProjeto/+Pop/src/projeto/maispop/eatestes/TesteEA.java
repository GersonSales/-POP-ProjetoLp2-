package projeto.maispop.eatestes;

import easyaccept.EasyAccept;

//alteracao master

/**
 * Classe destinada a aplicacao de testes na facade do projeto. Ao executar esse
 * main sera aplicado os testes de todos os casos adicionados a lista. O projeto
 * encontra-se na versao 0.4, ou seja, passou de todos os testes ate o caso de
 * teste 3(tres), nada alem disso. Qualquer alteracao feita no projeto devera
 * ser rapidamente verificada, aconselho que execute novamente os testes toda
 * vez que fizer alguma alteracao relacionada ao tema de cada teste, por menor
 * que seja a alteracao nao hesite, teste. Se quiser adicionar um novo caso de
 * teste basta apenas adicionar o arquivo desejado na pasta 'EasyAccept' e
 * adicionar o caminho do arquivo a lista 'args' a..
 * 
 * @author Gerson Sales.
 *
 */
public class TesteEA {

	public static void main(String[] args) {
		args = new String[] { "projeto.maispop.sistema.Facade",
				"EasyAccept/CasoDeUso_1.txt", "EasyAccept/CasoDeUso_2.txt",
				"EasyAccept/CasoDeUso_3.txt", "EasyAccept/CasoDeUso_4.txt",
				"EasyAccept/CasoDeUso_5.txt", "EasyAccept/CasoDeUso_6.txt",
				"EasyAccept/CasoDeUso_7.txt", "EasyAccept/usecase_8.txt"};
		EasyAccept.main(args);
	}

}
