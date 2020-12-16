package co.unicauca.order.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un pedido
 * 
 * @author wpantoja, ahurtado
 *
 */
public class OrderDomainException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Listado de errores
	 */
	public final List<OrderError> errors;

	public OrderDomainException(List<OrderError> errors) {
		this.errors = errors;
	}
}
