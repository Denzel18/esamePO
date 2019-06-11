# Esame Programmazione Oggetti

Questo repository contiene il progetto del corso di programmazione oggetti  

## Tecnologia di sviluppo 

Il progetto è stato sviluppo con il supporto dell'ausilio del framework Spring, al fine di realizzare un applicazione Rest 

## Supporto tecnologie 

Ho sviluppato il progetto grazie a diversi software : 
- Github : Per il versioning dell'applicazione
- Eclipse : Per lo sviluppo dell'applicazione, con il plug-in di "e-git" 
- Brackets : Per la scrittura del file README.md grazie all'ausilio del plug-in   MarkDown 

## Packaging 

L'applicazione è composta da 5 package ognuno di essi con una propria funzionalità.

1. package **esamePO.springboot** contiene il main dell'applicazione.
2. package **esamePO.springboot.controller** ha al suo interno la classe _RestApiController.java_ dedita appunto all'interazione del utente finale con l'applicazione attraverso metodi mappati tramite @RequestMapping. 
3. **esamePO.springboot.model** al suo interno vi sono due classi : _Edicola.java_, _Response.java_ , la prima è il modello o meglio l'entità che mi permette di rappresentare le informazioni recuparate dal ***file.csv*** la seconda l'ho definita al fine di avere un'entità 'Risposta' con cui comunicare all'utente il risultato del operazione da lui richiesta.   
4. **esamePO.springboot.service** lui contiene tutte le classi che ci permettono poi di lavorare con l'applicazione in particolare voi far notare che al suo interno sono contenute classi come _EdicolaServiceImplements.java_  che è legata con l'interfaccia _EdicolaService.java_, la classe relativa ai vari Parser (java + json) _Parser.java_ ed infine ho definito un nuovo tipo di eccezione _ParserCSVException.java_ utile ad riportare le eccezioni di parse __csv__ ||| (MODIFICA CODICE)
5. **esamePO.springboot.util** che contiene una classe dedita a riporta all'utente gli eventuali errori 

## Parti di codice rilevanti

### Main dell'applicazione 
`````
/**
 * Questa classe è il main della nostra applicazione, l'applicazione sviluppata grazione al framework Spring.
 * E qui che avviene l'avvio dell'applicazione
 * @author denis bernovschi
 */
package esamePO.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={"esamePO.springboot"})
public class EsamePOApp {
	public static void main(String[] args) {
		SpringApplication.run(EsamePOApp.class, args);
	}
}
`````
### Controller
##### Esempio di una funzione del controller 
`````
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
`````

### Model 
##### Edicola 
`````
package esamePO.springboot.model;
import java.util.Arrays;
public class Edicola {
    ---
}
`````
##### Response  
`````
package esamePO.springboot.model;
public class Response {

	private String message; 
	private String info;
`````
##### Parser
###### Parser JSON 
`````
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

`````
###### Parser JSON
`````
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
`````

Precisazione la porzione di codice sottostante popola un'array list del tipo **Edicola** 
````` 
setEdicole(edicole); 
`````

###### download JSON 
`````
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
`````

###### Download CSV 
`````
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
`````




