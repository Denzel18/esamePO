package esamePO.springboot.service;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import esamePO.springboot.model.Edicola;


public class Parser {

	private String json; 
	private String filename;
	private BufferedReader br;

	private static final String DEFAULT_SEPARATOR = ";";
	private static final AtomicLong counter = new AtomicLong();
	private static ArrayList <Edicola> edicole;

	protected Parser(String json, String filename){
		this.json = json; 
		this.filename = filename ; 
	}

	protected String getFilename() {
		return filename;
	}

	protected void setFilename(String filename) {
		this.filename = filename;
	}

	protected String getJson() {
		return json;
	}

	protected void setJson(String json) {
		this.json = json;
	}
	protected BufferedReader getBr() {
		return br;
	}

	protected void setBr(BufferedReader br) {
		this.br = br;
	}

	protected static AtomicLong getCounter() {
		return counter;
	}

	protected ArrayList<Edicola> getEdicole() {
		return edicole;
	}

	protected static void setEdicole(ArrayList<Edicola> edicole) {
		Parser.edicole = edicole;
	}

	public String getURL (String json) {
		String url_adress = "";
		JSONObject obj = new JSONObject(json);
		String name = obj.getJSONObject("result").getString("name");
		String revisione_time = obj.getJSONObject("result").getString("revision_timestamp");


		System.out.println("NOME : "+name);
		System.out.println("Ultima revisione : "+revisione_time);

		//comincio il parse
		JSONArray arr = obj.getJSONObject("result").getJSONArray("resources");
		for (int i = 0; i < arr.length(); i++) {
			String url = arr.getJSONObject(i).getString("url");
			int lunghezza = url.length();
			if(url.charAt(lunghezza-1)=='v' && url.charAt(lunghezza-2)=='s' && url.charAt(lunghezza-3)=='c' ) {
				System.out.println("E' un CSV ");
				url_adress = url; 
				return url_adress;
			}
			System.out.println(url);
		}
		return url_adress;
	}
	protected void downloadUsingStream(String urlStr, String file) throws IOException{
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count=0;
		while((count = bis.read(buffer,0,1024)) != -1)
		{
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
	}

	protected ArrayList<String> readFile(String filename) throws IOException{
		ArrayList <String> lines = new ArrayList<String>();
		int contatore = 0; 
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			this.br = new BufferedReader(fileReader);

			while(br.readLine() != null) {
				lines.add(br.readLine());
				contatore++;
			}
		}catch(IOException e ) {
			e.printStackTrace();
			System.out.println("Something wrong is happen");
		}
		System.out.println("linee recuperate : "+contatore);
		return lines;
	}

	protected ArrayList<Edicola> parseCSV (ArrayList<String> lines) throws ParserCSVException {
		ArrayList <Edicola> edicole = new ArrayList<Edicola>();
		String elements[] = new String [13];
		String line = "";
		int rowsNo = 0; 
		int rowsYes = 0;

		for(int j = 0 ; j < lines.size() ; j++) {
			line = lines.get(j);
			elements = line.split(DEFAULT_SEPARATOR);

			if(elements.length < 13) {
				rowsNo++;
			}else {
				rowsYes++;
				double location[] = new double[2];
				location[0] = Double.parseDouble(elements[10]);
				location[1] = Double.parseDouble(elements[11]);


				Edicola e = new Edicola (
						counter.incrementAndGet(),
						elements[0],
						elements[1],
						elements[2],
						elements[3],
						elements[4],
						Integer.parseInt(elements[5]),
						elements[6],
						elements[7],
						elements[8].trim().contains("S") ? true : false,
								Integer.parseInt(elements[9]),
								Double.parseDouble(elements[10]),
								Double.parseDouble(elements[11]),
								location);
				edicole.add(e);	
			}
		}
		System.out.println("rowsYes : "+rowsYes+" rowsNo : "+rowsNo);
		return edicole;
	}

