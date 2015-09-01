package pessoa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Validador {

	public static void validaObjeto(Object objeto) throws Exception {
		Class<?> classeObjeto = objeto.getClass();
		for (Method metodo : classeObjeto.getMethods()) {
			Annotation[][] anotacaoParam = metodo.getParameterAnnotations();
			Class<?>[] paramsType = metodo.getParameterTypes();
			int i = 0;
			for (Annotation[] anotacoes : anotacaoParam) {
				Class<?> tipoParam = paramsType[i++];
				for (Annotation anotacao : anotacoes) {
					if (anotacao instanceof NotNull) {
						if (tipoParam == String.class) {
							for (Field campo : tipoParam.getFields()) {

								System.out.println(campo);

							}
						}
					}
				}

			}
		}

	}
}