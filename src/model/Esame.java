package model;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Esame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEsame;
	@OneToOne
	private Paziente paziente;

	private Date dataPrenotazione;
	
	private Date dataEsame;
	@OneToOne (optional=true)
	private Medico medico;
	@OneToOne
	private TipologiaEsame tipologiaEsame;

	@OneToMany(mappedBy="esame")
 
	private List<RigaEsame> risultati;
	
	
	
	public Esame(Paziente paziente, Date dataPrenotazione, Medico medico, TipologiaEsame tipologiaEsame,Date dataEsame,List<RigaEsame> risultati) {
		this.paziente = paziente;
		this.dataPrenotazione = dataPrenotazione;
		this.medico = medico;
		this.tipologiaEsame = tipologiaEsame;
		this.dataEsame=dataEsame;
		this.risultati=risultati;
	}
	
	
	
	public Esame(Paziente paziente, Date dataPrenotazione, TipologiaEsame tipologiaEsame) {
		this.paziente = paziente;
		this.dataPrenotazione = dataPrenotazione;
		this.tipologiaEsame = tipologiaEsame;
	}



	public Esame() {}

	public Esame(TipologiaEsame tipologiaEsame2, Paziente paziente2) {
		this.tipologiaEsame=tipologiaEsame2;
		this.paziente=paziente2;
		this.dataPrenotazione=new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}


	public boolean effettuato(){
		return this.dataEsame!=null;
	}
	
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public Date getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}
	public List<RigaEsame> getRisultati() {
		return risultati;
	}
	public void setRisultati(List<RigaEsame> risultati) {
		this.risultati = risultati;
	}



	public Long getIdEsame() {
		return idEsame;
	}



	public void setIdEsame(Long idEsame) {
		this.idEsame = idEsame;
	}

	@Override
	public String toString() {
		return "Esame [idEsame=" + idEsame + ", paziente=" + paziente + ", dataPrenotazione=" + dataPrenotazione
				+ ", dataEsame=" + dataEsame + ", medico=" + medico + ", tipologiaEsame=" + tipologiaEsame
				+ ", risultati=" + risultati + "]";
	}
}
