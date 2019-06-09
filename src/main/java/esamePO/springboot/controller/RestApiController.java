package esamePO.springboot.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import esamePO.springboot.model.Edicola;
import esamePO.springboot.service.EdicolaService;
import esamePO.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	EdicolaService EdicolaService;


	@RequestMapping(value = "/Edicole/", method = RequestMethod.GET)
	public ResponseEntity<List<Edicola>> listAllEdicolas() {
		List<Edicola> Edicolas = EdicolaService.getEdicole();
		if (Edicolas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Edicola>>(Edicolas, HttpStatus.OK);
	}
	@RequestMapping(value = "/Edicola/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEdicola(@PathVariable("id") int id) {
		logger.info("Fetching Edicola with id {}", id);
		Edicola Edicola = EdicolaService.getEdicolaById(id);
		if (Edicola == null) {
			logger.error("Edicola with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Edicola with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Edicola>(Edicola, HttpStatus.OK);
	}
	@RequestMapping(value = "/Edicola/Codice/{code}", method = RequestMethod.GET)
	public ResponseEntity<?> getEdicolaByCodice(@PathVariable("codice") String codice) {
		logger.info("Fetching Edicola with code {}", codice);
		Edicola Edicola = EdicolaService.getEdicolaByCodice(codice);
		if (Edicola == null) {
			logger.error("Edicola with id {} not found.", codice);
			return new ResponseEntity(new CustomErrorType("Edicola with code " + codice + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Edicola>(Edicola, HttpStatus.OK);
	}
	@RequestMapping(value = "/Edicole/Count/{variable}/Value/{value}", method = RequestMethod.GET)
	public ResponseEntity<?> countEdicolaByVariable(@PathVariable("variable") String variable , @PathVariable("value") String value) throws IOException {
		logger.info("counting Edicole with variable {} and value {}", variable,value);
		int count = EdicolaService.countEdicolaByVariable(variable, value);
		if (count == 0 || count == -1) {
			logger.error("Error request, variable : {}  with value {} not found.", variable,value);
			return new ResponseEntity(new CustomErrorType("Error request, variable : " + variable +" with value : "+value+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}
	
	
}