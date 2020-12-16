package co.unicauca.lunch.access.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.unicauca.lunch.domain.DayEnum;
import co.unicauca.lunch.domain.LunchTypeEnum;
import co.unicauca.lunch.domain.entity.Lunch;
/**
 * Interfaz que extiende de CrudRepository y define algunos metodos de consulta
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public interface ILunchDao extends CrudRepository<Lunch, Long>{
	/**
	 * Metodo que se debe implementar por las clases que extiendan de ILunchDao
	 * 
	 * @param restaurantId
	 * @param day
	 * @param type
	 * @return una lista de Lunch
	 */
	@Query("SELECT lu FROM Lunch lu WHERE lu.restaurantId = :restaurantId and lu.day = :day and lu.type = :type")
	List<Lunch> findLunchByRestaurantIdAndDayAndTypeParams( @Param("restaurantId") Long restaurantId,  @Param("day") DayEnum day, @Param("type") LunchTypeEnum type);

}
