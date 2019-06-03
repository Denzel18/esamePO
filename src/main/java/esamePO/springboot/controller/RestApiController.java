package esamePO.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import esamePO.springboot.model.Edicola;
import esamePO.springboot.service.EdicolaService;
import esamePO.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	EdicolaService EdicolaService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Edicolas---------------------------------------------

	@RequestMapping(value = "/Edicole/", method = RequestMethod.GET)
	public ResponseEntity<List<Edicola>> listAllEdicolas() {
		List<Edicola> Edicolas = EdicolaService.getAllEdicola();
		if (Edicolas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Edicola>>(Edicolas, HttpStatus.OK);
	}

	// -------------------Retrieve Single Edicola------------------------------------------

	@RequestMapping(value = "/Edicola/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEdicola(@PathVariable("id") String id) {
		logger.info("Fetching Edicola with id {}", id);
		Edicola Edicola = EdicolaService.getEdicolaById(id);
		if (Edicola == null) {
			logger.error("Edicola with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Edicola with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Edicola>(Edicola, HttpStatus.OK);
	}

	
}