	/*
	public static void main(String[] args) throws IOException, ParserCSVException {
		String json = "{\"help\":\"Return the metadata of a dataset (package) and its resources. :param id: the id or name of the dataset :type id: string\",\"success\":true,\"result\":{\"id\":\"19eb95bf-6b06-43b8-b28a-e774eb5a7391\",\"name\":\"attivit-commerciali-edicole\",\"title\":\"Attivit\\u00e0\\u00a0commerciali: edicole\",\"author_email\":\"opendatamilano@comune.milano.it\",\"maintainer_email\":\"opendatamilano@comune.milano.it\",\"license_url\":\"http:\\/\\/creativecommons.org\\/licenses\\/by\\/4.0\\/\",\"license_id\":\"CC-BY 4.0\",\"notes\":\"\\u003Cp\\u003EIl dataset contiene l\\u0027elenco delle rivendite di quotidiani e riviste (edicole). Sono presenti informazioni relative a: localizzazione per via e numero civico; edicola su suolo pubblico o negozio; dimensioni del chiosco; vendita esclusiva s\\u00ec\\/no; forma di vendita (p. es. in stazione mm, in centro comm.le, in stazione ferroviaria, ecc.); informazioni storiche sul settore di attivit\\u00e0. I dati sono aggiornati al 31\\/12\\/2018.\\u003C\\/p\\u003E\\n\",\"state\":\"Active\",\"log_message\":\"Update to resource \\u0027ds57_economia_edicole_2018.geojson\\u0027\",\"revision_timestamp\":\"2019-05-27T14:30:01+02:00\",\"metadata_created\":\"2017-11-09T14:36:54+01:00\",\"metadata_modified\":\"2019-05-16T14:15:27+02:00\",\"creator_user_id\":\"9bcba160-349c-4d14-8a53-d4168349d053\",\"type\":\"Dataset\",\"resources\":[{\"id\":\"056761b5-33e4-4db5-8d65-e6b497ed3226\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/30211213-5291-4ae4-ade3-38f8008159dc\\/download\\/economia_edicole_2018_coord.csv\",\"description\":\"\",\"format\":\"csv\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds57_economia_edicole\",\"mimetype\":\"csv\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"674fa9d3-4992-4d29-872d-a8937b19defc\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/a423571c-efb8-4bd4-b5e8-43f692a7488f\\/download\\/economia_edicole_2018_coord.json\",\"description\":\"\",\"format\":\"json\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"DS57_Economia_edicole.json\",\"mimetype\":\"json\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"003575fa-acef-4de8-a7b8-a0210ae47e2c\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/19eb95bf-6b06-43b8-b28a-e774eb5a7391\\/resource\\/4c2fb9ba-320a-433b-a59a-5cc418485aa1\\/download\\/economia_edicole_2018.geojson\",\"description\":\"\",\"format\":\"geojson\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds57_economia_edicole_2018.geojson\",\"mimetype\":\"geojson\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"}],\"tags\":[{\"id\":\"312542e2-d9ea-4c0d-ade7-5a45d8ffc04f\",\"vocabulary_id\":\"2\",\"name\":\"fare_impresa\"},{\"id\":\"27941d09-d81a-4971-8c27-54a3f292fd5e\",\"vocabulary_id\":\"2\",\"name\":\"zona\"}],\"groups\":[{\"display_name\":\"Economia e finanze\",\"description\":\"\\u003Cp\\u003EThis concept identifies datasets covering such domains as economy or finance.\\u003C\\/p\\u003E\\n\",\"id\":\"d51ce83d-0d00-4955-afbd-2c9240ee7596\",\"title\":\"ECON\",\"name\":\"Economia e finanze\"}],\"organization\":[{\"title\":\"Comune di Milano\",\"description\":\"\",\"id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"image_url\":\"https:\\/\\/www.dati.gov.it\\/sites\\/default\\/files\\/comune_milano.png\",\"name\":\"group\\/comune-milano\",\"created\":\"2018-01-08T11:46:21+01:00\",\"type\":\"organization\"}],\"extras\":[{\"key\":\"\",\"value\":\"\"}],\"_catalog_parent_name\":\"Comune di Milano\",\"_catalog_source_url\":\"http:\\/\\/dati.comune.milano.it\\/api\\/3\\/action\\/package_list\"}}";
		String filename = "miofile.csv";
		edicole = new ArrayList <Edicola>();
		Parser parse = new Parser (json, filename);
		parse.downloadUsingStream(parse.getURL(json),parse.getFilename());
		parse.edicole = parse.parseCSV(parse.readFile(parse.getFilename()));
	}*/



}
