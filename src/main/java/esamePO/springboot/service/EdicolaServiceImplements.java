package esamePO.springboot.service;
import org.springframework.stereotype.Service;

import esamePO.springboot.model.Edicola;
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


	public int countEdicolaByVariable (String variable, String value) throws IOException {
		int count = -1; 
		switch(variable) {
		case "municipio": 
			count = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.getMunicipio() == Integer.parseInt(value)){
					count++;
				}
			}
			break;

		case "venditaEsclusiva":
			count = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.isVenditaEsclusiva() == Boolean.parseBoolean(value)){
					count++;
				}
			}
			break;

		case "formaVendita":
			count = 0 ;
			for(Edicola Edicola : edicole){
				if(Edicola.getFormaVenditaEdicole().replace(" ", "").equals(value.replace(" ", ""))){
					count++;
				}
			}
			break;
		}

		return count;
	}

	private static ArrayList<Edicola> populate() throws IOException, ParserCSVException{
		ArrayList<Edicola> edicoleS = new ArrayList<Edicola>();

		String json = "{\"help\":\"Return the metadata of a dataset (package) and its resources. :param id: the id or name of the dataset :type id: string\",\"success\":true,\"result\":{\"id\":\"19eb95bf-6b06-43b8-b28a-e774eb5a7391\",\"name\":\"attivit-commerciali-edicole\",\"title\":\"Attivit\\u00e0\\u00a0commerciali: edicole\",\"author_email\":\"opendatamilano@comune.milano.it\",\"maintainer_email\":\"opendatamilano@comune.milano.it\",\"license_url\":\"http:\\/\\/creativecommons.org\\/licenses\\/by\\/4.0\\/\",\"license_id\":\"CC-BY 4.0\",\"notes\":\"\\u003Cp\\u003EIl dataset contiene l\\u0027elenco delle rivendite di quotidiani e riviste (edicole). Sono presenti informazioni relative a: localizzazione per via e numero civico; edicola su suolo pubblico o negozio; dimensioni del chiosco; vendita esclusiva s\\u00ec\\/no; forma di vendita (p. es. in stazione mm, in centro comm.le, in stazione ferroviaria, ecc.); informazioni storiche sul settore di attivit\\u00e0. I dati sono aggiornati al 31\\/12\\/2018.\\u003C\\/p\\u003E\\n\",\"state\":\"Active\",\"log_message\":\"Update to resource \\u0027ds57_economia_edicole_2018.geojson\\u0027\",\"revision_timestamp\":\"2019-05-27T14:30:01+02:00\",\"metadata_created\":\"2017-11-09T14:36:54+01:00\",\"metadata_modified\":\"2019-05-16T14:15:27+02:00\",\"creator_user_id\":\"9bcba160-349c-4d14-8a53-d4168349d053\",\"type\":\"Dataset\",\"resources\":[{\"id\":\"056761b5-33e4-4db5-8d65-e6b497ed3226\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/30211213-5291-4ae4-ade3-38f8008159dc\\/download\\/economia_edicole_2018_coord.csv\",\"description\":\"\",\"format\":\"csv\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds57_economia_edicole\",\"mimetype\":\"csv\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"674fa9d3-4992-4d29-872d-a8937b19defc\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/a423571c-efb8-4bd4-b5e8-43f692a7488f\\/download\\/economia_edicole_2018_coord.json\",\"description\":\"\",\"format\":\"json\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"DS57_Economia_edicole.json\",\"mimetype\":\"json\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"003575fa-acef-4de8-a7b8-a0210ae47e2c\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/4c2fb9ba-320a-433b-a59a-5cc418485aa1\\/download\\/economia_edicole_2018.geojson\",\"description\":\"\",\"format\":\"geojson\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds57_economia_edicole_2018.geojson\",\"mimetype\":\"geojson\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"}],\"tags\":[{\"id\":\"312542e2-d9ea-4c0d-ade7-5a45d8ffc04f\",\"vocabulary_id\":\"2\",\"name\":\"fare_impresa\"},{\"id\":\"27941d09-d81a-4971-8c27-54a3f292fd5e\",\"vocabulary_id\":\"2\",\"name\":\"zona\"}],\"groups\":[{\"display_name\":\"Economia e finanze\",\"description\":\"\\u003Cp\\u003EThis concept identifies datasets covering such domains as economy or finance.\\u003C\\/p\\u003E\\n\",\"id\":\"d51ce83d-0d00-4955-afbd-2c9240ee7596\",\"title\":\"ECON\",\"name\":\"Economia e finanze\"}],\"organization\":[{\"title\":\"Comune di Milano\",\"description\":\"\",\"id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"image_url\":\"https:\\/\\/www.dati.gov.it\\/sites\\/default\\/files\\/comune_milano.png\",\"name\":\"group\\/comune-milano\",\"created\":\"2018-01-08T11:46:21+01:00\",\"type\":\"organization\"}],\"extras\":[{\"key\":\"\",\"value\":\"\"}],\"_catalog_parent_name\":\"Comune di Milano\",\"_catalog_source_url\":\"http:\\/\\/dati.comune.milano.it\\/api\\/3\\/action\\/package_list\"}}";
		String filename = "miofile.csv";
		Parser parse = new Parser (json, filename);
		parse.downloadUsingStream(parse.getURL(json),parse.getFilename());
		parse.parseCSV(parse.readFile(parse.getFilename()));
		ArrayList <Edicola> edicole = parse.getEdicole();

		System.out.println("edicole memorizzate : "+edicole.size());

		for(int i = 0 ; i < edicole.size() ; i++) {
			edicoleS.add(new Edicola(edicole.get(i)));
		}

		return edicoleS;
	}
}

