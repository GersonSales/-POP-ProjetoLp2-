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

import projeto.maispop.excecoes.EscritaException;
import projeto.maispop.excecoes.LeituraException;

/**
 * Classe responsavel por criar a persistencia em arquivos. Tem seus metodos
 * pois nao se trata de um objeto e sim de um utilitario.
 * 
 * @author Gerson Sales
 *
 */
public class GerenciadorES {

	public static void gravarTexto(String caminho, String titulo, String texto, boolean acrescentar)
			throws EscritaException {
		try {
			File diretorio = new File(caminho);
			if (!(diretorio.exists())) {
				diretorio.mkdirs();
			}

			File arquivo = new File(caminho + titulo);
			FileWriter fluxoSaida = new FileWriter(arquivo, acrescentar);
			BufferedWriter escritor = new BufferedWriter(fluxoSaida);

			fluxoSaida.write(texto + "\n");

			escritor.close();

		} catch (Exception erro) {
			throw new EscritaException();
		}
	}

	public static void gravarTexto(String caminho, String titulo, String texto) throws EscritaException {
		gravarTexto(caminho, titulo, texto, false);
	}

	public static void gravaObjeto(String caminho, String titulo, Object objeto) throws EscritaException {
		try {
			File diretorio = new File(caminho);
			if (!(diretorio.exists())) {
				diretorio.mkdirs();
			}

			File arquivo = new File(caminho + titulo);
			FileOutputStream fluxoSaida = new FileOutputStream(arquivo);
			BufferedOutputStream fluxoBuffer = new BufferedOutputStream(fluxoSaida);
			ObjectOutputStream fluxoSaidaObjeto = new ObjectOutputStream(fluxoBuffer);

			fluxoSaidaObjeto.writeObject(objeto);

			fluxoSaidaObjeto.close();

		} catch (Exception erro) {
			throw new EscritaException();
		}

	}

	public static Object leObjeto(String caminho, String titulo) throws LeituraException {
		try {
			File arquivo = new File(caminho + titulo);
			if (!(arquivo.exists())) {
				return null;
			}

			FileInputStream fluxoEntrada = new FileInputStream(arquivo);
			BufferedInputStream buffEntrada = new BufferedInputStream(fluxoEntrada);
			ObjectInputStream fluxoEntradaObjeto = new ObjectInputStream(buffEntrada);

			Object objeto = fluxoEntradaObjeto.readObject();

			fluxoEntradaObjeto.close();
			return objeto;
		} catch (EOFException erro) {
			throw new LeituraException(" Fim do arquivo!");
		} catch (Exception erro) {
			throw new LeituraException();
		}
	}

	public static void gravarLog(String caminho, String titulo, String... variaveis) throws EscritaException {
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		StringBuilder mensagem = new StringBuilder();
		for (String variavel : variaveis) {
			mensagem.append("|" + variavel + "|");
		}
		gravarTexto(caminho, titulo, methodName + "(" + mensagem + ")", true);
	}

	public static void gravarLog(String caminho, String titulo, Throwable erro) throws EscritaException {
		gravarTexto(caminho, titulo, "<!----Erro: " + erro.getMessage() + "----!>", true);
	}

}
