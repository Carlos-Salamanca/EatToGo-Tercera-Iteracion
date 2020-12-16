package co.unicauca.lunch.presentation.rest.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilizada por GlobalDefaultExceptionHandler para manerjar los errores.
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class ErrorsPayload {
	
	public final List<ErrorJSON> errors;

	public ErrorsPayload(List<LunchError> applicationErrors) {
		this.errors = new ArrayList<>();
		applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
	}

	private ErrorJSON fromApplicationError(LunchError error) {
		return new ErrorJSON(error.code, error.field, error.description);
	}

}