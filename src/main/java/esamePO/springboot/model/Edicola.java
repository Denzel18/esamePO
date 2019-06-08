package esamePO.springboot.model;

import java.util.Arrays;

public class Edicola {
	private long id ; 
	private String Codice;
	private String Ubicazione;
	private String AreaDiCompetenza;
	private String DescrizioneVia;
	private String Civico;
	private int CodiceVia;
	private String Localita;
	private String FormaVenditaEdicole;
	private boolean VenditaEsclusiva;
	private int Municipio;
	private double LONGIT;
	private double LATIT;
	private double[] location;
	
	
	

	public Edicola(long id, String codice, String ubicazione, String areaDiCompetenza, String descrizioneVia, String civico,
			int codiceVia, String localita, String formaVenditaEdicole, boolean venditaEsclusiva, int municipio,
			double lONGIT, double lATIT, double[] location) {
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
		this.location = location;
	}
	
	public Edicola(long id) {
		super();
		this.id= id; 
		this.Codice = "AA";
		this.Ubicazione = "Via Rossi ";
		this.AreaDiCompetenza = "3";
		this.DescrizioneVia = "MIlano";
		this.Civico = "454";
		this.CodiceVia = 2;
		this.Localita = "Milano";
		this.FormaVenditaEdicole = "riservata";
		this.VenditaEsclusiva = true;
		this.Municipio = 3;
		this.LONGIT = (double) 0.00000000;
		this.LATIT =  (double) 0.22200000;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getCivico() {
		return Civico;
	}

	public void setCivico(String civico) {
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

	public void setLONGIT(long lONGIT) {
		LONGIT = lONGIT;
	}

	public double getLATIT() {
		return LATIT;
	}

	public void setLATIT(double lATIT) {
		LATIT = lATIT;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Edicola [id=" + id + ", Codice=" + Codice + ", Ubicazione=" + Ubicazione + ", AreaDiCompetenza="
				+ AreaDiCompetenza + ", DescrizioneVia=" + DescrizioneVia + ", Civico=" + Civico + ", CodiceVia="
				+ CodiceVia + ", Localita=" + Localita + ", FormaVenditaEdicole=" + FormaVenditaEdicole
				+ ", VenditaEsclusiva=" + VenditaEsclusiva + ", Municipio=" + Municipio + ", LONGIT=" + LONGIT
				+ ", LATIT=" + LATIT + ", Location=" + Arrays.toString(location) + "]"+"\n";
	}
	
	


	
	
	
}
