package es.ejercicios.spring.mvc.validacionesPersonalizadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CpostalMendozaValidacion.class)//clase q contendra la logica de la validacion
@Target({ElementType.METHOD , ElementType.FIELD}) // destino de nuestra validacion: a metodos o campos
@Retention(RetentionPolicy.RUNTIME)//indica cuando se va a validar la ejecucion en este case se va a chequar en tiempo de ejecucion (RUNTIME)
public @interface CpostalMendoza {
	
	//definir el codigo postal por defecto
	
	public String value() default "55"; 
	
	//definir el msj de error
	
	public String message() default "El codigo postal debe empezar por 55";
	
	//definir los grupos
	
	Class<?>[] groups() default {};
	
	//definir los payloads
	
	Class<? extends Payload>[] payload() default {};
	
	//documentacion oficial https://www.baeldung.com/spring-mvc-custom-validator

}
