package co.unicauca.order.infra;

import org.springframework.data.repository.CrudRepository;

import co.unicauca.order.domain.Order;
/**
 * Interfaz que extiende de CrudRepository y define algunos metodos de consulta
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public interface IOrderDao extends CrudRepository<OrderJpa, Long>{

	
}
