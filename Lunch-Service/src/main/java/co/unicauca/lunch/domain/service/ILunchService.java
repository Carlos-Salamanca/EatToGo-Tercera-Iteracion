package co.unicauca.lunch.domain.service;

import java.util.List;

import co.unicauca.lunch.domain.DayEnum;
import co.unicauca.lunch.domain.LunchTypeEnum;
import co.unicauca.lunch.domain.decorator.CapitalLunch;
import co.unicauca.lunch.domain.entity.Lunch;
import co.unicauca.lunch.presentation.rest.exceptions.LunchDomainException;
import co.unicauca.lunch.presentation.rest.exceptions.ResourceNotFoundException;
/**
 * Interfaz que define los metodos del Crud de lunch
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public interface ILunchService {
	public List<Lunch> findAll();

	public Lunch findById(Long id) throws ResourceNotFoundException;

	public Lunch create(CapitalLunch dish) throws LunchDomainException;

	public Lunch update(Long id, Lunch dish) throws LunchDomainException, ResourceNotFoundException;

	public void deleteById(Long id) throws ResourceNotFoundException;
	
	public List<Lunch> findLunchByRestaurantIdAndDayAndTypeParams(Long idRestaurant, DayEnum day, LunchTypeEnum type);
}
