package pessoa;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({PARAMETER, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotMenor {
	int idade() default 18;

}
