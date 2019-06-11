package esamePO.springboot.service;
import org.springframework.stereotype.Service;

import esamePO.springboot.model.Edicola;
import esamePO.springboot.model.Response;
import java.io.IOException;
import java.util.ArrayList;



@Service("edicolaService")
public class EdicolaServiceImplements  implements EdicolaService {

	private static ArrayList<Edicola> edicole;

	static{
		try {
			edicole= populate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserCSVException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Edicola> getEdicole() {
		return edicole;
	}

	public Edicola getEdicolaById(int id) {
		for(Edicola Edicola : edicole){
			System.out.println("CODICE : "+Edicola.getCodice());
			if(Edicola.getId() == id){
				return Edicola;
			}
		}
		return null;
	}


	public Edicola getEdicolaByCodice(String codice) {
		for(Edicola Edicola : edicole){
			if(Edicola.getCodice().equals(codice.trim())){
				return Edicola;
			}
		}
		return null;
	}

	private int count(String variable, String value) throws IOException{
		int x = 0; 
		switch(variable) {
		case "municipio": 
			x = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.getMunicipio() == Integer.parseInt(value)){
					x++;
				}
			}
			break;

		case "venditaEsclusiva":
			x = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.isVenditaEsclusiva() == Boolean.parseBoolean(value)){
					x++;
				}
			}
			break;

