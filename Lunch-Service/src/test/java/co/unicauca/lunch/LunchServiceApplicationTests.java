package co.unicauca.lunch;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.unicauca.lunch.access.dao.ILunchDao;
import co.unicauca.lunch.domain.DayEnum;
import co.unicauca.lunch.domain.LunchTypeEnum;
import co.unicauca.lunch.domain.entity.Lunch;
/**
 * Test unitario para el crud de Lunch-Service
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
@SpringBootTest
class LunchServiceApplicationTests {
	
	@Autowired
    private ILunchDao lunchDao;

	@Test
	public void contextLoads() {
		
		Lunch lunch = new Lunch(10l, 40l, "Pollo Asado", LunchTypeEnum.PROTEINA, DayEnum.DOMINGO, "src\\main\\resources\\templates\\ImegenesPlatos\\Sancocho.jpg");

		lunchDao.save(lunch);

        List<Lunch> lunches = (List<Lunch>) lunchDao.findAll();

        org.assertj.core.api.Assertions.assertThat(lunches.size()).isEqualTo(5);
        
        lunches = lunchDao.findLunchByRestaurantIdAndDayAndTypeParams(lunch.getRestaurantId(),
        		lunch.getDay(), lunch.getType());
        
        org.assertj.core.api.Assertions.assertThat(lunches.size()).isEqualTo(1);
        		
	}
}
