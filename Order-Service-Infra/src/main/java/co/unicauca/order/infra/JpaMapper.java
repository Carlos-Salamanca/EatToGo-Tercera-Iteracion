package co.unicauca.order.infra;

import co.unicauca.order.domain.LunchClient;
import co.unicauca.order.domain.Order;

/**
 * 
 * Hace el mapeo de clases del dominio (Order, LunchClient), a un equivalente en JPA (OrderJpa, LunchClientJpa) y viceversa.
 *
 */
public class JpaMapper {

    /**
     * Convierte de FoodJpa a Food
     *
     * @param orderJpa objeto FoodJpa
     * @return objeto Todo
     */
    public static Order fromOrderJpa(OrderJpa orderJpa) {
    	LunchClient lc = fromLunchClientJpa(orderJpa.getLunchClient());
    	
        return new Order(
                orderJpa.getId(),
                lc
        );

    }

    /**
     * Convierte de Order a OrderJpa
     *
     * @param order pedido
     * @return objeto tipo OrderJpa
     */
    public static OrderJpa fromOrder(Order order) {
    	OrderJpa orderJpa = new OrderJpa();
        mapOrderJpaFields(order, orderJpa);
        return orderJpa;
    }
    
    /**
     * Convierte de LunchClientJpa a LunchClient
     *
     * @param lunchClientJpa objeto FoodJpa
     * @return objeto Todo
     */
    public static LunchClient fromLunchClientJpa(LunchClientJpa lunchClientJpa) {
        return new LunchClient(
                lunchClientJpa.getProteinId(),
                lunchClientJpa.getEntryId(),
                lunchClientJpa.getDrinkId(),
                lunchClientJpa.getSideDishId(),
                lunchClientJpa.getPrice()
        );
    }
    
    /**
     * Convierte de Order a OrderJpa
     *
     * @param order pedido
     * @return objeto tipo OrderJpa
     */
    public static OrderJpa fromFood(Order order) {
    	OrderJpa orderJpa = new OrderJpa();
    	mapOrderJpaFields(order, orderJpa);
        return orderJpa;
    }

    /**
     * Mapea (los campos) un Order a un objeto OrderJpa
     *
     * @param order pedido
     * @param orderJpa pedido JPA
     */
    public static void mapOrderJpaFields(Order order, OrderJpa orderJpa) {
        orderJpa.setId(order.getId());
        LunchClientJpa lcJpa = new LunchClientJpa();
        mapLunchClientJpaFields(order.getLunchClient(), lcJpa);
        orderJpa.setLunchClient(lcJpa);
    }
    
    /**
     * Mapea (los campos) un lunchClient a un objeto lunchClientJpa
     *
     * @param lunchClient almuerzo
     * @param lunchClientJpa almuerzo JPA
     */
    public static void mapLunchClientJpaFields(LunchClient lunchClient, LunchClientJpa lunchClientJpa) {
    	lunchClientJpa.setProteinId(lunchClient.getProteinId());
    	lunchClientJpa.setDrinkId(lunchClient.getDrinkId());
    	lunchClientJpa.setSideDishId(lunchClient.getSideDishId());
    	lunchClientJpa.setEntryId(lunchClient.getEntryId());
    	lunchClientJpa.setPrice(lunchClient.getPrice());
    }
}
