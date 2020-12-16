package co.unicauca.lunch.presentation.rest.exceptions;

import co.unicauca.lunch.domain.service.EnumErrorCodes;

/**
 * Error de un producto
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class LunchError {

	/**
	 * Codigo del error
	 */
	public final EnumErrorCodes code;
	/**
	 * Campo del error
	 */
	public final String field;
	/**
	 * Descripción del error
	 */
	public final String description;

	public LunchError(EnumErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
}
