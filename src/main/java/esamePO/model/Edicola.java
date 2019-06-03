package esamePO.model;

import java.util.Arrays;

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
			int codiceVia, String localita, String formaVenditaEdicole, boolean venditaEsclusiva, int municipio,
			float lONGIT, float lATIT, float[] location) {
		super();
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

	@Override
	public String toString() {
		return "Edicola [Codice=" + Codice + ", Ubicazione=" + Ubicazione + ", AreaDiCompetenza=" + AreaDiCompetenza
				+ ", DescrizioneVia=" + DescrizioneVia + ", Civico=" + Civico + ", CodiceVia=" + CodiceVia
				+ ", Localita=" + Localita + ", FormaVenditaEdicole=" + FormaVenditaEdicole + ", VenditaEsclusiva="
				+ VenditaEsclusiva + ", Municipio=" + Municipio + ", LONGIT=" + LONGIT + ", LATIT=" + LATIT
				+ ", Location=" + Arrays.toString(Location) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AreaDiCompetenza == null) ? 0 : AreaDiCompetenza.hashCode());
		result = prime * result + Civico;
		result = prime * result + ((Codice == null) ? 0 : Codice.hashCode());
		result = prime * result + CodiceVia;
		result = prime * result + ((DescrizioneVia == null) ? 0 : DescrizioneVia.hashCode());
		result = prime * result + ((FormaVenditaEdicole == null) ? 0 : FormaVenditaEdicole.hashCode());
		result = prime * result + Float.floatToIntBits(LATIT);
		result = prime * result + Float.floatToIntBits(LONGIT);
		result = prime * result + ((Localita == null) ? 0 : Localita.hashCode());
		result = prime * result + Arrays.hashCode(Location);
		result = prime * result + Municipio;
		result = prime * result + ((Ubicazione == null) ? 0 : Ubicazione.hashCode());
		result = prime * result + (VenditaEsclusiva ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edicola other = (Edicola) obj;
		if (AreaDiCompetenza == null) {
			if (other.AreaDiCompetenza != null)
				return false;
		} else if (!AreaDiCompetenza.equals(other.AreaDiCompetenza))
			return false;
		if (Civico != other.Civico)
			return false;
		if (Codice == null) {
			if (other.Codice != null)
				return false;
		} else if (!Codice.equals(other.Codice))
			return false;
		if (CodiceVia != other.CodiceVia)
			return false;
		if (DescrizioneVia == null) {
			if (other.DescrizioneVia != null)
				return false;
		} else if (!DescrizioneVia.equals(other.DescrizioneVia))
			return false;
		if (FormaVenditaEdicole == null) {
			if (other.FormaVenditaEdicole != null)
				return false;
		} else if (!FormaVenditaEdicole.equals(other.FormaVenditaEdicole))
			return false;
		if (Float.floatToIntBits(LATIT) != Float.floatToIntBits(other.LATIT))
			return false;
		if (Float.floatToIntBits(LONGIT) != Float.floatToIntBits(other.LONGIT))
			return false;
		if (Localita == null) {
			if (other.Localita != null)
				return false;
		} else if (!Localita.equals(other.Localita))
			return false;
		if (!Arrays.equals(Location, other.Location))
			return false;
		if (Municipio != other.Municipio)
			return false;
		if (Ubicazione == null) {
			if (other.Ubicazione != null)
				return false;
		} else if (!Ubicazione.equals(other.Ubicazione))
			return false;
		if (VenditaEsclusiva != other.VenditaEsclusiva)
			return false;
		return true;
	}
	
	
}
