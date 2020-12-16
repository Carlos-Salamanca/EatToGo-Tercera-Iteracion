package co.unicauca.order.infra;

import javax.persistence.Embeddable;

@Embeddable
public class LunchClientJpa {
	
	/**
	 * Identificacion de la proteina
	 */
	private Long proteinId;
	/**
	 * Identificacionde la entrada
	 */
	private Long entryId;
	/**
	 * Identificacion dela bebida
	 */
	private Long drinkId;
	/**
	 * Identificacion del principio
	 */
	private Long sideDishId;
	/**
	 * Precio del almuerzo
	 */
	private int price;
	
	/**
	 * Constructor por defecto
	 */
	public LunchClientJpa() {
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param proteinId
	 * @param entryId
	 * @param drinkId
	 * @param sideDishId
	 * @param price
	 */
	public LunchClientJpa(Long proteinId, Long entryId, Long drinkId, Long sideDishId, int price) {
		this.proteinId = proteinId;
		this.entryId = entryId;
		this.drinkId = drinkId;
		this.sideDishId = sideDishId;
		this.price = price;
	}

	//Getters and Setters
	public Long getProteinId() {
		return proteinId;
	}

	public void setProteinId(Long proteinId) {
		this.proteinId = proteinId;
	}

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public Long getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(Long drinkId) {
		this.drinkId = drinkId;
	}

	public Long getSideDishId() {
		return sideDishId;
	}

	public void setSideDishId(Long sideDishId) {
		this.sideDishId = sideDishId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "LunchClient [proteinId=" + proteinId + ", entryId=" + entryId + ", drinkId=" + drinkId + ", sideDishId="
				+ sideDishId + ", price=" + price + "]";
	}
}
