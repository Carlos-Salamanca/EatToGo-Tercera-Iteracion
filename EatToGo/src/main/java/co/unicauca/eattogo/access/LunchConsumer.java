package co.unicauca.eattogo.access;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import co.unicauca.eattogo.domain.entity.DayEnum;
import co.unicauca.eattogo.domain.entity.LunchPart;
import co.unicauca.eattogo.domain.entity.LunchPartTypeEnum;

/**
 * Clase que permite consumir el microservicio Lunch-Service
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class LunchConsumer {
	/**
	 * URL del microservicio
	 */
	private String URL = "http://localhost:8001/lunches";
	private String urlAuxiliar = "http://localhost:8001/lunches";
	private String URLDelete = "http://localhost:8001/lunches/{id}";
	
	public static ResponseEntity<LunchPart> response;
	/**
	 * Instancia para realizar peticiones HTTP
	 */
	private RestTemplate restTemplate;

	/**
	 * Constructor por defecto
	 */
	public LunchConsumer() {
		super();
		this.restTemplate = new RestTemplate();
	}

	/**
	 * Crear una parte de un almuerzo
	 * 
	 * @param lunch, objeto de tipo LunchPart
	 * @return boolean, retorna verdadero cuando se crea correctamente, o de lo
	 *         contrario falso
	 */
	public Long create(LunchPart lunch){
		Long codError = -1L;
		try {
			response = restTemplate.postForEntity(URL, lunch, LunchPart.class);
		} catch (HttpClientErrorException k1) {
			System.out.println("Http code is not 2XX. The server responded: " + k1.getStatusCode() + " Cause: "
					+ k1.getResponseBodyAsString());
			return codError;
		} catch (RestClientException k) {
			System.out.println("The server didn't respond: " + k.getMessage());
			return codError;
		}
		return response.getBody().getId();
	}
	
	/**
	 * Crear una parte de un almuerzo
	 * 
	 * @param lunch, objeto de tipo LunchPart
	 * @return boolean, retorna verdadero cuando se crea correctamente, o de lo
	 *         contrario falso
	 * @throws Exception
	 */
	public boolean delete(Long id){
		Map <String, String> params = new HashMap <String, String>();
		params.put("id", id+"");
		try {
			//ResponseEntity<LunchPart> response = restTemplate.postForEntity(URL, lunch, LunchPart.class);
			 restTemplate.delete(URLDelete, params);
		} catch (HttpClientErrorException k1) {
			System.out.println("Http code is not 2XX. The server responded: " + k1.getStatusCode() + " Cause: "
					+ k1.getResponseBodyAsString());
			return false;
		} catch (RestClientException k) {
			System.out.println("The server didn't respond: " + k.getMessage());
			return false;
		}
		return true;
	}
	  
      

	/**
	 * Realiza la busqueda de partes del almuerzo por id, dia y tipo
	 * 
	 * @param id,   identificacion del restaurante
	 * @param day,  dia en el que se ofrece la parte
	 * @param type, tipo de parte
	 * @return Retorna una lista de LunchPart
	 * @throws Exception
	 */
	public List<LunchPart> findByRestDayType(Long id, DayEnum day, LunchPartTypeEnum type){
		List<LunchPart> lunches = new ArrayList<>();
		urlAuxiliar = URL + "/findByRest/" + id + "/" + day + "/" + type;
		try {
			ResponseEntity<LunchPart[]> response = restTemplate.getForEntity(urlAuxiliar, LunchPart[].class);
			lunches = Arrays.asList(response.getBody());
		} catch (HttpClientErrorException k1) {
			System.out.println("Http code is not 2XX. The server responded: " + k1.getStatusCode() + " Cause: "
					+ k1.getResponseBodyAsString());
		} catch (RestClientException k) {
			System.out.println("The server didn't respond: " + k.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lunches;
	}

	// Getters and Setters
	public String getUrlAuxiliar() {
		return urlAuxiliar;
	}

	public void setUrlAuxiliar(String urlAuxiliar) {
		this.urlAuxiliar = urlAuxiliar;
	}
}
