package pessoa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Validador {

	public static void validaObjeto(Object objeto) throws Exception {
		@SuppressWarnings("rawtypes")
		Class classeObjeto = objeto.getClass();

		for (Field atributo : classeObjeto.getDeclaredFields()) {
			atributo.setAccessible(true);
			for (Annotation anotacao : atributo.getAnnotations()) {
				if (anotacao.annotationType() == NotNull.class) {
					String texto = (String) atributo.get(objeto);
					NotNull anotacaoNN = (NotNull) anotacao;
					if (texto == null) {
						throw new Exception(anotacaoNN.tipo() + " nao pode ser nulo!");
					}
				} else if (anotacao.annotationType() == NotMenor.class) {
					int idade = atributo.getInt(objeto);
					NotMenor idadeDefault = (NotMenor) anotacao;
					if (idade < idadeDefault.idade()) {
						throw new Exception("Proibido menor de idade!");
					}
				}
			}
		}
	}
}
