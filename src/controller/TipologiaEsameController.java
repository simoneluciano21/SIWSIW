package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.TipologiaEsame;
import model.TipologiaEsameFacade;

@ManagedBean
@SessionScoped
public class TipologiaEsameController {

	private String codiceTipologia;
	private String nomeTipologia;
	private String descrizione;
	private String costo;
	private String prerequisiti;
	private TipologiaEsame tipologiaEsame;

	private List<TipologiaEsame> tipologie;

	@EJB(beanName = "tipologiafacade")
	private TipologiaEsameFacade tipologieFacade;

	@PostConstruct
    public void init(){
        this.tipologie=this.tipologieFacade.visualizzaTipologie();
    }
	public String createTipologiaEsame(){
		try {
			this.tipologiaEsame=this.tipologieFacade.createTipologiaEsame(codiceTipologia,nomeTipologia,descrizione,costo,prerequisiti);

		} catch (Exception e) {
			// TODO: handle exception
			return "nuovaTipologiaFail";
		}

		return "nuovaTipologiaSuccess";
	}

	public String visualizzaTipologie(){
		this.setTipologie(this.tipologieFacade.visualizzaTipologie());
		return "visualizzaTipologie";
	}

	public String visualizzaTipologia(){
		String t=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("myParam");
		System.out.println(t);
		for(TipologiaEsame tipologiaEsame :tipologie)
			if(tipologiaEsame.getCodiceTipologia().equals(t)){
				this.setTipologiaEsame(tipologiaEsame);
				System.out.println(tipologiaEsame);
			}
		return "visualizzaTipologia";
	}
	public String visualizza(TipologiaEsame t){

		this.setTipologiaEsame(t);
		System.out.println(tipologiaEsame);

		return "visualizzaTipologia";
	}


	public String getCodiceTipologia() {
		return codiceTipologia;
	}

	public void setCodiceTipologia(String codiceTipologia) {
		this.codiceTipologia = codiceTipologia;
	}

	public String getNomeTipologia() {
		return nomeTipologia;
	}

	public void setNomeTipologia(String nomeTipologia) {
		this.nomeTipologia = nomeTipologia;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(String prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public TipologiaEsameFacade getTipologieFacade() {
		return tipologieFacade;
	}

	public void setTipologieFacade(TipologiaEsameFacade tipologieFacade) {
		this.tipologieFacade = tipologieFacade;
	}

	public List<TipologiaEsame> getTipologie() {
		return tipologie;
	}

	public void setTipologie(List<TipologiaEsame> tipologie) {
		this.tipologie = tipologie;
	}
}
