package co.unicauca.order.domain;

import java.util.List;


import co.unicauca.order.rest.exceptions.OrderDomainException;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;
/**
 * Interfaz que define los metodos del Crud de Order.
 * Va a ser invocada desde la presentación.
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public interface IOrderApi {
	public List<Order> findAll();

	public Order findById(Long id) throws ResourceNotFoundException;
	
	public Order create(Order order) throws OrderDomainException;
	
	public Order update(Long id, Order order) throws OrderDomainException, ResourceNotFoundException;
	
	public void deleteById(Long id) throws ResourceNotFoundException;
	
}
