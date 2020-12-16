package co.unicauca.order.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.order.domain.IOrderApi;
import co.unicauca.order.domain.Order;
//import co.unicauca.order.domain.OrderApiImpl;
import co.unicauca.order.rest.exceptions.OrderDomainException;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;

/**
 * Clase que expone los metodos que se utilizaran para las consultas
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	private IOrderApi orderService;

//	/**
//	 * Inyección de OrderServiceFeign
//	 */
//	@Autowired
//	private OrderServiceFeign osf;
	/**
	 * Listar todos los orders
	 * 
	 * @return listado de productos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String findAll() {
		//return (List<Order>) orderService.findAll();
		System.out.println("************************      sdfsd *********-----------");
		return "als";
	}

	/**
	 * Listar un order por id
	 * 
	 * @param id identificador
	 * @return Order en formato json
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Order findById(@PathVariable Long id) throws ResourceNotFoundException {

		Order lunch = orderService.findById(id);
		return lunch;
	}

	/**
	 * Crear un order
	 * 
	 * @param order order
	 * @return order creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Order create(@RequestBody Order order) throws OrderDomainException {
//		int n = 0;
//		while(true) {
//			if(n==0)
//				continue;
//			return orderService.create(order);
//		}
		return orderService.create(order);
	}

	/**
	 * Editar un order
	 * 
	 * @param product Order a editar
	 * @param id      identificador del order
	 * @return order editado
	 * @throws ResourceNotFoundException recurso no encontrado
	 * @throws Exception                 Id no encontrado
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Order update(@RequestBody Order order, @PathVariable Long id)
			throws OrderDomainException, ResourceNotFoundException {
		return orderService.update(id, order);
	}

	/**
	 * Eliminar order
	 * 
	 * @param id id del order
	 * @throws ResourceNotFoundException id no encontrado
	 */

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws ResourceNotFoundException {
		orderService.deleteById(id);
	}
	
}

