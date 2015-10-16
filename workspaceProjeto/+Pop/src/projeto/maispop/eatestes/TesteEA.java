package projeto.maispop.eatestes;

import easyaccept.EasyAccept;

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
 * @author Adson Cesar.
 * @author Gerson Sales.
 *
 */
public class TesteEA {

    public static void main(String[] args) {
	args = new String[] { "projeto.maispop.sistema.Facade",
		"EasyAccept/CasoDeTeste1.txt", "EasyAccept/CasoDeTeste2.txt",
		"EasyAccept/CasoDeTeste3.txt", "EasyAccept/CasoDeTeste4.txt" };
	EasyAccept.main(args);
    }
    
}
