package br.com.hamburgueria.validacoes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.hamburgueria.exception.EmailInvalidoException;

public class ValidaEmail {
	
	public void validarEmail(String email) throws EmailInvalidoException{
		if (!email.equals("")) {
			 String expEmail = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			 Pattern pattern = Pattern.compile(expEmail, Pattern.CASE_INSENSITIVE);
	         Matcher matcher = pattern.matcher(email);
	         if (!matcher.matches()) {
	        	 throw new EmailInvalidoException();
	         }
		}
	}
}
