package co.unicauca.lunch.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import co.unicauca.lunch.domain.DayEnum;
import co.unicauca.lunch.domain.LunchTypeEnum;
/**
 * Entidad que representa una parte del almuerzo
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
@Entity
@Table(name = "tbl_lunches")
public class Lunch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificacion de la parte
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Identificacion del restaurante
	 */
	@Column(name = "restaurant_id")
	private Long restaurantId;
	/**
	 * Nombre de la parte
	 */
	private String name;
	/**
	 * Tipo de parte
	 */
	private LunchTypeEnum type;
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
	public Lunch() {
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param id
	 * @param restaurantId
	 * @param name
	 * @param type
	 * @param day
	 */
	public Lunch(Long id, Long restaurantId, String name, LunchTypeEnum type, DayEnum day, String image) {
		this.id = id;
		this.restaurantId = restaurantId;
		this.name = name;
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

	public LunchTypeEnum getType() {
		return type;
	}

	public void setType(LunchTypeEnum type) {
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
