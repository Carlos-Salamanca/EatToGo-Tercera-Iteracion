package co.unicauca.eattogo.domain.entity;

import java.io.Serializable;

import co.unicauca.eattogo.infra.Utilities;
/**
 * Entidad que representa una parte del almuerzo
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class LunchPart implements Serializable {

	/**
	 * Serealizacion
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identificacion de la parte
	 */
	private Long id;
	/**
	 * Identificacion del restaurante
	 */
	private Long restaurantId;
	/**
	 * Nombre de la parte
	 */
	private String name;
	/**
	 * Tipo de parte
	 */
	private LunchPartTypeEnum type;
	/**
	 * Dia en que se ofrece
	 */
	private DayEnum day;
	/**
	 * Direccion de la imagen
	 */
	private String image;

	/**
	 * Constructor por defecto
	 */
	public LunchPart() {
	}
	
	/**
	 * Constructor parametrizado
	 * 
	 * @param id
	 * @param restaurantId
	 * @param name
	 * @param type
	 * @param day
	 * @param image
	 */
	public LunchPart(Long id, Long restaurantId, String name, LunchPartTypeEnum type, DayEnum day, String image) {
		this.id = id;
		this.restaurantId = restaurantId;
		String capitalizeFoodName = Utilities.capitalize(name);
		this.name = capitalizeFoodName;
//		this.name = name;
		this.type = type;
		this.day = day;
		this.image = image;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LunchPartTypeEnum getType() {
		return type;
	}

	public void setType(LunchPartTypeEnum type) {
		this.type = type;
	}

	public DayEnum getDay() {
		return day;
	}

	public void setDay(DayEnum day) {
		this.day = day;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
