package testes.recursividade;

public class No {
	private Integer valor;
	private No direita;
	private No esquerda;

	public No(Integer valor) {
		this.valor = valor;
		this.esquerda = null;
		this.direita = null;
	}
	
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	@Override
	public String toString() {
//		return "       ("
//				+ (getValor() == null ? "null" : getValor()).toString()
//				+ ")\n("
//				+ (getEsquerda() == null ? "null" : getEsquerda()).toString()
//				+ ")                 ("
//				+ (getDireita() == null ? "null" : getDireita()).toString()
//				+ ")";

		return "("
				+ (getEsquerda() == null ? "null" : getEsquerda()).toString()
				+ ")-----("
				+ (getValor() == null ? "null" : getValor()).toString()
				+ ")-----("
				+ (getDireita() == null ? "null" : getDireita()).toString()
				+ ")";
	}

}
