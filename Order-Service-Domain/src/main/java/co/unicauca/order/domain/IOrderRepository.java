package co.unicauca.order.domain;

import java.util.List;

import co.unicauca.order.rest.exceptions.OrderDomainException;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;

/**
 * Interfaz que permite que el componente de acceso a datos invoque a la logica del negocio.
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public interface IOrderRepository {

	/**
     * Buscar una Order
     *
     * @param id identificador de la Order
     * @return objeto Order
     */
    public Order findById(Long id) throws ResourceNotFoundException;

    /**
     * Busca todas las Order
     *
     * @return lista de Order
     */
    public List<Order> findAll();

    /**
     * Crea una Order
     *
     * @param Order comida a crear
     * @return true si fue creada, false en caso contrario
     */
    public Order create(Order order) throws OrderDomainException;

    /**
     * Modifica una comida
     *
     * @param Order comida
     * @return true si la modifica con exito, false en caso contrario
     */
    public Order update(Long id, Order order) throws OrderDomainException, ResourceNotFoundException;

    /**
     * Eliminar un Order
     *
     * @param id identificador de la Order a eliminar
     */
    public void delete(Long id) throws ResourceNotFoundException;
}
