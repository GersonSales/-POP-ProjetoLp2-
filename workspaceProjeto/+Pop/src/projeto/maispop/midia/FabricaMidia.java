package projeto.maispop.midia;

import java.util.ArrayList;
import java.util.List;

import projeto.maispop.excecoes.EntradaException;

public enum FabricaMidia {

	IMAGEM {
		@Override
		public String getMarcacao() {
			return Imagem.getMarcacao();
			
		}

		@Override
		public Postavel getMidia(String conteudo) {
			return new Imagem(conteudo);
		}
	},

	AUDIO {
		@Override
		public Postavel getMidia(String conteudo) {
			return new Audio(conteudo);
		}

		@Override
		public String getMarcacao() {
			return Audio.getMarcacao();
		}
	},
	HASHTAG {

		@Override
		public Postavel getMidia(String conteudo) throws EntradaException {
			return new HashTag(conteudo);
		}

		@Override
		public String getMarcacao() {
			return HashTag.getMarcacao();
		}
	},

	MENSAGEM {

		@Override
		public Postavel getMidia(String conteudo) throws EntradaException {
			return new Mensagem(conteudo);
		}

		@Override
		public String getMarcacao() {
			return Mensagem.getMarcacao();
		}
	};
 
	public abstract Postavel getMidia(String conteudo) throws EntradaException;

	public abstract String getMarcacao();

	public static List<Postavel> getListaMidia(String conteudo)
			throws EntradaException {
		List<Postavel> listaMidia = new ArrayList<>();
		String[] postagemSplit = conteudo.split(" ");
		String texto = "";

		boolean adiciona = true;
		for (String string : postagemSplit) {

			for (FabricaMidia fabMidia : FabricaMidia.values()) {
				if (string.matches(fabMidia.getMarcacao())) {
					listaMidia.add(fabMidia.getMidia(string));
					adiciona = false;
					break;
				}

				if (fabMidia == FabricaMidia.HASHTAG && !adiciona) {
					listaMidia.add(fabMidia.getMidia(string));
				}
			}

			if (adiciona) {
				texto = texto == "" ? texto + string : texto + " " + string;
				continue;
			}
		}
		listaMidia.add(0, FabricaMidia.MENSAGEM.getMidia(texto));

		return listaMidia;
	}

}
