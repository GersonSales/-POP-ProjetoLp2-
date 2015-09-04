package pessoa;

import java.beans.MethodDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.function.Consumer;

public class Validador {

	private static Validador instancia;

	private Validador() {

	}

	public static Validador getInstancia() {
		if (instancia == null) {
			instancia = new Validador();
		}
		return instancia;
	}

	public void validaCampos(Object objeto) throws EntradaException {
		Class<?> classeObjeto = objeto.getClass();

		Field[] campos = classeObjeto.getDeclaredFields();

		for (Field campo : campos) {
			campo.setAccessible(true);
			Object tipoCampo;
			try {
				tipoCampo = campo.get(objeto);

				Annotation[] anotacoes = campo.getAnnotations();

				for (Annotation anotacao : anotacoes) {
					Class<?> tipoAnotacao = anotacao.annotationType();

					if (tipoAnotacao == NotNull.class) {
						if (tipoCampo == null) {
							throw new EntradaException("Nao pode ser null");
						}

					} else if (tipoAnotacao == NotMenor.class) {
						NotMenor anotacaoNM = (NotMenor) anotacao;
						if (tipoCampo instanceof Integer) {
							Integer campoInt = (Integer) tipoCampo;
							if (campoInt < anotacaoNM.idade()) {
								throw new EntradaException(
										"Nao pode ser menor que "
												+ anotacaoNM.idade());
							}
						}
					}
				}

			} catch (IllegalArgumentException e) {
				// pass
			} catch (IllegalAccessException e) {
				// pass
			}

		}
	}

	public void validaMetodos(Object objeto) {
		
		Class<?> classeObjeto = objeto.getClass();

		Method[] metodos = classeObjeto.getMethods();
		for (Method metodo : metodos) {
			Parameter[] parametros = metodo.getParameters();
			for (Parameter parametro: parametros) {
				parametro.getAnnotation(NotNull.class).tipo();
				Annotation[] anotacoes = parametro.getDeclaredAnnotations();
				for (Annotation anotacao: anotacoes) {
					
					System.out.println(parametro + ": " + anotacao);
					
				}
				
			}

		}
	}

}