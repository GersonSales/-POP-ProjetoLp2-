package projeto.maispop.sistema;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GerenciadorES {
	
	
	public static void gravarTexto(String caminho, String titulo, String texto, boolean acrescentar) {
		try {
			File diretorio = new File(caminho);
			if (!(diretorio.exists())) {
				diretorio.mkdirs();
			}
			
			File arquivo = new File(caminho + titulo);
			FileWriter fluxoSaida = new FileWriter(arquivo, acrescentar);
			BufferedWriter escritor = new BufferedWriter(fluxoSaida);
			
			
			fluxoSaida.write(texto+"\n");
			
			escritor.close();
			
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + "<---ERRO!");
		}
	}
	
	public static void gravarTexto(String caminho, String titulo, String texto) {
		gravarTexto(caminho, titulo, texto, false);
	}
	
	
	public static void gravaObjeto(String caminho, String titulo, Object objeto) { 
		try {
//			File diretorio = new File(caminho);
//			if (!(diretorio.exists())) {
//				diretorio.mkdirs();
//			}
			
			File arquivo = new File(titulo);
			FileOutputStream  fluxoSaida = new FileOutputStream(arquivo);
			BufferedOutputStream fluxoBuffer = new BufferedOutputStream(fluxoSaida);
			ObjectOutputStream fluxoSaidaObjeto = new ObjectOutputStream(fluxoBuffer);
			
			fluxoSaidaObjeto.writeObject(objeto);
			
			fluxoSaidaObjeto.close();
			
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + "<---- erro gravacao");
		}
		
	}
	
	
	public static Object leObjeto(String caminho, String titulo) {
		Object objeto = null;
		try {
			File arquivo = new File(titulo);
			FileInputStream fluxoEntrada = new FileInputStream(arquivo);
			BufferedInputStream buffEntrada = new BufferedInputStream(fluxoEntrada);
			ObjectInputStream fluxoEntradaObjeto = new ObjectInputStream(buffEntrada);
			
			objeto = fluxoEntradaObjeto.readObject();
			
			fluxoEntradaObjeto.close();
		}catch (EOFException erro) {
			System.out.println(erro.getMessage() + "Erro EOF leobjeto");
		}catch (Exception erro) {
			System.out.println(erro.getMessage() + "erro exception le objeto");
		}
		return objeto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
