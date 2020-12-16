package co.unicauca.order.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.unicauca.order.domain.IOrderApi;
import co.unicauca.order.domain.IOrderRepository;
import co.unicauca.order.domain.Order;
import co.unicauca.order.rest.exceptions.EnumErrorCodes;
import co.unicauca.order.rest.exceptions.OrderDomainException;
import co.unicauca.order.rest.exceptions.OrderError;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;
/**
 * Clase que implementa los metodos de IOrderApi
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
@Service
public class OrderApiImpl implements IOrderApi {
	/**
	 * Inyección de order Dao
	 */
	@Autowired
	private IOrderRepository repo;

	/**
	 * Constructor parametrizado: Inyección de dependencias
	 * @param repo
	 */
//	public OrderApiImpl(IOrderRepository repo) {
//		super();
//		this.repo = repo;
//	}

	/**
	 * Servicio para buscar todos los orders
	 * 
	 * @return Listado de orders
	 */
	public List<Order> findAll() {
		return (List<Order>) repo.findAll();
	}

	/**
	 * Busca un order por su Id
	 * 
	 * @param id identificador del order
	 * @return objeto de tipo order
	 */
	@Override // Para que esté sincronizada con la bd
	public Order findById(Long id) throws ResourceNotFoundException {
		Order prod = repo.findById(id);//.orElse(null);
		if (prod == null) {
			throw new ResourceNotFoundException();

		}
		return prod;

	}

	/**
	 * Crea un nuevo order
	 * 
	 * @param order order a crear en la bd
	 * @return order creado
	 */
	@Override
	public Order create(Order order) throws OrderDomainException {
		List<OrderError> errors = validateDomain(order);

		if (!errors.isEmpty()) {
			throw new OrderDomainException(errors);
		}

		return repo.create(order);
	}

	/**
	 * Modifica o edita un order
	 * 
	 * @param id,     identificador del order a modificar
	 * @param product order con los datos a editar
	 * @return Order modificado
	 */
	@Override
	public Order update(Long id, Order order) throws OrderDomainException, ResourceNotFoundException {
		Order order1 = this.findById(id);
		if (order1 == null) {
			throw new ResourceNotFoundException();
		}

		List<OrderError> errors = validateDomain(order1);

		if (!errors.isEmpty()) {
			throw new OrderDomainException(errors);
		}

		return repo.create(order1);
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
	public void deleteById(Long id) throws ResourceNotFoundException {
		Order lunch = this.findById(id);
		if (lunch == null) {
			throw new ResourceNotFoundException();
		}
		repo.delete(id);
	}


}
