package co.unicauca.order.infra;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "OrderJpa")
@Table(name = "tbl_orders")
public class OrderJpa implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificacion del pedido
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Almuerzo que se va a almacenar en el pedido actual
	 */
	@Embedded private LunchClientJpa lunchClient;
	
	public OrderJpa() {
    }
	
	
    
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LunchClientJpa getLunchClient() {
		return lunchClient;
	}



	public void setLunchClient(LunchClientJpa lunchClient) {
		this.lunchClient = lunchClient;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderJpa)) {
            return false;
        }
        OrderJpa other = (OrderJpa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unicauca.commandorder.domain.Order[ id=" + id + " ]";
    }

    
}
