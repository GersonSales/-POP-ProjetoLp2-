package testes.recursividade;

public class TestesRecursivos {

	public Integer fatorial(Integer numero) {
		return numero == 0 ? 1 : numero * fatorial(numero - 1);
	}

	public Integer fibonacci(Integer numero) {
		return numero < 2 ? numero : fibonacci(numero - 1)
				+ fibonacci(numero - 2);
	}

	public Integer mdc_euclides(Integer a, Integer b) {
		return a % b == 0? b : mdc_euclides(a, a %b);
	}

	public static void main(String[] args) {
		TestesRecursivos tr = new TestesRecursivos();
		System.out.println(tr.fatorial(4));
		System.out.println(tr.fibonacci(6));
		System.out.println(tr.mdc_euclides(-7, 3));

	}

}
