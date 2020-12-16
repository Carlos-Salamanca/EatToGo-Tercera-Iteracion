import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


import co.unicauca.eattogo.access.LunchConsumer;
import co.unicauca.eattogo.domain.entity.DayEnum;
import co.unicauca.eattogo.domain.entity.LunchPart;
import co.unicauca.eattogo.domain.entity.LunchPartTypeEnum;

class EatToGoApplicationTest {

	/**
	 * Permite testear la creación de un objeto de tipo Lunch desde la app "cliente" EatToGo haciendo uso o consumiendo los servicios de Lunch-Service.
	 * @throws Exception
	 */
	@Test
	void test(){
		LunchConsumer lunchConsummer = new LunchConsumer();

		LunchPart lunch = new LunchPart(5l, 4l, "sasa", LunchPartTypeEnum.ENTRADA, DayEnum.MIERCOLES,
				"src\\main\\resources\\templates\\ImegenesPlatos\\Jugo de mango.jpg");

		Long idGenerated = lunchConsummer.create(lunch);


		List<LunchPart> lunchPart = lunchConsummer.findByRestDayType(40l, DayEnum.MIERCOLES, LunchPartTypeEnum.ENTRADA);
		
		org.assertj.core.api.Assertions.assertThat(lunchPart.get(0)).isEqualTo(idGenerated);
	}
}
