package co.unicauca.lunch.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.lunch.access.dao.ILunchDao;
import co.unicauca.lunch.domain.DayEnum;
import co.unicauca.lunch.domain.LunchTypeEnum;
import co.unicauca.lunch.domain.decorator.CapitalLunch;
import co.unicauca.lunch.domain.entity.Lunch;
import co.unicauca.lunch.presentation.rest.exceptions.LunchDomainException;
import co.unicauca.lunch.presentation.rest.exceptions.LunchError;
import co.unicauca.lunch.presentation.rest.exceptions.ResourceNotFoundException;
/**
 * Clase que implementa los metodos de ILunchService
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
@Service
public class LunchImplService implements ILunchService {
	/**
	 * Inyección de lunchDao
	 */
	@Autowired
	private ILunchDao lunchDao;

	/**
	 * Servicio para buscar todos los lunches
	 * 
	 * @return Listado de lunches
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Lunch> findAll() {
		return (List<Lunch>) lunchDao.findAll();
	}

	/**
	 * Busca un lunch por su Id
	 * 
	 * @param id identificador del lunch
	 * @return objeto de tipo lunch
	 */
	@Override // Para que esté sincronizada con la bd
	public Lunch findById(Long id) throws ResourceNotFoundException {
		Lunch prod = lunchDao.findById(id).orElse(null);
		if (prod == null) {
			throw new ResourceNotFoundException();

		}
		return prod;

	}

	/**
	 * Crea un nuevo lunch
	 * 
	 * @param lunch lunch a crear en la bd
	 * @return Lunch creado
	 */
	@Override
	@Transactional
	public Lunch create(CapitalLunch capitalLunch) throws LunchDomainException {
		Lunch lunch = capitalLunch.getLunch();
		List<LunchError> errors = validateDomain(lunch);

		if (!errors.isEmpty()) {
			throw new LunchDomainException(errors);
		}

		return lunchDao.save(lunch);
	}

	/**
	 * Modifica o edita un lunch
	 * 
	 * @param id,     identificador del lunch a modificar
	 * @param product lunch con los datos a editar
	 * @return Lunch modificado
	 */
	@Override
	@Transactional
	public Lunch update(Long id, Lunch lunch) throws LunchDomainException, ResourceNotFoundException {
		Lunch lunch1 = this.findById(id);
		if (lunch1 == null) {
			throw new ResourceNotFoundException();
		}

		List<LunchError> errors = validateDomain(lunch1);

		if (!errors.isEmpty()) {
			throw new LunchDomainException(errors);
		}

		lunch1.setName(lunch1.getName());
		//lunch1.setPrice(lunch1.getPrice());

		return lunchDao.save(lunch1);
	}

	/**
	 * Aplica validaciones o reglas del dominio para un lunch. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param lunch lunch a validad
	 * @return lista de errores de validación
	 */

	private List<LunchError> validateDomain(Lunch lunch) {
		List<LunchError> errors = new ArrayList<>();

		if (lunch.getName() == null || lunch.getName().isEmpty()) {
			errors.add(new LunchError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
		}
		return errors;

		//if (lunch.getPrice() <= 0) {
		//	errors.add(new LunchError(EnumErrorCodes.INVALID_NUMBER, "price",
		//			"El precio del producto es obligatorio y mayor a cero"));
		//}
		//return errors;

	}

	/**
	 * Eliminar lunch por su id
	 * 
	 * @param id identificador del lunch a eliminar
	 */
	@Override
	@Transactional
	public void deleteById(Long id) throws ResourceNotFoundException {
		Lunch lunch = this.findById(id);
		if (lunch == null) {
			throw new ResourceNotFoundException();
		}
		lunchDao.deleteById(id);
	}

	@Override
	public List<Lunch> findLunchByRestaurantIdAndDayAndTypeParams(Long idRestaurant, DayEnum day, LunchTypeEnum type) {
		List<Lunch> lunches = lunchDao.findLunchByRestaurantIdAndDayAndTypeParams(idRestaurant, day, type);
		return lunches;
	}
}
