package projeto.maispop.postagem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;

public enum FabricaPostavel implements Serializable {

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
			return new Hashtag(conteudo);
		}

		@Override
		public String getMarcacao() {
			return Hashtag.getMarcacao();
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

	public static List<Postavel> getListaPostavel(String conteudo) throws EntradaException {
		List<Postavel> listaPostavel = new ArrayList<>();
		String apenasTexto = conteudo.replaceAll(Midia.getMarcacao(), "");
		listaPostavel.add(MENSAGEM.getInstancia(apenasTexto));
		conteudo = conteudo.replaceAll(Mensagem.getMarcacao(), "");

		String[] postagemSplit = conteudo.split(" ");

		for (String string : postagemSplit) {

			for (FabricaPostavel fabPost : FabricaPostavel.values()) {
				if (string.matches(fabPost.getMarcacao())) {
					listaPostavel.add(fabPost.getInstancia(string));
					break;
				}
			}
		}

		return listaPostavel;
	}

	public abstract Postavel getInstancia(String conteudo) throws EntradaException;

	public abstract String getMarcacao();

}
