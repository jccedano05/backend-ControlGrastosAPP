package net.jccedano92.cyvconstrucciones.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import net.jccedano92.cyvconstrucciones.model.responses.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler {

	
	@ExceptionHandler( value = EmailExistsException.class )
	
	public ResponseEntity<Object> handleEmailExistException( EmailExistsException ex, WebRequest webRequest) {

		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler( value = Exception.class ) // con esto manejaremos todas las excepciones restantes pues vendran del padre
	public ResponseEntity<Object> handleException(Exception ex, WebRequest webRequest){
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
