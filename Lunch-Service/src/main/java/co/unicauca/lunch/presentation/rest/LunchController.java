package co.unicauca.lunch.presentation.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.lunch.domain.DayEnum;
import co.unicauca.lunch.domain.LunchTypeEnum;
import co.unicauca.lunch.domain.decorator.CapitalLunch;
import co.unicauca.lunch.domain.entity.Lunch;
import co.unicauca.lunch.domain.service.ILunchService;
import co.unicauca.lunch.presentation.rest.exceptions.LunchDomainException;
import co.unicauca.lunch.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Clase que expone los metodos que se utilizaran para las consultas
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
@RestController
@RequestMapping("lunches")
public class LunchController {
	/**
	 * Inyección de ILunchService
	 */
	@Autowired
	private ILunchService lunchService;

	/**
	 * Listar todos lunch
	 * 
	 * @return listado de productos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Lunch> findAll() {
		return (List<Lunch>) lunchService.findAll();
	}

	/**
	 * Listar un lunch por id
	 * 
	 * @param id identificador
	 * @return Lunch en formato json
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Lunch findById(@PathVariable Long id) throws ResourceNotFoundException {

		Lunch lunch = lunchService.findById(id);
		return lunch;
	}

	/**
	 * Crear un lunch
	 * 
	 * @param lunch lunch
	 * @return lunch creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Lunch create(@RequestBody Lunch lunch) throws LunchDomainException {
		CapitalLunch capitalLunch = new CapitalLunch(lunch.getId(), lunch.getRestaurantId(), lunch.getName(), lunch.getType(), lunch.getDay(), lunch.getImage());
		return lunchService.create(capitalLunch);
	}

	/**
	 * Editar un lunch
	 * 
	 * @param lunch Lunch a editar
	 * @param id      identificador del lunch
	 * @return lunch editado
	 * @throws ResourceNotFoundException recurso no encontrado
	 * @throws Exception                 Id no encontrado
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Lunch update(@RequestBody Lunch lunch, @PathVariable Long id)
			throws LunchDomainException, ResourceNotFoundException {
		return lunchService.update(id, lunch);
	}

	/**
	 * Eliminar lunch
	 * 
	 * @param id id del lunch
	 * @throws ResourceNotFoundException id no encontrado
	 */

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws ResourceNotFoundException {
		lunchService.deleteById(id);
	}
	/**
	 * Buscar todos los lunch por id del restaurante, dia y tipo
	 * 
	 * @param restaurantId 
	 * @param day
	 * @param type
	 * @return
	 */
	@GetMapping("/findByRest/{restaurantId}/{day}/{type}")
	@ResponseBody
	public List<Lunch> findLunchByRestaurantIdAndDayAndTypeParams(@PathVariable(value = "restaurantId") Long restaurantId,
			@PathVariable(value = "day") String day, @PathVariable (value = "type") String type) {
		//public List<Lunch> findLunchByRestaurantIdAndDayAndTypeParams(@RequestParam(required=true, defaultValue="0L") Long restaurantId, @RequestParam(required=true, defaultValue="null") String day, @RequestParam(required=true, defaultValue="null") String type) {
		
		List<Lunch> list = lunchService.findLunchByRestaurantIdAndDayAndTypeParams(restaurantId, DayEnum.valueOf(day), LunchTypeEnum.valueOf(type));
		
		return list;
	}
}
