package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Esame;
import model.Medico;
import model.MedicoFacade;
import model.TipologiaEsame;
import model.TipologiaEsameFacade;

@ManagedBean
@SessionScoped
public class MedicoController {

	private String idMedico;
	private Medico medico;
	private List<Medico> medici;

	private List<Esame> esamiEffettuati;
	@EJB(beanName = "medicoFacade")
	private MedicoFacade medicoFacade;

	@PostConstruct
    public void init(){
        this.setMedici(this.medicoFacade.visualizzaMedici());
    }

	public String visualizzaEsami(){
		this.medico=this.medicoFacade.getMedicoById(this.idMedico);
		this.setEsamiEffettuati(this.medicoFacade.getEsamiEffettuati(medico));
		return "visualizzazioneEsamiMedico";
	}
	public List<Medico> getMedici() {
		return medici;
	}

	public void setMedici(List<Medico> medici) {
		this.medici = medici;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public List<Esame> getEsamiEffettuati() {
		return esamiEffettuati;
	}

	public void setEsamiEffettuati(List<Esame> esamiEffettuati) {
		this.esamiEffettuati = esamiEffettuati;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
}
