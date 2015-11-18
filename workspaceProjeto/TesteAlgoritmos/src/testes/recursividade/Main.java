package testes.recursividade;


import testes.recursividade.No;

public class Main {
	
	
	public void insere(No noAtual, Integer novoValor) throws Exception {
		if (noAtual.getValor() == null) {
			noAtual.setValor(novoValor);
		}else if (noAtual.getValor() < novoValor) {
			if (noAtual.getDireita() == null) {
				noAtual.setDireita(new No(novoValor));
			}else {
				insere(noAtual.getDireita(), novoValor);
			}
		}else if (noAtual.getValor() > novoValor) {
			if (noAtual.getEsquerda() == null) {
				noAtual.setEsquerda(new No(novoValor));
			}else {
				insere(noAtual.getEsquerda(), novoValor);
			}
		}else {
			throw new Exception("ERRO!");
		}
		
	}
	
	 public static void main(String[] args) throws Exception {
		Main main = new Main();

		No raiz = new No(null);
		try {


			
			main.insere(raiz, 8);
			main.insere(raiz, 10);
			main.insere(raiz, 1);
			main.insere(raiz, 4);

			
			
			System.out.println(raiz);
			


			
			
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
		
	}

}
