package esamePO.springboot.service;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import esamePO.springboot.model.Edicola;


/**
 * 
 * 
 * Questa classe è dedita al parse JSON, che ci permette di scaricare
 * il file .CSV, una volta scaricato il file.csv parte il parser di quest'ultimo
 * che genera un'arraylist contente le informazioni recuperate, e le valorizza in
 * un ArrayList
 * 
 * @author denis bernovschi
 * @version 1.0
 * 
 */

public class Parser {

	private String json; 
	private String filename;
	private BufferedReader br;

	private static final String DEFAULT_SEPARATOR = ";";
	private static final AtomicLong counter = new AtomicLong();
	private ArrayList <Edicola> edicole;

	/**
	 * 
	 * Il costruttore ci permette di instanziare un nuovo oggetto con le 
	 * caratteristiche desiderate, attraverso il passaggio dei parametri.
	 * 
	 * @param json l'oggetto String contenente il json
	 * @param filename l'oggetto String contente il nome del file
	 * 
	 */
	protected Parser(String json, String filename){
		this.json = json; 
		this.filename = filename ; 
	}
	
	protected Parser() {
		
	}

	/**
	 * Ci restituisce il nome del file che l'utente ha inserito al momento della creazione del oggetto Parser @see Parser
	 * 
	 * @return filename filename è 
	 * 
	 */
	protected String getFilename() {
		return filename;
	}
	/**
	 * 
	 * @param filename Ci permette di impostare il nome del file in un secondo momento 
	 * 
	 */

	protected void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Ci restituisce il contenuto del attributo json valorizzato al momento della creazione del oggetto Parser @see Parser
	 * 
	 * @return json 
	 * 
	 */
	protected String getJson() {
		return json;
	}
	/**
	 * 
	 * Ci permette di impostare il json in un secondo momento 
	 * 
	 * @param json una stringa contenente il json
	 *
	 */

	protected void setJson(String json) {
		this.json = json;
	}

	/**
	 * 
	 * Ci restituisce un contatore dedito alla valorizzazione del campo id di Edicola @see parseCSV
	 * 
	 * @return counter
	 * 
	 */
	protected static AtomicLong getCounter() {
		return counter;
	}

	/**
	 * 
	 * Ci restituisce l'arraylist contenente tutte le edicole memorizzate in seguito al @see parseCSV
	 * 
	 * @return edicole arraylist di edicola
	 *
	 */
	protected ArrayList<Edicola> getEdicole() {
		return edicole;
	}

	/**
	 * 
	 * Ci permette di impostare l'arrayList edicole (attributo della classe) passando un altro arraylist del tipo Edicola
	 * 
	 * @param edicole arraylist di edicola, per valorizzare l'attributo della classe
	 * 
	 * 
	 */
	protected void setEdicole(ArrayList<Edicola> edicole) {
		this.edicole = edicole;
	}

	/**
	 * 
	 * Dato un contenuto json effettuo il parser al fine di trovare l'url address relativo al file .csv
	 * @return url_adress l'indirizzo della risorsa .csv
	 * @file file il nome del file in cui è memorizzato il parse
	 * @throws FileNotFoundException vista la remota possibilità che l'utente specifichi un file inesistente
	 * 
	 *  
	 */
	protected String parseJSON (String file) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String json = "";
		try {
			String line = reader.readLine();
			while(line!=null) {
				json += line;
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String url_adress = "";
		JSONObject obj = new JSONObject(json);
		String name = obj.getJSONObject("result").getString("name");
		String revisione_time = obj.getJSONObject("result").getString("revision_timestamp");

		System.out.println("NOME : "+name);
		System.out.println("Ultima revisione : "+revisione_time);

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

	/**
	 * 
	 * Ci restituisce un'array list di String che poi verrano processate dal @see parseCSV
	 * 
	 * @param filename il nome del file @see download
	 * @return lines arraylist di stringhe del file 
	 * @throws IOException visto l'utilizzo di metodi di lettura/scrittura e' valido introdurre l'IOException
	 * 
	 */
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

	/**
	 * 
	 * Prende in ingresso l'arraylist creato da @see readFile e ci permette la creazione 
	 * del array list di tipo Edicola effettuando diversi controlli al fine di garantire
	 * dati consistenti e congruenti  
	 * 
	 * @param lines le linee del file letto in precedenza @see readFile
	 * @throws ParserCSVException visto al fine di evitare nuovi eccezioni durante il parse ho previsto una classe Exception, ParserCSVException
	 * 
	 */

	protected void parseCSV (ArrayList<String> lines) throws ParserCSVException {
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
				if(elements[10].trim().isEmpty()) {
					location[0] = 0; 
				}else {
					location[0] = Double.parseDouble(elements[10]);
				}
				if(elements[11].trim().isEmpty()) {
					location[1] = 0;
				}else {
					location[1] = Double.parseDouble(elements[11]);
				}

				Edicola e = new Edicola (
						counter.incrementAndGet(),
						elements[0].replace("/","-").isEmpty() ? "codiceNonIdentificato"+counter.incrementAndGet() : elements[0].replace("/","-"),
						elements[1].trim().isEmpty() ? "ubicazioneNonIdentificata" : elements[1],
						elements[2].trim().isEmpty() ? "areaDiCompetenzaNonIdentificata" : elements[2],
						elements[3].trim().isEmpty() ? "descrizioneViaNonIdentificata" : elements[3],
						elements[4].trim().isEmpty() ? "civicoNonIdentificato" : elements[4].trim(),
						elements[5].trim().isEmpty() ? 0 : Integer.parseInt(elements[5]),
						elements[6].trim().isEmpty() ? "localita'NonIdentificata" : elements[6].trim(),
						elements[7].replace(" ", "").trim().isEmpty() ? "FormaVenditaNonIdentifica" : elements[7].replace(" ", "").trim(),
						elements[8].trim().contains("S") ? true : false,
						elements[9].trim().isEmpty() ?	0 : Integer.parseInt(elements[9]),
						elements[10].trim().isEmpty()? 0.0 : Double.parseDouble(elements[10]),
						elements[11].trim().isEmpty()? 0.0 : Double.parseDouble(elements[11]),
						location);
				edicole.add(e);	
			}
		}
		System.out.println("rowsYes : "+rowsYes+" rowsNo : "+rowsNo);
		setEdicole(edicole);
	}
	
	/**
	 * Questo metodo ci permette di scaricare il file dal web e memorizzarlo all'interno della nostra macchina
	 * @param urlStr l'indirizzo url da dove scaricare il json
	 * @param file il nome del file dove memorizzare il contenuto scaricato
	 */

	protected void download(String urlStr, String file) {
		try {
			FileWriter fW =new FileWriter(file);
			BufferedWriter bW =new BufferedWriter (fW);
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			FileOutputStream fis = new FileOutputStream(file);
			String line = read.readLine();
			while(line!=null) {
				bW.write(line);
				line = read.readLine();
				bW.flush();
			}
			fis.close();
			read.close();
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}

	}
	/**
	 * 
	 * @param urlStr l'url del sito web del file csv 
	 * @param file il nome del file su cui salvare l'output
	 * @throws IOException dovuto alla lettura/scrittura del file
	 */
	protected void downloadCSV(String urlStr, String file) throws IOException{
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[2048];
		int count=0;
		while((count = bis.read(buffer,0,2048)) != -1){
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
	}
}
