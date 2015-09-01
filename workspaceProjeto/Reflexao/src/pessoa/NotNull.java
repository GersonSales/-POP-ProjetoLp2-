package pessoa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Target({PARAMETER, FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
	String tipo() default "";

}
