package testes.pop.arquivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorES {

	private ObjectOutputStream criaFluxoObjeto(File arquivo) {
		FileOutputStream fluxoSaida;
		BufferedOutputStream procIntermediario;
		ObjectOutputStream fluxoSaidaObjeto = null;
		try {
			if (arquivo.exists()) {
				fluxoSaida = new FileOutputStream(arquivo, true);
				procIntermediario = new BufferedOutputStream(fluxoSaida);
				fluxoSaidaObjeto = new AppendingObjectOutputStream(
						procIntermediario);
			} else {
				fluxoSaida = new FileOutputStream(arquivo);
				procIntermediario = new BufferedOutputStream(fluxoSaida);
				fluxoSaidaObjeto = new ObjectOutputStream(procIntermediario);
			}

		} catch (Exception erro) {
			System.out.println(erro.getMessage() + " erro no criaFluxoObjeto");
		}

		return fluxoSaidaObjeto;
	}

	public void escreveObjeto(Object objeto) {
		try {
			File arquivo = new File("arquivo.dat");
			ObjectOutputStream fluxoSaidaObjeto = criaFluxoObjeto(arquivo);

			fluxoSaidaObjeto.writeObject(objeto);

			fluxoSaidaObjeto.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage() + " erro no escreveObjeto");
		}
	}

	public List<Object> leArquivoObjeto() {
		List<Object> objetos = new ArrayList<>();
		try {
			File arquivo = new File("arquivo.dat");
			FileInputStream fluxoEntrada = new FileInputStream(arquivo);
			BufferedInputStream Interm = new BufferedInputStream(fluxoEntrada);
			ObjectInputStream fluxoEntradaObjeto = new ObjectInputStream(Interm);
			

			Object objeto;
			do {
				objeto = fluxoEntradaObjeto.readObject();
				objetos.add(objeto);
				
			}while (objeto != null);
			
			
			fluxoEntradaObjeto.close();

		} catch (EOFException erro) {
			System.out.println("EOF");
		} catch (Exception erro) {
			System.out.println(erro.getMessage() + " erro leArquivoObjeto");
		}

		return objetos;
	}

}
