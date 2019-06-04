package esamePO.springboot.model;

import java.util.Arrays;

public class Edicola {
	private int id ; 
	private String Codice;
	private String Ubicazione;
	private String AreaDiCompetenza;
	private String DescrizioneVia;
	private int Civico;
	private int CodiceVia;
	private String Localita;
	private String FormaVenditaEdicole;
	private boolean VenditaEsclusiva;
	private int Municipio;
	private double LONGIT;
	private double LATIT;
	private Double[] Location;
	
	
	

	public Edicola(int id, String codice, String ubicazione, String areaDiCompetenza, String descrizioneVia, int civico,
			int codiceVia, String localita, String formaVenditaEdicole, boolean venditaEsclusiva, int municipio,
			double lONGIT, double lATIT, Double[] location2) {
		super();
		this.id = id;
		this.Codice = codice;
		this.Ubicazione = ubicazione;
		this.AreaDiCompetenza = areaDiCompetenza;
		this.DescrizioneVia = descrizioneVia;
		this.Civico = civico;
		this.CodiceVia = codiceVia;
		this.Localita = localita;
		this.FormaVenditaEdicole = formaVenditaEdicole;
		this.VenditaEsclusiva = venditaEsclusiva;
		this.Municipio = municipio;
		this.LONGIT = lONGIT;
		this.LATIT = lATIT;
		this.Location = location2;
	}
	
	public Edicola(int id) {
		super();
		this.id= id; 
		this.Codice = "AA";
		this.Ubicazione = "Via Rossi ";
		this.AreaDiCompetenza = "3";
		this.DescrizioneVia = "MIlano";
		this.Civico = 454;
		this.CodiceVia = 2;
		this.Localita = "Milano";
		this.FormaVenditaEdicole = "riservata";
		this.VenditaEsclusiva = true;
		this.Municipio = 3;
		this.LONGIT = 0.000;
		this.LATIT = 0.1000;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodice() {
		return Codice;
	}

	public void setCodice(String codice) {
		Codice = codice;
	}

	public String getUbicazione() {
		return Ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		Ubicazione = ubicazione;
	}

	public String getAreaDiCompetenza() {
		return AreaDiCompetenza;
	}

	public void setAreaDiCompetenza(String areaDiCompetenza) {
		AreaDiCompetenza = areaDiCompetenza;
	}

	public String getDescrizioneVia() {
		return DescrizioneVia;
	}

	public void setDescrizioneVia(String descrizioneVia) {
		DescrizioneVia = descrizioneVia;
	}

	public int getCivico() {
		return Civico;
	}

	public void setCivico(int civico) {
		Civico = civico;
	}

	public int getCodiceVia() {
		return CodiceVia;
	}

	public void setCodiceVia(int codiceVia) {
		CodiceVia = codiceVia;
	}

	public String getLocalita() {
		return Localita;
	}

	public void setLocalita(String localita) {
		Localita = localita;
	}

	public String getFormaVenditaEdicole() {
		return FormaVenditaEdicole;
	}

	public void setFormaVenditaEdicole(String formaVenditaEdicole) {
		FormaVenditaEdicole = formaVenditaEdicole;
	}

	public boolean isVenditaEsclusiva() {
		return VenditaEsclusiva;
	}

	public void setVenditaEsclusiva(boolean venditaEsclusiva) {
		VenditaEsclusiva = venditaEsclusiva;
	}

	public int getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(int municipio) {
		Municipio = municipio;
	}

	public double getLONGIT() {
		return LONGIT;
	}

	public void setLONGIT(double lONGIT) {
		LONGIT = lONGIT;
	}

	public double getLATIT() {
		return LATIT;
	}

	public void setLATIT(double lATIT) {
		LATIT = lATIT;
	}

	public Double[] getLocation() {
		return Location;
	}

	public void setLocation(Double[] location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "Edicola [id=" + id + ", Codice=" + Codice + ", Ubicazione=" + Ubicazione + ", AreaDiCompetenza="
				+ AreaDiCompetenza + ", DescrizioneVia=" + DescrizioneVia + ", Civico=" + Civico + ", CodiceVia="
				+ CodiceVia + ", Localita=" + Localita + ", FormaVenditaEdicole=" + FormaVenditaEdicole
				+ ", VenditaEsclusiva=" + VenditaEsclusiva + ", Municipio=" + Municipio + ", LONGIT=" + LONGIT
				+ ", LATIT=" + LATIT + ", Location=" + Arrays.toString(Location) + "]";
	}
	
	


	
	
	
}
