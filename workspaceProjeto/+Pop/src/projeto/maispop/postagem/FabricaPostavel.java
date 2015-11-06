package projeto.maispop.postagem;

import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;

public enum FabricaPostavel {

	IMAGEM {
		@Override
		public Postavel getInstancia(String conteudo) throws EntradaException {
			return new Imagem(conteudo);
		}

		@Override
		public String getMarcacao() {
			return Imagem.getMarcacao();
			
		}
	},

	AUDIO {
		@Override
		public Postavel getInstancia(String conteudo) throws EntradaException {
			return new Audio(conteudo);
		}

		@Override
		public String getMarcacao() {
			return Audio.getMarcacao();
		}
	},
	HASHTAG {

		@Override
		public Postavel getInstancia(String conteudo) throws EntradaException {
			return new HashTag(conteudo);
		}

		@Override
		public String getMarcacao() {
			return HashTag.getMarcacao();
		}
	},

	MENSAGEM {

		@Override
		public Postavel getInstancia(String conteudo) throws EntradaException {
			return new Mensagem(conteudo);
		}

		@Override
		public String getMarcacao() {
			return Mensagem.getMarcacao();
		}
	};
 
	public static List<Postavel> getListaPostavel(String conteudo)
			throws EntradaException {
		List<Postavel> listaPostavel = new ArrayList<>();
		String[] postagemSplit = conteudo.split(" ");
		String texto = "";

		boolean adiciona = true;
		for (String string : postagemSplit) {

			for (FabricaPostavel fabPost : FabricaPostavel.values()) {
				if (string.matches(fabPost.getMarcacao())) {
					listaPostavel.add(fabPost.getInstancia(string));
					adiciona = false;
					break;
				}

				if (fabPost == FabricaPostavel.HASHTAG && !adiciona) {
					listaPostavel.add(fabPost.getInstancia(string));
				}
			}

			if (adiciona) {
				texto = texto == "" ? texto + string : texto + " " + string;
				continue;
			}
		}
		listaPostavel.add(0, FabricaPostavel.MENSAGEM.getInstancia(texto));

		return listaPostavel;
	}

	public abstract Postavel getInstancia(String conteudo) throws EntradaException;

	public abstract String getMarcacao();

}
