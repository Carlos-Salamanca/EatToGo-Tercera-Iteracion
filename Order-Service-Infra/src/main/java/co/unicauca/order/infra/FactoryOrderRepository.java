package co.unicauca.order.infra;

import co.unicauca.order.domain.IOrderRepository;
import co.unicauca.order.infra.utilities.Utilities;

public class FactoryOrderRepository {
	
	private static FactoryOrderRepository instance;

	private FactoryOrderRepository() {
	}

	/**
	 * Clase singleton
	 *
	 * @return
	 */
	public static FactoryOrderRepository getInstance() {

		if (instance == null) {
			instance = new FactoryOrderRepository();
		}
		return instance;

	}

	/**
	 * Método que crea una instancia concreta de la jerarquia IProductRepository
	 *
	 * @return una clase hija de la abstracción IProductRepository
	 */
	public IOrderRepository getRepository() {

		IOrderRepository result = null;
		String type = Utilities.loadProperty("repo.type");

		switch (type) {
		case "default":
			result = new OrderImplRepository();
			break;
		}

		return result;

	}
}
