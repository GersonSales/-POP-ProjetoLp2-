package testes.pop.midia;

public class ExpressaoRegular {

	public static void testeExpressao(String texto, String expressao) {
		texto.matches(expressao);
	}

	public static void main(String[] args) {
		String texto = "O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> #encontro #SemPreconceito";
		
		String[] textoSplit = texto.split("^[a-zA-Z0-9\\s.]*");
		String[] midiaSplit = texto.split("(<(\\w|\\W)*>|#)(\\w)*");
		String apenasTexto = texto.replaceAll("(<(\\w|\\W)*>|#)(\\w)*", "");
		System.out.println(apenasTexto);
		
		String apenasMidia = texto.replaceAll("^[a-zA-Z0-9\\s.]*", "");
		System.out.println(apenasMidia);
		
		String texto2 = "Eu nao sou preconceituosa, mais aqui esta cheio de anta nordestina. #anta #separa";
		texto2 = texto2.replaceAll("(\\s<(\\w|\\W)*>|\\s#|#)(\\w|\\s)*", "");
		
		
		System.out.println(texto2);
		
		
		System.out.println("<imagem>imagens/encontro_vinheta.jpg</imagem>".matches("(<(\\w|\\W)*>|#)(\\w)*"));
		System.out.println("O Encontro de amanha estara otimo. Vamos falar sobre os problemas do preconceito na escola.".matches("!(<(\\w|\\W)*>|#)(\\w)*"));

		System.out.println("Texto");

		System.out.print("[");
		for (String string : textoSplit) {
			System.out.print(string + ", ");
		}
		System.out.println("]");
		
		System.out.println("Texto");
		System.out.print("[");
		for (String string : midiaSplit) {
			System.out.print(string + ", ");
		}
		System.out.println("]");
		
		//captura texto ^[a-zA-Z0-9\s.]* -- ^[a-zA-Z0-9\s.,]{0,200}
		//captura midia (<(\w|\W)*>|#)(\w)*
	}

}
