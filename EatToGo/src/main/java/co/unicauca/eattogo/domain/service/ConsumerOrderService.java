package co.unicauca.eattogo.domain.service;

import co.unicauca.eattogo.access.OrderConsumer;
import co.unicauca.eattogo.domain.entity.Order;
/**
 * Clase que establece los metodos que se usaran del microservicio Order-Service
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class ConsumerOrderService {
	/**
	 * 
	 */
	private OrderConsumer service;
	
	/**
	 * Constructor parametrizado
	 * 
	 * @param service
	 */
	public ConsumerOrderService(OrderConsumer service) {
		super();
		this.service = service;
	}
	
	/**
	 * Metodo para crear una orden
	 * 
	 * @param order objeto de tipo Order
	 * @return Boolen, con el resultado de la operacion
	 * @throws Exception
	 */
	public boolean create(Order order) throws Exception {
		return service.create(order);

	}

}
