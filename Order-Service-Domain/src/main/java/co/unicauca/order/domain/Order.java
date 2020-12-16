package co.unicauca.order.domain;

/**
 * Entidad que representa un pedido
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class Order{

	
	/**
	 * Identificacion del pedido
	 */
	private Long id;
	/**
	 * Almuerzo que se va a almacenar en el pedido actual
	 */
	private LunchClient lunchClient;

	/**
	 * Constructor por defecto
	 */
	public Order() {
		this.id = 2L;
		this.lunchClient = new LunchClient();
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param id id
	 * @param lunch almuerzo
	 */
	public Order(Long id, LunchClient lunch) {
		this.id = id;
		this.lunchClient = lunch;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LunchClient getLunchClient() {
		return lunchClient;
	}

	public void setLunchClient(LunchClient lunchClient) {
		this.lunchClient = lunchClient;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", lunch={proteinId:" + lunchClient.getProteinId() + ", entryId:" + lunchClient.getEntryId() + 
				", drinkId:" + lunchClient.getDrinkId() + ", sidedishId:" + lunchClient.getSideDishId() + ", price:" + lunchClient.getPrice() +"]";
	}
	

}
