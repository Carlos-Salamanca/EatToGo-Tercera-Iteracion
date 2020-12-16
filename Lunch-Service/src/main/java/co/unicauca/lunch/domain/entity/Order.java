package co.unicauca.lunch.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Entidad que representa un pedido
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */

@Entity
@Table(name = "orders")
public class Order {
	/**
	 * Identificacion del pedido
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinTable(
	        name = "rel_orders_lunches",
	        joinColumns = @JoinColumn(name = "FK_ORDER", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_LUNCH", nullable = false)
	)
	/**
	 * Lista de almuerzos que componen el pedido
	 */
	@ManyToMany(cascade = CascadeType.ALL)
    @MapsId("tagId")
	private List<Lunch> lunch;
	/**
	 * Nombre del cliente
	 */
	private String clientName;
	/**
	 * Cantidad del pedido
	 */
	private Integer amount;

	/**
	 * Constructor parametrizado
	 * 
	 * @param lunch
	 * @param cantidad
	 */
	public Order(Lunch lunch, Integer cantidad) {
//		this.lunch.add(lunch);
//		this.lunch = lunch;
		
		this.amount = cantidad;
	}

	//Getters and Setters
//	public Lunch getLunch() {
//		return lunch;
//	}
//
//	public void setLunch(Lunch lunch) {
//		this.lunch = lunch;
//	}

	public Integer getCantidad() {
		return amount;
	}

	public void setCantidad(Integer cantidad) {
		this.amount = cantidad;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	

}