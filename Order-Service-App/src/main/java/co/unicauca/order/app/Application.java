package co.unicauca.order.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import co.unicauca.order.domain.*;
import co.unicauca.order.infra.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//IOrderRepository repo = FactoryOrderRepository.getInstance().getRepository();
		//CualquierController.orderService = new OrderApiImpl(repo);
	}

}
