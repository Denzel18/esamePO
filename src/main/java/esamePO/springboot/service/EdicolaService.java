package esamePO.springboot.service;
import java.io.IOException;
import java.util.ArrayList;
import esamePO.springboot.model.Edicola;

public interface EdicolaService {
	
	

	//campi no string 
	/*
	double avgData(ArrayList<Edicola> edicole, String data);
	double minData(ArrayList<Edicola> edicole, String data);
	double maxData(ArrayList<Edicola> edicole, String data);
	double devStdData(ArrayList<Edicola> edicole, String data);
	double sumData(ArrayList<Edicola> edicole, String data);
	double countData(ArrayList<Edicola> edicole, String data);
	*/
	
	Edicola getEdicolaByCodice(String codice);
	Edicola getEdicolaById(int codice);
	ArrayList <Edicola> getEdicole ();
	
	int countEdicolaByVariable (String variable, String value) throws IOException;
	//getMetaData
	
	//getData 
	
	//campi string 
	//int countDataString(ArrayList<Edicola> edicole, String data);
}
