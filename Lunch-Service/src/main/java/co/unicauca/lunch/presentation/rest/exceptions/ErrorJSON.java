package co.unicauca.lunch.presentation.rest.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.unicauca.lunch.domain.service.EnumErrorCodes;

/**
 * Maneja los errores en formato Json. Es utilizada por ErrorsPayload
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorJSON {

	public final EnumErrorCodes code;
	public final String field;
	public final String message;

	public ErrorJSON(EnumErrorCodes code, String field, String message) {
		this.code = code;
		this.field = field;
		this.message = message;
	}

}
