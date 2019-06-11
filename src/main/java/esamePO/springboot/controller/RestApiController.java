package esamePO.springboot.controller;

import java.io.IOException;
import java.util.List;

import esamePO.springboot.model.Edicola;
import esamePO.springboot.model.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import esamePO.springboot.service.EdicolaService;
import esamePO.springboot.util.CustomErrorType;

/**
 * E' la classe controller che permette all'utente finale di interagire con la nostra applicazione 
 * @author denis bernovschi
 * @version 3.0
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	EdicolaService EdicolaService;


	/** 
	 *  Restituisce tutte le edicole presenti
	 */
	@RequestMapping(value = "/Edicole/", method = RequestMethod.GET)
	public ResponseEntity<List<Edicola>> listAllEdicolas() {
		List<Edicola> Edicolas = EdicolaService.getEdicole();
		if (Edicolas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Edicola>>(Edicolas, HttpStatus.OK);
	}
	/** 
	 *  Restituisce l'edicola con l'ID scelto dall'utente
	 */
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
	/** 
	 *  Restituisce l'edicola con il codice scelto dall'utente
	 */
	@RequestMapping(value = "/Edicola/Codice/{code}", method = RequestMethod.GET)
	public ResponseEntity<?> getEdicolaByCodice(@PathVariable("code") String codice) {
		logger.info("Fetching Edicola with code {}", codice);
		Edicola Edicola = EdicolaService.getEdicolaByCodice(codice);
		if (Edicola == null) {
			logger.error("Edicola with id {} not found.", codice);
			return new ResponseEntity(new CustomErrorType("Edicola with code " + codice + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Edicola>(Edicola, HttpStatus.OK);
	}
	/** 
	 *  Restituisce il conteggio {variabile} e {value} scelti dall'utente
	 */
	@RequestMapping(value = "/Edicole/Count/{variable}/Value/{value}", method = RequestMethod.GET)
	public ResponseEntity<?> countEdicolaByVariable(@PathVariable("variable") String variable , @PathVariable("value") String value) throws IOException {
		logger.info("counting Edicole with variable {} and value {}", variable,value);
		Response risposta = EdicolaService.countEdicolaByVariable(variable, value);
		if (risposta == null) {
			logger.error("Error request, variable : {}  with value {} not found.", variable,value);
			return new ResponseEntity(new CustomErrorType("Error request, variable : " + variable +" with value : "+value+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(risposta, HttpStatus.OK);
	}
	/** 
	 *  Restituisce il max {variabile} scelta dall'utente
	 */
	@RequestMapping(value = "/Edicole/Max/{variable}", method = RequestMethod.GET)
	public ResponseEntity<?> maxEdicolaByVariable(@PathVariable("variable") String variable) throws IOException {
		logger.info("counting Edicole with variable {}", variable);
		Response risposta = EdicolaService.maxEdicolaByVariable(variable);
		if (risposta == null) {
			logger.error("Error request, variable : {} not found.", variable);
			return new ResponseEntity(new CustomErrorType("Error request, variable : " + variable + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(risposta, HttpStatus.OK);
	}
	/** 
	 *  Restituisce il min {variabile} scelta dall'utente
	 */
	@RequestMapping(value = "/Edicole/Min/{variable}", method = RequestMethod.GET)
	public ResponseEntity<?> minEdicolaByVariable(@PathVariable("variable") String variable) throws IOException {
		logger.info("counting Edicole with variable {}", variable);
		Response risposta = EdicolaService.minEdicolaByVariable(variable);
		if (risposta == null) {
			logger.error("Error request, variable : {} not found.", variable);
			return new ResponseEntity(new CustomErrorType("Error request, variable : " + variable + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(risposta, HttpStatus.OK);
	}
	/** 
	 *  Restituisce la avg {variabile} scelta dall'utente
	 */
	@RequestMapping(value = "/Edicole/Avg/{variable}", method = RequestMethod.GET)
	public ResponseEntity<?> avgEdicolaByVariable(@PathVariable("variable") String variable) throws IOException {
		logger.info("counting Edicole with variable {}", variable);
		Response risposta = EdicolaService.avgEdicolaByVariable(variable);
		if (risposta == null) {
			logger.error("Error request, variable : {} not found.", variable);
			return new ResponseEntity(new CustomErrorType("Error request, variable : " + variable + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(risposta, HttpStatus.OK);
	}
	
	/** 
	 *  Restituisce i metadata
	 */
	@RequestMapping(value = "/Metadata/", method = RequestMethod.GET)
	public ResponseEntity<?> getMetadata() throws IOException {
		logger.info("get metadata");
		Response risposta = EdicolaService.getMetaData();
		if (risposta == null) {
			logger.error("Error request, metadata ");
			return new ResponseEntity(new CustomErrorType("Error request, metadata not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(risposta, HttpStatus.OK);
	}
	/** 
	 *  Restituisce deviazione standard 
	 */
	@RequestMapping(value = "/DevStd/", method = RequestMethod.GET)
	public ResponseEntity<?> devStdData() throws IOException {
		logger.info("get devStd");
		Response risposta = EdicolaService.devStdData();
		if (risposta == null) {
			logger.error("Error request, metadata ");
			return new ResponseEntity(new CustomErrorType("Error request, metadata not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(risposta, HttpStatus.OK);
	}
	

	
}