package co.unicauca.lunch.domain.decorator;

import co.unicauca.infra.Utilities;
import co.unicauca.lunch.domain.DayEnum;
import co.unicauca.lunch.domain.LunchTypeEnum;
import co.unicauca.lunch.domain.entity.Lunch;

public class CapitalLunch extends Lunch{
	
	private Lunch lunch;

	public CapitalLunch(Long id, Long restaurantId, String name, LunchTypeEnum type, DayEnum day, String image) {
		super();
		String capitalizeName = Utilities.capitalize(name);
		lunch = new Lunch(id, restaurantId, capitalizeName, type, day, image);		
	}
	
	public Long getId() {
		return lunch.getId();
	}

	public void setId(Long id) {
		lunch.setId(id);
	}

	public String getName() {
		return lunch.getName();
	}

	public void setName(String name) {
		lunch.setName(name);
	}

	public LunchTypeEnum getType() {
		return lunch.getType();
	}

	public void setType(LunchTypeEnum type) {
		lunch.setType(type);
	}

	public DayEnum getDay() {
		return lunch.getDay();
	}

	public void setDay(DayEnum day) {
		lunch.setDay(day);
	}

	public String getImage() {
		return lunch.getImage();
	}

	public void setImage(String image) {
		lunch.setImage(image);
	}

	public Long getRestaurantId() {
		return lunch.getRestaurantId();
	}

	public void setRestaurantId(Long restaurantId) {
		lunch.setRestaurantId(restaurantId);
	}

	public Lunch getLunch() {
		return lunch;
	}

	public void setLunch(Lunch lunch) {
		this.lunch = lunch;
	}
	
	
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}	
}
