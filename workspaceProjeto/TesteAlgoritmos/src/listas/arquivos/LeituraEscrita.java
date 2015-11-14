package listas.arquivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LeituraEscrita {
	
	public static void escreveTodos(Object objetos) throws Exception {
		try {
			File arquivo = new File("arquivo.dat");
			FileOutputStream fluxoSaida = new FileOutputStream(arquivo);
			BufferedOutputStream fluxoBuffer = new BufferedOutputStream(fluxoSaida);
			ObjectOutputStream fluxoSaidaObjeto = new ObjectOutputStream(fluxoBuffer);
			
			fluxoSaidaObjeto.writeObject(objetos);
			
			
			fluxoSaidaObjeto.close();
		}catch (Exception erro) {
			throw erro;
		}
	}
	
	public static Object leObjetos() throws Exception {
		try {
			File arquivo = new File("arquivo.dat");
			
			if (!(arquivo.exists())) {
				throw new Exception("Arquivo nao exite!");
			}
			
			FileInputStream fluxoEntrada = new FileInputStream(arquivo);
			BufferedInputStream fluxoBuffer = new BufferedInputStream(fluxoEntrada);
			ObjectInputStream fluxoObjeto = new ObjectInputStream(fluxoBuffer);
			
			Object objeto = fluxoObjeto.readObject();
			
			
			fluxoObjeto.close();
					
			return objeto;
			
		}catch (Exception erro) {
			throw erro;
		}
	}

}
