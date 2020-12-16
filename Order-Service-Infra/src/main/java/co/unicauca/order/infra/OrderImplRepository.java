package co.unicauca.order.infra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.order.domain.IOrderApi;
import co.unicauca.order.domain.IOrderRepository;
import co.unicauca.order.domain.Order;
import co.unicauca.order.rest.exceptions.EnumErrorCodes;
import co.unicauca.order.rest.exceptions.OrderDomainException;
import co.unicauca.order.rest.exceptions.OrderError;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;
/**
 * Clase que implementa los metodos de IOrderRepository
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */

public class OrderImplRepository implements IOrderRepository {
	/**
	 * OrderJpaController
	 */
	//private OrderJpaController orderController;
	
	@Autowired
	private IOrderDao orderDao;
	
	
	public OrderImplRepository() {
		//orderController = new OrderJpaController();
    }

	/**
	 * Servicio para buscar todos los orders
	 * 
	 * @return Listado de orders
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Order> findAll() {
		List<OrderJpa> ordersJpa = (List<OrderJpa>) orderDao.findAll();
        List<Order> orders = new ArrayList<>();

        for (OrderJpa order : ordersJpa) {
            orders.add(JpaMapper.fromOrderJpa(order));
        }

        return orders;
        
        //return (List<OrderJpa>) lunchDao.findAll();
	}

	/**
	 * Busca un order por su Id
	 * 
	 * @param id identificador del order
	 * @return objeto de tipo order
	 * @throws ResourceNotFoundException 
	 */
	@Override // Para que esté sincronizada con la bd
	public Order findById(Long id) throws ResourceNotFoundException {
		OrderJpa foodJpa = orderDao.findById(id).orElse(null);
        if (foodJpa == null){
            return null;
        }
        return JpaMapper.fromOrderJpa(foodJpa);
//		OrderJpa foodJpa = orderController.findById(id);
//        if (foodJpa == null){
//            return null;
//        }
//        return JpaMapper.fromOrderJpa(foodJpa);

	}

	/**
	 * Crea un nuevo order
	 * 
	 * @param order order a crear en la bd
	 * @return order creado
	 */
	@Override
	@Transactional
	public Order create(Order order) throws OrderDomainException {
		OrderJpa orderJpa = JpaMapper.fromFood(order);
        orderDao.save(orderJpa);
        return order;
//        OrderJpa orderJpa = JpaMapper.fromFood(order);
//        orderController.create(orderJpa);
//        return order;
	}

	/**
	 * Modifica o edita un order
	 * 
	 * @param id,     identificador del order a modificar
	 * @param product order con los datos a editar
	 * @return Order modificado
	 */
	@Override
	@Transactional
	public Order update(Long id, Order order) throws OrderDomainException, ResourceNotFoundException {
		
//        OrderJpa orderJpa = JpaMapper.fromFood(order);
//        orderController.edit(orderJpa);
//        return order;
        
        Order order1 = this.findById(id);
		if (order1 == null) {
			throw new ResourceNotFoundException();
		}

		List<OrderError> errors = validateDomain(order);

		if (!errors.isEmpty()) {
			throw new OrderDomainException(errors);
		}
		OrderJpa orderJpa = JpaMapper.fromFood(order);
		
		orderDao.save(orderJpa);
		return order;
	}

	/**
	 * Aplica validaciones o reglas del dominio para un order. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param order order a validad
	 * @return lista de errores de validación
	 */

	private List<OrderError> validateDomain(Order order) {
		List<OrderError> errors = new ArrayList<>();
		
		if (order.getLunchClient() == null) {
			errors.add(new OrderError(EnumErrorCodes.INVALID_TODO_NUMBER, "lunch", "El almuerzo es obligatorio"));
		}
		else {
			if (order.getLunchClient().getEntryId() == null || order.getLunchClient() == null) {
				errors.add(new OrderError(EnumErrorCodes.EMPTY_FIELD, "entry", "El id de la entrada es obligatorio"));
			}
			
			if (order.getLunchClient().getDrinkId() == null || order.getLunchClient() == null) {
				errors.add(new OrderError(EnumErrorCodes.EMPTY_FIELD, "drink", "El id de la bebida es obligatorio"));
			}
			
			if (order.getLunchClient().getProteinId() == null || order.getLunchClient() == null) {
				errors.add(new OrderError(EnumErrorCodes.EMPTY_FIELD, "protein", "El id de la proteina es obligatorio"));
			}
			
			if (order.getLunchClient().getSideDishId() == null || order.getLunchClient() == null) {
				errors.add(new OrderError(EnumErrorCodes.EMPTY_FIELD, "sideDish", "El id del principio es obligatorio"));
			}

			if (order.getLunchClient().getPrice() <= 0) {
				errors.add(new OrderError(EnumErrorCodes.INVALID_NUMBER, "price",
						"El precio del almuerzo es obligatorio y mayor a cero"));
			}
		}
		
		return errors;

	}

	/**
	 * Eliminar order por su id
	 * 
	 * @param id identificador del order a eliminar
	 */
	@Override
	@Transactional
	public void delete(Long id) throws ResourceNotFoundException {
//		OrderJpa orderJpa = orderController.findById(id);
//        orderController.remove(orderJpa);
        
        Order order = this.findById(id);
		if (order == null) {
			throw new ResourceNotFoundException();
		}
		orderDao.deleteById(id);
	}


}
