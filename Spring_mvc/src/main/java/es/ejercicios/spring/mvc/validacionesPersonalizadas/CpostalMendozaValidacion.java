package es.ejercicios.spring.mvc.validacionesPersonalizadas;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpostalMendozaValidacion implements ConstraintValidator<CpostalMendoza, String> {

	private String prefijoCodigoMendoza;
	
	
	 @Override
	    public void initialize(CpostalMendoza elCodigo) {
		  prefijoCodigoMendoza= elCodigo.value();
	    }
	
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		boolean valCodigo;
		
		if(arg0!=null) valCodigo=arg0.startsWith(prefijoCodigoMendoza);
		else return valCodigo=true;
		
		return valCodigo;
	}

}
