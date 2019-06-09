package esamePO.springboot.service;
import java.io.IOException;
import java.util.ArrayList;
import esamePO.springboot.model.Edicola;
import esamePO.springboot.model.Response;

public interface EdicolaService {
	
	

	//campi no string 

	/*
	double devStdData(ArrayList<Edicola> edicole, String data);
	double sumData(ArrayList<Edicola> edicole, String data);
	*/
	
	Edicola getEdicolaByCodice(String codice);
	Edicola getEdicolaById(int codice);
	ArrayList <Edicola> getEdicole ();
	
	Response countEdicolaByVariable (String variable, String value) throws IOException;
	Response maxEdicolaByVariable (String variable) throws IOException;
	Response minEdicolaByVariable (String variable) throws IOException;
	Response getMetaData(); 
	Response avgEdicolaByVariable (String variable) throws IOException;
	

	
	//campi string 
	//int countDataString(ArrayList<Edicola> edicole, String data);
}
