package co.unicauca.eattogo.access;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import co.unicauca.eattogo.domain.entity.Order;
/**
 * Clase que permite consumir el microservicio Order-Service
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class OrderConsumer {
	/**
	 * URL del microservicio
	 */
	private String URL = "http://localhost:8002/orders";
	/**
	 * Instancia para realizar peticiones HTTP
	 */
	private RestTemplate restTemplate;
	
	/**
	 * Constructor por defecto
	 */
	public OrderConsumer() {
		super();
		this.restTemplate = new RestTemplate();
	}

	/**
	 * Crear una orden
	 * 
	 * @param order, objeto de tipo Order
	 * @return boolean, retorna verdadero cuando se crea correctamente, o de lo
	 *         contrario falso
	 * @throws Exception
	 */
	public boolean create(Order order) throws Exception {
		try {
			ResponseEntity<Order> response = restTemplate.postForEntity(URL, order, Order.class);
		} catch (HttpClientErrorException k1) {
			System.out.println("Http code is not 2XX. The server responded: " + k1.getStatusCode() + " Cause: "
					+ k1.getResponseBodyAsString());
			return false;
		} catch (RestClientException k) {
			System.out.println("The server didn't respond: " + k.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * Realiza la busqueda de una orden
	 * 
	 * @param order, objeto de comparacion
	 * @return boolean, retorna verdadero cuando se si encontro, o de lo
	 *         contrario falso
	 * @throws Exception
	 */
	public boolean find(Order order) throws Exception {
		try {
			ResponseEntity<Order> response = restTemplate.getForEntity(URL, Order.class);
		} catch (HttpClientErrorException k1) {
			System.out.println("Http code is not 2XX. The server responded: " + k1.getStatusCode() + " Cause: "
					+ k1.getResponseBodyAsString());
			return false;
		} catch (RestClientException k) {
			System.out.println("The server didn't respond: " + k.getMessage());
			return false;
		}
		return true;
	}
	
	
	
}
