package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Esame;
import model.EsameFacade;
import model.RigaEsame;
import model.RigaEsameFacade;
import model.TipologiaEsame;
import model.TipologiaEsameFacade;

@ManagedBean
@SessionScoped
public class RigaEsameController {

	private String nome;
	private String valore;

	private Esame esame;
	private List<RigaEsame> risultati;
	private RigaEsame rigaEsame;


	@EJB(beanName = "rigaEsameFacade")
	private RigaEsameFacade rigaEsameFacade;


	public String eliminaRigaEsame(RigaEsame r){
		System.out.println(r);
		this.rigaEsameFacade.eliminaRigaEsame(r);
		this.loadRisultatiEsame(esame);
		return "nuovoRisultato";
	}
	
	public String inserimentoEsame(Esame e){
		this.setEsame(e);
		loadRisultatiEsame(e);
		return "nuovoRisultato";
	}

	private void loadRisultatiEsame(Esame e) {
		this.risultati=this.rigaEsameFacade.getRisultati(e);
	}
	public String createRigaEsame(){
		try {
			System.out.println(esame);
			this.setRigaEsame(this.rigaEsameFacade.createRigaEsame(nome,valore,esame));
			loadRisultatiEsame(esame);
		} catch (Exception e) {
			// TODO: handle exception
			return "nuovoRisultato";
		}

		return "nuovoRisultato";
	}

	public String getNome() {
		return nome;
	}

	public String getValore() {
		return valore;
	}

	public Esame getEsame() {
		return esame;
	}

	public RigaEsameFacade getRigaEsameFacade() {
		return rigaEsameFacade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public void setRigaEsameFacade(RigaEsameFacade rigaEsameFacade) {
		this.rigaEsameFacade = rigaEsameFacade;
	}

	public RigaEsame getRigaEsame() {
		return rigaEsame;
	}

	public void setRigaEsame(RigaEsame rigaEsame) {
		this.rigaEsame = rigaEsame;
	}

	public List<RigaEsame> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<RigaEsame> risultati) {
		this.risultati = risultati;
	}

}