		case "formaVendita":
			x = 0 ;
			for(Edicola Edicola : edicole){
				if(Edicola.getFormaVenditaEdicole().replace(" ", "").equals(value.replace(" ", ""))){
					x++;
				}
			}
			break;
		}
		return x;
	}

	public Response countEdicolaByVariable (String variable, String value) throws IOException {
		int count = -1; 
		Response risposta = null; 
		switch(variable) {
		case "municipio": 
			count = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.getMunicipio() == Integer.parseInt(value)){
					count++;
				}
			}
			risposta = new Response ("Hai ricercato il numero di edicole presenti nel municipio : "+value,
					"Sono presenti : "+count+ " edicole nel municipio "+value);
			break;

		case "venditaEsclusiva":
			count = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.isVenditaEsclusiva() == Boolean.parseBoolean(value)){
					count++;
				}
			}
			risposta = new Response ("Hai ricercato il numero di edicole con vendita esclusiva uguale a : "+value,
					"Sono presenti : "+count+ " edicole con vendita esclusiva uguale a : "+value);
			break;

		case "formaVendita":
			count = 0 ;
			for(Edicola Edicola : edicole){
				if(Edicola.getFormaVenditaEdicole().replace(" ", "").equals(value.replace(" ", ""))){
					count++;
				}
			}
			risposta = new Response ("Hai ricercato il numero di edicole con la forma di vendita : "+value,
					"Sono presenti : "+count+ " edicole, con la forma di vendita :  "+value);
			break;
		}

		return risposta;
	}


	public Response maxEdicolaByVariable(String variable) throws IOException {
		String msg = "" ;
		Response risposta = null; 

		switch(variable) {
		case "municipio":
			int maximum = 0;
			int municipio = 0;
			for(Edicola Edicola : edicole){
				int max = count ("municipio", Integer.toString( Edicola.getMunicipio()));
				if(maximum < max) {
					maximum = max; 
					municipio = Edicola.getMunicipio();
				}	
			}
			msg = "Il municipio con il maggior numero di edicole è il : "+municipio+ ", numero di edicole : "+maximum;
			risposta = new Response ("Hai ricercato il numero max di edicole in base al  : "+variable,msg);
			break;
		case "venditaEsclusiva":
			int venditaEsclusivaTrue = count ("venditaEsclusiva", "true");
			int venditaEsclusivaFalse = count ("venditaEsclusiva", "false");

			if(venditaEsclusivaTrue < venditaEsclusivaFalse) {
				msg = "Sono presenti più edicole senza la vendita esclusiva, sono infatti : "+venditaEsclusivaFalse;
			}else {
				msg = "Sono presenti più edicole con la vendita esclusiva, sono infatti : "+venditaEsclusivaTrue;
			}
			risposta = new Response ("Hai ricercato il numero max di edicole 'con' e 'senza' vendita esclusiva",msg);
			break;
		case "formaVendita":
			String formaVendita="";
			int n = 0; int maxFV = 0; 
			for(Edicola Edicola : edicole){
				n = count("formaVendita",Edicola.getFormaVenditaEdicole());
				if(maxFV < n) {
					maxFV = n ; 
					formaVendita = Edicola.getFormaVenditaEdicole();
				}


			}
			msg = "il numero massimo di edicole in base ad una determinata forma vendita è : "+maxFV+ " e la forma vendità più gettonata è : "+formaVendita;
			risposta = new Response ("Hai ricercato il numero max di edicole in base al  : "+variable,msg);
			break;
		}
		return risposta;
	}

	public Response minEdicolaByVariable(String variable) throws IOException {
		String msg = "" ;
		Response risposta = null; 

		switch(variable) {
		case "municipio":
			int minum = 1000000;
			int municipio = 0;
			for(Edicola Edicola : edicole){
				int min = count ("municipio", Integer.toString( Edicola.getMunicipio()));
				if(minum > min) {
					minum = min; 
					municipio = Edicola.getMunicipio();
				}	
			}
			msg = "Il municipio con il minur numero di edicole è il : "+municipio+ ", numero di edicole : "+minum;
			risposta = new Response ("Hai ricercato il numero min di edicole in base al  : "+variable,msg);
			break;
		case "venditaEsclusiva":
			int venditaEsclusivaTrue = count ("venditaEsclusiva", "true");
			int venditaEsclusivaFalse = count ("venditaEsclusiva", "false");

			if(venditaEsclusivaTrue < venditaEsclusivaFalse) {
				msg = "Sono presenti meno edicole con la vendita esclusiva, sono infatti : "+venditaEsclusivaTrue;
			}else {
				msg = "Sono presenti meno edicole senza la vendita esclusiva, sono infatti : "+venditaEsclusivaFalse;
			}
			risposta = new Response ("Hai ricercato il numero max di edicole 'con' e 'senza' vendita esclusiva",msg);
			break;
		case "formaVendita":
			String formaVendita="";
			int min = 0;
			int minFV = 1000000; 
			for(Edicola Edicola : edicole){
				min = count("formaVendita",Edicola.getFormaVenditaEdicole());
				if(minFV > min) {
					minFV = min ; 
					formaVendita = Edicola.getFormaVenditaEdicole();
				}
			}
			msg = "il numero minimo di edicole in base ad una determinata forma vendita è : "+minFV+ " e la forma vendità più gettonata è : "+formaVendita;
			risposta = new Response ("Hai ricercato il numero min di edicole in base al  : "+variable,msg);
			break;
		}
		return risposta;
	}

	public Response getMetaData() {
		Response risposta = null; 
		String msg ="long : id , String : codice ,"
				+ " String : ubicazione "+
				"String : areaDiCompetenza,"
				+ " String : descrizioneVia,"
				+ " String : Civico,"
				+ " int : codiceVia,"
				+ " String : Localita,"
				+ " String : formaVenditaEdicole,"
				+ " boolean : VenditaEsclusiva,"
				+ " int : municipio,"
				+ " double : LONGIT,"
				+ " double : LATIT,"
				+ " double[] : location";
		risposta = new Response ("Hai richiesto i metadata", msg);
		return risposta; 

	}


	public Response avgEdicolaByVariable (String variable) throws IOException{
		String msg = "" ;
		Response risposta = null;
		int somma = 0;
		double media = 0.0;
		int i = 0;
		switch(variable) {
		case "municipio":

			for( i = 1 ; i < 10 ; i++){
				somma += count ("municipio", Integer.toString(i));
			}
			media = (double)somma/(double) 9;
			msg = "La media di Edicole per municipio e' : "+media;
			risposta = new Response ("Hai cercato media di edicole per municipio",msg);
			break;
		case "venditaEsclusiva":
			int venditaEsclusivaTrue = count ("venditaEsclusiva", "true");
			int venditaEsclusivaFalse = count ("venditaEsclusiva", "false");

			msg = "La media di edicole con vendita esclusiva e' pari a : "+(double)venditaEsclusivaTrue/(double)edicole.size();
			msg+= " ,mentre la media di edicole senza vendita esclusiva e' pari a : "+(double)venditaEsclusivaFalse/(double)edicole.size();

			risposta = new Response ("Hai cercato la media di edicole 'con' e 'senza' vendita esclusiva",msg);
			break;
		case "formaVendita":
			int a = 0, b = 0, c = 0, d = 0, e = 0;
			for(i = 0 ; i < edicole.size(); i++) {
				switch(edicole.get(i).getFormaVenditaEdicole()) {
				case "rivenditainnegozio":
					a++;
					break;
				case "rivenditainsupermercato":
					b++;
					break;
				case "edicolasusuolopubblico":
					c++;
					break;
				case "edicolasusuoloprivato":
					d++;
					break;
				default:
					e++;
					break;
				}
			}
			msg+=" media edicole con forma vendita : rivendita in negozio e' pari a : "+(double)a/(double)edicole.size();
			msg+=" media edicole con forma vendita : rivendita in supermercato e' pari a : "+(double)b/(double)edicole.size();
			msg+=" media edicole con forma vendita : edicola su suolo pubblico e' pari a : "+(double)c/(double)edicole.size();
			msg+=" media edicole con forma vendita : edicola su suolo privato e' pari a : "+(double)d/(double)edicole.size();
			msg+=" media edicole con diversa forma vendita e' pari a : "+(double)e/(double)edicole.size();
			risposta = new Response ("Hai cercato media di edicole per forma di vendita",msg);
			break;

		case "posizione":
			double longitudine = 0; 
			double latitudine = 0;
			for(Edicola Edicola : edicole){
				longitudine += Edicola.getLONGIT(); 
				latitudine += Edicola.getLATIT();
			}
			msg = "La posizione media delle edicole sta a LATITUDINE : "+(latitudine/(double)edicole.size())+" e LONGITUDINE : "+(longitudine/(double)edicole.size());
			risposta = new Response ("Hai cercato la posizione media delle edicole",msg);
			break;
		}

		return risposta;
	}

	/*
	 * Metodo non implementato, per insufficienza di dati
	 */
	public Response sumData(String data,String value) {
		Response risposta = null;
		String msg = ""; 
		double somma = 0.0; 
		for(Edicola Edicola : edicole){
			switch(value) {
			case "A":
				somma += Edicola.getMunicipio();
				break;
			case "B": 
				somma+= Edicola.getCodiceVia();
				break;
			}
			somma += Edicola.getLONGIT(); 
		}
		msg = "La somma risulta : "+somma;
		risposta = new Response("Hai fatto la somma di :"+value, msg);
		return risposta; 	
	}
	
	private double[] avgPosition() {
		double position[] = new double [2];
		double sommaLong = 0.0;
		double sommaLatt = 0.0;
		for(Edicola Edicola : edicole){
			sommaLong += Edicola.getLONGIT(); 
			sommaLatt += Edicola.getLATIT();
		}
		position[0] = (double) sommaLong/ (double) edicole.size();
		position[1] = (double) sommaLatt/ (double) edicole.size();
		return position;
	}
	
	public Response devStdData() throws IOException {
		double avg [] = new double[2]; 
		Response risposta = null;
		String msg = "Hai richiesto la deviazione standard della positione delle edicole";
		avg = avgPosition ();
		
		double diffLong = 0.0;
		double diffLatt = 0.0;
		
		for(Edicola Edicola : edicole){
			diffLong += Math.pow((Edicola.getLONGIT() - avg[0]), 2);
			diffLatt += Math.pow((Edicola.getLATIT() - avg[1]), 2);
		}
		
		double sigmaLong = (double) diffLong/ (double)edicole.size();
		double sigmaLatt = (double) diffLatt/ (double)edicole.size();
		
		double devStdLong = Math.sqrt(sigmaLong);
		double devStdLatt = Math.sqrt(sigmaLatt);
		
		risposta = new Response(msg,"La deviazione standard è LONG : "+devStdLong+ " LATT : "+devStdLatt);
		return risposta; 
		
	}

	private static ArrayList<Edicola> populate() throws IOException, ParserCSVException{
		ArrayList<Edicola> edicoleS = new ArrayList<Edicola>();

		String json = "{\"help\":\"Return the metadata of a dataset (package) and its resources. :param id: the id or name of the dataset :type id: string\",\"success\":true,\"result\":{\"id\":\"19eb95bf-6b06-43b8-b28a-e774eb5a7391\",\"name\":\"attivit-commerciali-edicole\",\"title\":\"Attivit\\u00e0\\u00a0commerciali: edicole\",\"author_email\":\"opendatamilano@comune.milano.it\",\"maintainer_email\":\"opendatamilano@comune.milano.it\",\"license_url\":\"http:\\/\\/creativecommons.org\\/licenses\\/by\\/4.0\\/\",\"license_id\":\"CC-BY 4.0\",\"notes\":\"\\u003Cp\\u003EIl dataset contiene l\\u0027elenco delle rivendite di quotidiani e riviste (edicole). Sono presenti informazioni relative a: localizzazione per via e numero civico; edicola su suolo pubblico o negozio; dimensioni del chiosco; vendita esclusiva s\\u00ec\\/no; forma di vendita (p. es. in stazione mm, in centro comm.le, in stazione ferroviaria, ecc.); informazioni storiche sul settore di attivit\\u00e0. I dati sono aggiornati al 31\\/12\\/2018.\\u003C\\/p\\u003E\\n\",\"state\":\"Active\",\"log_message\":\"Update to resource \\u0027ds57_economia_edicole_2018.geojson\\u0027\",\"revision_timestamp\":\"2019-05-27T14:30:01+02:00\",\"metadata_created\":\"2017-11-09T14:36:54+01:00\",\"metadata_modified\":\"2019-05-16T14:15:27+02:00\",\"creator_user_id\":\"9bcba160-349c-4d14-8a53-d4168349d053\",\"type\":\"Dataset\",\"resources\":[{\"id\":\"056761b5-33e4-4db5-8d65-e6b497ed3226\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/30211213-5291-4ae4-ade3-38f8008159dc\\/download\\/economia_edicole_2018_coord.csv\",\"description\":\"\",\"format\":\"csv\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds57_economia_edicole\",\"mimetype\":\"csv\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"674fa9d3-4992-4d29-872d-a8937b19defc\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/a423571c-efb8-4bd4-b5e8-43f692a7488f\\/download\\/economia_edicole_2018_coord.json\",\"description\":\"\",\"format\":\"json\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"DS57_Economia_edicole.json\",\"mimetype\":\"json\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"003575fa-acef-4de8-a7b8-a0210ae47e2c\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/4c2fb9ba-320a-433b-a59a-5cc418485aa1\\/download\\/economia_edicole_2018.geojson\",\"description\":\"\",\"format\":\"geojson\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds57_economia_edicole_2018.geojson\",\"mimetype\":\"geojson\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"}],\"tags\":[{\"id\":\"312542e2-d9ea-4c0d-ade7-5a45d8ffc04f\",\"vocabulary_id\":\"2\",\"name\":\"fare_impresa\"},{\"id\":\"27941d09-d81a-4971-8c27-54a3f292fd5e\",\"vocabulary_id\":\"2\",\"name\":\"zona\"}],\"groups\":[{\"display_name\":\"Economia e finanze\",\"description\":\"\\u003Cp\\u003EThis concept identifies datasets covering such domains as economy or finance.\\u003C\\/p\\u003E\\n\",\"id\":\"d51ce83d-0d00-4955-afbd-2c9240ee7596\",\"title\":\"ECON\",\"name\":\"Economia e finanze\"}],\"organization\":[{\"title\":\"Comune di Milano\",\"description\":\"\",\"id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"image_url\":\"https:\\/\\/www.dati.gov.it\\/sites\\/default\\/files\\/comune_milano.png\",\"name\":\"group\\/comune-milano\",\"created\":\"2018-01-08T11:46:21+01:00\",\"type\":\"organization\"}],\"extras\":[{\"key\":\"\",\"value\":\"\"}],\"_catalog_parent_name\":\"Comune di Milano\",\"_catalog_source_url\":\"http:\\/\\/dati.comune.milano.it\\/api\\/3\\/action\\/package_list\"}}";
		String filename = "miofile.csv";
		Parser parse = new Parser (json, filename);
		parse.download(parse.getURL(json),parse.getFilename());
		parse.parseCSV(parse.readFile(parse.getFilename()));
		ArrayList <Edicola> edicole = parse.getEdicole();

		System.out.println("edicole memorizzate : "+edicole.size());

		for(int i = 0 ; i < edicole.size() ; i++) {
			edicoleS.add(new Edicola(edicole.get(i)));
		}
		return edicoleS;
	}

}

