package controller;

import model.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@ManagedBean
@SessionScoped
public class EsameController {

	private String idEsame;
	private String dataEsame;
	private String dataPrenotazione;
	private Medico medico;
	private Paziente paziente;
	private TipologiaEsame tipologiaEsame;

	private List<Esame> esami;
	
	private Esame esame;
	private List<TipologiaEsame> tipologie;
	
	private List<RigaEsame> risultati;
	private String codiceTipologia;
	private Long idPaziente;

	@EJB(beanName = "esamefacade")
	private EsameFacade esameFacade ;

	@EJB(beanName = "tipologiafacade")
	private TipologiaEsameFacade tipologieFacade;

	@EJB(beanName = "utentefacade")
	private UtenteFacade utenteFacade;
	
	@EJB(beanName = "rigaEsameFacade")
	private RigaEsameFacade rigaEsameFacade;
	
	@PostConstruct
    public void init(){
        this.esami=this.esameFacade.getAllEsami();
    }
	
	public String getAllEsami(){
		this.esami=this.esameFacade.getAllEsami();
		return "visualizzaEsami";
	}
	public void loadAllEsami(){
		this.esami=this.esameFacade.getAllEsami();
	}
	
	public String visualizzaEsame(Esame e){

		this.setEsame(e);
		System.out.println(e);

		return "visualizzaEsame";
	}
	public String getEsamiDiUnPaziente(){
		this.paziente=(Paziente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("paziente");
		this.esami=this.esameFacade.getEsamiByPaziente(paziente);
		return "visualizzaRisultatiEsame";
	}
	
	public String visualizzaRisultati(Esame e){
		this.paziente=(Paziente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("paziente");
		this.risultati=this.rigaEsameFacade.getRisultati(e);
		return "visualizzazioneRisultati";
	}
	
	public String createEsame(){
		try {
			System.out.println(codiceTipologia);
			
			TipologiaEsame tipologiaEsame= tipologieFacade.getTipologiaByID(this.codiceTipologia);
			System.out.println(tipologiaEsame);
			
			System.out.println(idPaziente);
			
			Paziente paziente= utenteFacade.getPazienteByID(this.idPaziente);
			System.out.println(paziente);
			
			this.esame=this.esameFacade.createEsame(tipologiaEsame,paziente);
			this.loadAllEsami();

		} catch (Exception e) {
			// TODO: handle exception
			return "nuovoEsameFail";
		}

		return "nuovoEsameSuccess";
	}


	public String getIdEsame() {
		return idEsame;
	}


	public String getDataEsame() {
		return dataEsame;
	}


	public String getDataPrenotazione() {
		return dataPrenotazione;
	}


	public Medico getMedico() {
		return medico;
	}


	public Paziente getPaziente() {
		return paziente;
	}


	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}


	public Esame getEsame() {
		return esame;
	}


	public List<TipologiaEsame> getTipologie() {
		return tipologie;
	}


	public EsameFacade getEsameFacade() {
		return esameFacade;
	}


	public void setIdEsame(String idEsame) {
		this.idEsame = idEsame;
	}


	public void setDataEsame(String dataEsame) {
		this.dataEsame = dataEsame;
	}


	public void setDataPrenotazione(String dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}


	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}


	public void setEsame(Esame esame) {
		this.esame = esame;
	}


	public void setTipologie(List<TipologiaEsame> tipologie) {
		this.tipologie = tipologie;
	}


	public void setEsameFacade(EsameFacade esameFacade) {
		this.esameFacade = esameFacade;
	}


	public String getCodiceTipologia() {
		return codiceTipologia;
	}


	public Long getIdPaziente() {
		return idPaziente;
	}


	public void setCodiceTipologia(String codiceTipologia) {
		this.codiceTipologia = codiceTipologia;
	}


	public void setIdPaziente(Long idPaziente) {
		this.idPaziente = idPaziente;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public List<RigaEsame> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<RigaEsame> risultati) {
		this.risultati = risultati;
	}



}
