package listas.arquivos;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	@SuppressWarnings("unchecked")//cast da lista(linha 23)
	public static void main(String[] args) throws Exception  {
		
		for (int i = 0; i < 100; i ++) {
			LeituraEscrita.escreveTodos(Math.random() * 100);
		}
		
		try {
			System.out.println(LeituraEscrita.leObjetos());
			
			
		}catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
		
		System.out.println("Finalizado!");
		
	}
	
	@SuppressWarnings("unchecked")
	public static Double calculaMedia() throws Exception {
		Double media = 0d;
		List<Double> listaReais = (List<Double>)LeituraEscrita.leObjetos();
		
		for (Double numero : listaReais) {
			media = media + numero;
		}
		
		return media / listaReais.size();
	}

}
