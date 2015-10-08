package projeto.maispop.midia;

import projeto.maispop.excecoes.EntradaException;

public enum FabricaMidia {

	IMAGEM {
		@Override
		public String getMarcacao() {
			return Imagem.getMarcacao();
		}

		@Override
		public Midia getMidia(String conteudo) {
			return new Imagem(conteudo);
		}
	},

	AUDIO {
		@Override
		public Midia getMidia(String conteudo) {
			return new Audio(conteudo);
		}

		@Override
		public String getMarcacao() {
			return Audio.getMarcacao();
		}
	},
	HASHTAG {

		@Override
		public Midia getMidia(String conteudo) {
			return new HashTag(conteudo);
		}

		@Override
		public String getMarcacao() {
			return HashTag.getMarcacao();
		}
	},
	
	MENSAGEM{

		@Override
		public Midia getMidia(String conteudo) throws EntradaException {
			return new Mensagem(conteudo); 
		}

		@Override
		public String getMarcacao() {
			return Mensagem.getMarcacao();
		}};

	public abstract Midia getMidia(String conteudo) throws EntradaException;

	
	public abstract String getMarcacao();

}
