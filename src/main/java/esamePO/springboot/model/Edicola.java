package esamePO.springboot.model;

import java.util.Arrays;

/**
 * 	Questa classe definisce il modello del entita' con cui la nosta applicazione interagisce
 * 	@author denis bernovschi
 *	@version 1.5
 */
public class Edicola {
	private long id ; 
	private String codice;
	private String ubicazione;
	private String areaDiCompetenza;
	private String descrizioneVia;
	private String civico;
	private int codiceVia;
	private String localita;
	private String formaVenditaEdicole;
	private boolean venditaEsclusiva;
	private int municipio;
	private double LONGIT;
	private double LATIT;
	private double[] location;


	/**
	 * Questo è il 1° costruttore, ci permette di istanziare la nostra edicola
	 * 
	 * @param id codice numerico per identificare l'oggetto edicola
	 * @param codice codice alfanumerico, sotto forma di stringa 
	 * @param ubicazione rappresenta l'ubicazione della nostra entità 
	 * @param areaDiCompetenza rappresenta l'area di competenza della nostra entità 
	 * @param descrizioneVia rappresenta il nome della via della nostra entità 
	 * @param civico rappresenta il numero civico della nostra entità, sotto forma di stringa
	 * @param codiceVia rappresenta un codice numerico associato alla nostra via
	 * @param localita rappresenta la localita' della nostra entità 
	 * @param formaVenditaEdicole rappresenta il tipo di forma di vendita della nostra entità 
	 * @param venditaEsclusiva rappresenta la possibilità della nostra entità di avere la vendita esclusiva 
	 * @param municipio rappresenta il codice del municipio della nostra entità 
	 * @param lONGIT rappresenta la coordinata LONG della nostra entità 
	 * @param lATIT rappresenta la coordinata LATT della nostra entità 
	 * @param location rappresenta le coordinate LATT e LONG della nostra entità sotto forma di array
	 */

	public Edicola(long id, String codice, String ubicazione, String areaDiCompetenza, String descrizioneVia, String civico,
			int codiceVia, String localita, String formaVenditaEdicole, boolean venditaEsclusiva, int municipio,
			double lONGIT, double lATIT, double[] location) {
		super();
		this.id = id;
		this.codice = codice;
		this.ubicazione = ubicazione;
		this.areaDiCompetenza = areaDiCompetenza;
		this.descrizioneVia = descrizioneVia;
		this.civico = civico;
		this.codiceVia = codiceVia;
		this.localita = localita;
		this.formaVenditaEdicole = formaVenditaEdicole;
		this.venditaEsclusiva = venditaEsclusiva;
		this.municipio = municipio;
		this.LONGIT = lONGIT;
		this.LATIT = lATIT;
		this.location = location;
	}

	/**
	 * Questo è il 2° costruttore, ci permette di creare un'edicola di base con valori di default 
	 * @param id l'id associato all'edicola da istanziare
	 */
	public Edicola(long id) {
		super();
		this.id= id; 
		this.codice = "AA";
		this.ubicazione = "Via Rossi ";
		this.areaDiCompetenza = "3";
		this.descrizioneVia = "MIlano";
		this.civico = "454";
		this.codiceVia = 2;
		this.localita = "Milano";
		this.formaVenditaEdicole = "riservata";
		this.venditaEsclusiva = true;
		this.municipio = 3;
		this.LONGIT = (double) 0.00000000;
		this.LATIT =  (double) 0.22200000;
	}
	/**
	 * Questo è il 3° costruttore, il cosidetto costruttore di coppia
	 * @param a è l'edicola che passo per instanziare un'altra con le stesse caratteristiche
	 */

	public Edicola(Edicola a) {
		super();
		this.id = a.id;
		this.codice = a.getCodice();
		this.ubicazione = a.getUbicazione();
		this.areaDiCompetenza = a.getAreaDiCompetenza();
		this.descrizioneVia = a.getDescrizioneVia();
		this.civico = a.getCivico();
		this.codiceVia = a.getCodiceVia();
		this.localita = a.getLocalita();
		this.formaVenditaEdicole = a.getFormaVenditaEdicole();
		this.venditaEsclusiva = a.isVenditaEsclusiva();
		this.municipio = a.getMunicipio();
		this.LONGIT = a.getLONGIT();
		this.LATIT = a.getLATIT();
		this.location = a.getLocation();
	}

