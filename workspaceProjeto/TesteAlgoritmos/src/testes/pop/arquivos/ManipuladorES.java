package testes.pop.arquivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorES {
	
	public void escreveTexto(String texto) {
		try {
			File arquivo = new File("arquivo.txt");
			FileWriter fluxoSaida = new FileWriter(arquivo, true);
			BufferedWriter fluxoSaidaString = new BufferedWriter(fluxoSaida);
			
			fluxoSaidaString.append(texto);
			
			fluxoSaidaString.close();
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + " escreveTexto");
		}
		
	}
	
	public List<String> leTexto() {
		List<String> palavras = new ArrayList<>();
		try{
			File arquivo = new File("arquivo.txt");
			FileReader fluxoEntrada = new FileReader(arquivo);
			BufferedReader fluxoEntradaString = new BufferedReader(fluxoEntrada);
			
			String palavra;
			do {
				palavra = fluxoEntradaString.readLine();
				if (palavra != null) {
					palavras.add(palavra);
				}
			}while (palavra != null);
			
			
			fluxoEntradaString.close();
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + " leTexto");
		}
		return palavras;
	}
	
	
	private ObjectOutputStream criaFluxoObjeto(File arquivo) {
		FileOutputStream fluxoSaida;
		BufferedOutputStream buffSaida;
		ObjectOutputStream fluxoSaidaObjeto = null;
		try {
			if (arquivo.exists()) {
				fluxoSaida = new FileOutputStream(arquivo, true);
				buffSaida = new BufferedOutputStream(fluxoSaida);
				fluxoSaidaObjeto = new AppendingObjectOutputStream(buffSaida);
			}else {
				fluxoSaida = new FileOutputStream(arquivo);
				buffSaida = new BufferedOutputStream(fluxoSaida);
				fluxoSaidaObjeto = new ObjectOutputStream(buffSaida);
			}
			
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + " criaFluxoObjeto");
		}
		
		return fluxoSaidaObjeto;
	}
	
	public void escreveObjeto(Object objeto) {
		try {
			File arquivo = new File("arquivo.dat");
			ObjectOutputStream fluxoSaidaObjeto = criaFluxoObjeto(arquivo);
			
			fluxoSaidaObjeto.writeObject(objeto);
			
			fluxoSaidaObjeto.close();
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + " escreveObjeto");
		}
		
	}
	
	
	public List<Object> leObjeto() {
		List<Object> objetos = new ArrayList<>();
		try {
			File arquivo = new File("arquivo.dat");
			FileInputStream fluxoEntrada = new FileInputStream(arquivo);
			BufferedInputStream buffEntrada = new BufferedInputStream(fluxoEntrada);
			ObjectInputStream fluxoEntradaObjeto = new ObjectInputStream(buffEntrada);
			
			Object objeto;
			do {
				objeto = fluxoEntradaObjeto.readObject();
				objetos.add(objeto);
			}while(objeto != null);
			
			fluxoEntradaObjeto.close();
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + " leObjeto");
		}
	
		return objetos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
