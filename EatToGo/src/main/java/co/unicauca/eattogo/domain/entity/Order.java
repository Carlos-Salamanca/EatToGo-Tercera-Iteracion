package co.unicauca.eattogo.domain.entity;

/**
 * Entidad que representa un pedido
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class Order {
	
	/**
	 * Identificacion del pedido
	 */
	private Long id;
	/**
	 * Lista de almuerzos que componen el pedido
	 */
	private LunchClient lunchClient;
	
	/**
	 * Constructor por defecto
	 */
	public Order() {
		this.id = 3L;
		this.lunchClient = new LunchClient();
	}
	
	/**
	 * Constructor parametrizado
	 * @param id
	 */
	public Order(Long id, LunchClient lc) {
		super();
		this.id = id;
		this.lunchClient = lc;
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
