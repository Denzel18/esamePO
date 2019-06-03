package esamePO.model;

public class Edicola {
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
	private float LONGIT;
	private float LATIT;
	private float [] Location;
	
	
	
	public Edicola(String codice, String ubicazione, String areaDiCompetenza, String descrizioneVia, int civico,
			int codiceVia, String localita, String forma_vendita_edicole, boolean vendita_esclusiva, int Municipio,
			float lONGIT, float lATIT, float[] location) {
		super();
		this.Codice = codice;
		this.Ubicazione = ubicazione;
		this.AreaDiCompetenza = areaDiCompetenza;
		this.DescrizioneVia = descrizioneVia;
		this.Civico = civico;
		this.CodiceVia = codiceVia;
		this.Localita = localita;
		this.FormaVenditaEdicole = forma_vendita_edicole;
		this.VenditaEsclusiva = vendita_esclusiva;
		this.Municipio = Municipio;
		this.LONGIT = lONGIT;
		this.LATIT = lATIT;
		this.Location = location;
	}
	
	protected String getCodice() {
		return Codice;
	}
	protected void setCodice(String codice) {
		Codice = codice;
	}
	protected String getUbicazione() {
		return Ubicazione;
	}
	protected void setUbicazione(String ubicazione) {
		Ubicazione = ubicazione;
	}
	protected String getAreaDiCompetenza() {
		return AreaDiCompetenza;
	}
	protected void setAreaDiCompetenza(String areaDiCompetenza) {
		AreaDiCompetenza = areaDiCompetenza;
	}
	protected String getDescrizioneVia() {
		return DescrizioneVia;
	}
	protected void setDescrizioneVia(String descrizioneVia) {
		DescrizioneVia = descrizioneVia;
	}
	protected int getCivico() {
		return Civico;
	}
	protected void setCivico(int civico) {
		Civico = civico;
	}
	protected int getCodiceVia() {
		return CodiceVia;
	}
	protected void setCodiceVia(int codiceVia) {
		CodiceVia = codiceVia;
	}
	protected String getLocalita() {
		return Localita;
	}
	protected void setLocalita(String localita) {
		Localita = localita;
	}
	protected String getForma_vendita_edicole() {
		return FormaVenditaEdicole;
	}
	protected void setForma_vendita_edicole(String forma_vendita_edicole) {
		this.FormaVenditaEdicole = forma_vendita_edicole;
	}
	protected boolean isVendita_esclusiva() {
		return VenditaEsclusiva;
	}
	protected void setVendita_esclusiva(boolean vendita_esclusiva) {
		this.VenditaEsclusiva = vendita_esclusiva;
	}
	protected int getMUNICIPIO() {
		return Municipio;
	}
	protected void setMUNICIPIO(int mUNICIPIO) {
		this.Municipio = mUNICIPIO;
	}
	protected float getLONGIT() {
		return LONGIT;
	}
	protected void setLONGIT(float lONGIT) {
		LONGIT = lONGIT;
	}
	protected float getLATIT() {
		return LATIT;
	}
	protected void setLATIT(float lATIT) {
		LATIT = lATIT;
	}
	protected float[] getLocation() {
		return Location;
	}
	protected void setLocation(float[] location) {
		Location = location;
	}
	
	
	

}
