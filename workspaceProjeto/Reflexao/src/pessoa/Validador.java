package pessoa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validador {
	
	public static void validaObjeto(Object objeto) throws Exception {
		@SuppressWarnings("rawtypes")
		Class classeObjeto = objeto.getClass();
		
		for (Field atributo: classeObjeto.getDeclaredFields()) {
			atributo.setAccessible(true);
			for (Annotation anotacao: atributo.getAnnotations()) {
				if (anotacao.annotationType() == NotNull.class) {
					String texto = (String) atributo.get(objeto);
					if (texto == null) {
						throw new Exception("Nome nao pode ser nulo!");
					}
				}else if (anotacao.annotationType() == NotMenor.class) {
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
