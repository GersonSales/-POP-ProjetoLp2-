package projeto.maispop.excecoes;

import projeto.maispop.excecoes.EntradaException;

@SuppressWarnings("serial")
public class ImagemException extends EntradaException {
	public ImagemException() {
		super("Imagem invalida!");
	}
	
	public ImagemException(String mensagem) {
		super(mensagem);
	}
}