	/**
	 * 
	 * @return id il codice numerico associato al oggetto edicola
	 */
	public long getId() {
		return this.id;
	}
	/**
	 * 
	 * @param id l'id con cui valorizzare l'edicola 
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return codice il codice alfanumerico associato al oggetto edicola
	 */
	public String getCodice() {
		return this.codice;
	}
	/**
	 *
	 * @param codice il codice con cui valorizzare l'edicola
	 */

	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * 
	 * @return ubicazione l'ubicazione dell'oggetto edicola
	 */
	public String getUbicazione() {
		return this.ubicazione;
	}
	/**
	 * 
	 * @param ubicazione l'ubicazione con cui valorizzare l'edicola
	 */
	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}
	/**
	 * 
	 * @return areaDiCompetenza l'area di competenza dell'oggetto edicola
	 */
	public String getAreaDiCompetenza() {
		return this.areaDiCompetenza;
	}
	/**
	 * 
	 * @param areaDiCompetenza l'area di competenza con cui valorizzare l'edicola
	 */
	public void setAreaDiCompetenza(String areaDiCompetenza) {
		this.areaDiCompetenza = areaDiCompetenza;
	}

	/**
	 * 
	 * @return descrizioneVia la descrizione della via dell'oggetto edicola
	 */
	public String getDescrizioneVia() {
		return this.descrizioneVia;
	}
	/**
	 * 
	 * @param descrizioneVia la descrizione della via con cui valorizzare l'oggetto edicola
	 */
	public void setDescrizioneVia(String descrizioneVia) {
		this.descrizioneVia = descrizioneVia;
	}

	/**
	 * 
	 * @return civico il civico dell'oggetto edicola 
	 */
	public String getCivico() {
		return this.civico;
	}
	/**
	 * 
	 * @param civico il civico con cui valorizzare l'oggetto edicola 
	 */
	public void setCivico(String civico) {
		this.civico = civico;
	}

	/**
	 * 
	 * @return codiceVia il codice via dell'oggetto edicola 
	 */
	public int getCodiceVia() {
		return this.codiceVia;
	}

	/**
	 * 
	 * @param codiceVia il codice via con cui valorizzare l'oggetto edicola
	 */
	public void setCodiceVia(int codiceVia) {
		this.codiceVia = codiceVia;
	}

	/**
	 * 
	 * @return localita la località dell'oggetto edicola
	 */
	public String getLocalita() {
		return this.localita;
	}
	/**
	 * 
	 * @param localita la localita con cui valorizzare l'oggetto edicola
	 */
	public void setLocalita(String localita) {
		this.localita = localita;
	}

	/**
	 * 
	 * @return formaVenditaEdicole la forma di vendita dell'oggetto edicola
	 */
	public String getFormaVenditaEdicole() {
		return this.formaVenditaEdicole;
	}
	/**
	 * 
	 * @param formaVenditaEdicole la forma di vendita con cui valorizzare l'oggetto edicola
	 */
	public void setFormaVenditaEdicole(String formaVenditaEdicole) {
		this.formaVenditaEdicole = formaVenditaEdicole;
	}

	/**
	 * 
	 * @return venditaEsclusiva la possibilità di vendita esclusiva o meno dell'oggetto edicola
	 */
	public boolean isVenditaEsclusiva() {
		return this.venditaEsclusiva;
	}
	/**
	 * 
	 * @param venditaEsclusiva la possibilità di vendita esclusiva o meno con cui valorizzare dell'oggetto edicola
	 */
	public void setVenditaEsclusiva(boolean venditaEsclusiva) {
		this.venditaEsclusiva = venditaEsclusiva;
	}
	/**
	 * 
	 * @return municipio il municipio associato all'oggetto edicola
	 */
	public int getMunicipio() {
		return this.municipio;
	}
	/**
	 * 
	 * @param municipio il municipio con cui valorizzare l'oggetto edicola
	 */
	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	/**
	 * 
	 * @return LONGIT la coordinata LONG dell'oggetto edicola
	 */
	public double getLONGIT() {
		return this.LONGIT;
	}
	/**
	 * 
	 * @param lONGIT la coordinata LONG con cui valorizzare l'oggetto edicola
	 */
	public void setLONGIT(long lONGIT) {
		this.LONGIT = lONGIT;
	}
	/**
	 * 
	 * @return LATIT la coordinata LATT dell'oggetto edicola
	 */
	public double getLATIT() {
		return this.LATIT;
	}
	/**
	 * 
	 * @param lATIT la coordinata LATT con cui valorizzare l'oggetto edicola
	 */
	public void setLATIT(double lATIT) {
		this.LATIT = lATIT;
	}
	/**
	 * 
	 * @return location l'array delle coordinate dell'oggetto edicola 
	 */
	public double[] getLocation() {
		return this.location;
	}
	/**
	 * 
	 * @param location l'array di coordinate con cui valorizzare l'oggetto edicola
	 */
	public void setLocation(double[] location) {
		this.location = location;
	}

	/**
	 * Restituisce tutte le informazioni dell'edicola sotto forma di stringa
	 */
	public String toString() {
		return "Edicola [id=" + this.id + 
				", Codice=" + this.codice +
				", Ubicazione=" + this.ubicazione +
				", AreaDiCompetenza=" + this.areaDiCompetenza +
				", DescrizioneVia=" + this.descrizioneVia +
				", Civico=" + this.civico +
				", CodiceVia="+ this.codiceVia +
				", Localita=" + this.localita +
				", FormaVenditaEdicole=" + this.formaVenditaEdicole
				+ ", VenditaEsclusiva=" + this.venditaEsclusiva +
				", Municipio=" + this.municipio + ", LONGIT=" + LONGIT
				+ ", LATIT=" + LATIT + ", Location=" + Arrays.toString(location) + "]"+"\n";
	}
	/**
	 *  Restituisce l'hash code associato all'oggetto
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(LATIT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(LONGIT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((areaDiCompetenza == null) ? 0 : areaDiCompetenza.hashCode());
		result = prime * result + ((civico == null) ? 0 : civico.hashCode());
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result + codiceVia;
		result = prime * result + ((descrizioneVia == null) ? 0 : descrizioneVia.hashCode());
		result = prime * result + ((formaVenditaEdicole == null) ? 0 : formaVenditaEdicole.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((localita == null) ? 0 : localita.hashCode());
		result = prime * result + Arrays.hashCode(location);
		result = prime * result + municipio;
		result = prime * result + ((ubicazione == null) ? 0 : ubicazione.hashCode());
		result = prime * result + (venditaEsclusiva ? 1231 : 1237);
		return result;
	}
	/**
	 * Ci permette di verificare se due oggetti sono uguali
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edicola other = (Edicola) obj;
		if (Double.doubleToLongBits(LATIT) != Double.doubleToLongBits(other.LATIT))
			return false;
		if (Double.doubleToLongBits(LONGIT) != Double.doubleToLongBits(other.LONGIT))
			return false;
		if (areaDiCompetenza == null) {
			if (other.areaDiCompetenza != null)
				return false;
		} else if (!areaDiCompetenza.equals(other.areaDiCompetenza))
			return false;
		if (civico == null) {
			if (other.civico != null)
				return false;
		} else if (!civico.equals(other.civico))
			return false;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (codiceVia != other.codiceVia)
			return false;
		if (descrizioneVia == null) {
			if (other.descrizioneVia != null)
				return false;
		} else if (!descrizioneVia.equals(other.descrizioneVia))
			return false;
		if (formaVenditaEdicole == null) {
			if (other.formaVenditaEdicole != null)
				return false;
		} else if (!formaVenditaEdicole.equals(other.formaVenditaEdicole))
			return false;
		if (id != other.id)
			return false;
		if (localita == null) {
			if (other.localita != null)
				return false;
		} else if (!localita.equals(other.localita))
			return false;
		if (!Arrays.equals(location, other.location))
			return false;
		if (municipio != other.municipio)
			return false;
		if (ubicazione == null) {
			if (other.ubicazione != null)
				return false;
		} else if (!ubicazione.equals(other.ubicazione))
			return false;
		if (venditaEsclusiva != other.venditaEsclusiva)
			return false;
		return true;
	}









}
