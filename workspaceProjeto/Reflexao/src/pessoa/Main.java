package pessoa;


public class Main {
	public static void main(String[] args) {

		String padraoData = "[0-9]{2,2}/[0-9]{2,2}/[0-9]{4,4}";
		String padraoHora = "[0-9]{2,2}:[0-9]{2,2}:[0-9]{2,2}";
		String padraoEmail = "\\w+(\\.*\\w+)*@\\w+\\.\\w{2,3}(\\.{1,1}\\w{2,2})*";
		String padraoImagem  = "\\w+(/\\w+)*\\.(png|jpg)";
		
		System.out.println("PadraoData: " + "24/12/1995".matches(padraoData));
		System.out.println("Padrao DataHora: " + "10/12/2013 12:33:27".matches(padraoData + " " + padraoHora));
		System.out.println("Padrao Email: " + "gerson.junior@hotmail.com".matches(padraoEmail));
		System.out.println("Padrao imagem: " + "pasta/imagens/flor/de/lotus.png".matches(padraoImagem));
		
		System.out.println();
		System.out.println("c   c ".matches(".[^\\s]+"));
		
		
		
		
		
		
		
		
		

		
				
	}
}