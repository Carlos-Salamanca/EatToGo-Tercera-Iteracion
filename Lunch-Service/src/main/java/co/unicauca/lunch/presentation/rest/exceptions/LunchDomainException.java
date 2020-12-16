package co.unicauca.lunch.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un producto
 * 
 * @author wChristian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class LunchDomainException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Listado de errores
	 */
	public final List<LunchError> errors;

	public LunchDomainException(List<LunchError> errors) {
		this.errors = errors;
	}
}
