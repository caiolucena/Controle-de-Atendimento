package com.newsoft.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import com.newsoft.validation.validator.AtributoConfirmacaoValidator;

/**
 * Essa é a interface responsável por conter os métodos referentes a Validação do Atributo de Confirmação
 * @author Newsoft
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AtributoConfirmacaoValidator.class})
public @interface AtributoConfirmacao {

	@OverridesAttribute(constraint = Pattern.class,name = "message")
	String message() default "Atributos não conferem";
	
	Class<?>[] groups() default {};
	Class<? extends Payload> [] payload() default{};
	
	
	String atributo();
	String atributoConfirmacao();
}
