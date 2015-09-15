package projeto.maispop.midia;

public enum FabricaMidia {

	IMAGEM {
		@Override
		public String toString() {
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
		public String toString() {
			return Audio.getMarcacao();
		}
	},
	HASHTAG {

		@Override
		public Midia getMidia(String conteudo) {
			return new HashTag(conteudo);
		}

		@Override
		public String toString() {
			return HashTag.getMarcacao();
		}
	};

	public abstract Midia getMidia(String conteudo);

	public abstract String toString();

}
