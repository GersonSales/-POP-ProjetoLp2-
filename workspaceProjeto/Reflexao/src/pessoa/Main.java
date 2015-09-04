package pessoa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {

		String regexNome = "[a-zA-z]+";
		Pattern padraoNome = Pattern.compile(regexNome);
		Matcher mesclagemNome = padraoNome.matcher("");
		
		String regexEmail = "[a-z]+@[a-z].com";
		Pattern padraoEmail = Pattern.compile(regexEmail);
		Matcher mesclagemEmail = padraoEmail.matcher("gerson@hotmail.com");
		
		
		
		if (mesclagemNome.find()) {
			System.out.println("Nome valido");
		}else {
			System.out.println("Nomeinvalido");
		}
		
		if(mesclagemEmail.find()) {
			System.out.println("Email valido");
		}else{
			System.out.println("Email invalido");
		}
		
		
		
				
	}
}