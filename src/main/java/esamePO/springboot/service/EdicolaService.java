package esamePO.springboot.service;
import java.util.List;
import esamePO.springboot.model.Edicola;

public interface EdicolaService {
	
	

	//campi no string 
	double avgData(List<Edicola> edicole, String data);
	double minData(List<Edicola> edicole, String data);
	double maxData(List<Edicola> edicole, String data);
	double devStdData(List<Edicola> edicole, String data);
	double sumData(List<Edicola> edicole, String data);
	double countData(List<Edicola> edicole, String data);
	
	
	Edicola getEdicolaById(String codice);
	List <Edicola> getAllEdicola ();
	//getMetaData
	
	//getData 
	
	//campi string 
	int countDataString(List<Edicola> edicole, String data);
}
