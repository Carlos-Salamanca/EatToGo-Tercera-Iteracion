package co.unicauca.eattogo.domain.service;

import java.util.List;

import co.unicauca.eattogo.access.LunchConsumer;
import co.unicauca.eattogo.domain.entity.DayEnum;
import co.unicauca.eattogo.domain.entity.LunchPart;
import co.unicauca.eattogo.domain.entity.LunchPartTypeEnum;

/**
 * Clase que establece los metodos que se usaran del microservicio lunch-Service
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class ConsumerLunchService {
	/**
	 * 
	 */
	private LunchConsumer service;
	/**
	 * Constructor parametrizado
	 * @param service
	 */
	public ConsumerLunchService(LunchConsumer service) {
		super();
		this.service = service;
	}
	
	/**
	 * Metodo de creacion de una parte un almuerzo
	 * 
	 * @param lunch, objeto de tipo LunchPart
	 * @return Boolean, con el resultado de la operacion
	 */
	public Long create(LunchPart lunch){
		return service.create(lunch);

	}
	
	/**
	 * Metodo de eliminación de una parte un almuerzo
	 * 
	 * @param lunch, objeto de tipo LunchPart
	 * @return Boolean, con el resultado de la operacion
	 */
	public boolean delete(Long id){
		
		return service.delete(id);

	}

	/**
	 * Metodo de busca las partes de un almuerzo por id, dia y tipo
	 * 
	 * @param id
	 * @param day
	 * @param type
	 * @return retorna una lista con las partes de un almuerzo
	 * @throws Exception
	 */
	public List<LunchPart> ListByRestDayType(Long id, DayEnum day, LunchPartTypeEnum type) throws Exception{
		return service.findByRestDayType(id, day, type);
		
	}
}
