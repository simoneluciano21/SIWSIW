package controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Amministratore;
import model.Paziente;
import model.Utente;
import model.UtenteFacade;

@ManagedBean
@SessionScoped
public class UtenteController {


	private Long Id;
	private String nome;
	private String cognome;
	private String username;
	protected String password;

	private Amministratore amministratore;
	private Paziente paziente;

	private List<Paziente> pazienti;

	@EJB(beanName = "utentefacade")
	private UtenteFacade utenteFacade;

	
	@PostConstruct
    public void init(){
        this.pazienti=utenteFacade.getAllPazienti();
    }
	
	
	public boolean verificaSessioneAdmin(){
		boolean verificato=false;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("admin")!=null)
			verificato=true;
		return verificato;


	}
	
	public boolean verificaSessionePaziente(){
		boolean verificato = false;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("paziente")!=null)
			verificato=true;
		return verificato;


	}

	public String loginPaziente(){
		try {
			Paziente paziente =this.utenteFacade.loginPaziente(username);

			if(paziente.checkpassword(password)){
				this.setPaziente(paziente);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("paziente", paziente);
				return "menuPaziente";
			}

			else
				FacesContext.getCurrentInstance().addMessage("loginUtente:accedi", new FacesMessage("Login Errato! username o password non inseriti correttamente!"));
			return "fallimento";
		}        catch (Exception e) {
			// Utente non trovato
			FacesContext.getCurrentInstance().addMessage("loginUtente:accedi", new FacesMessage("Login Errato! Email o password non inseriti correttamente!"));
			return "fallimento";
		}
	}

	public String logoutAdmin(){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("admin");
			return "index";
	}
	
	public String logoutPaziente(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("paziente");
		return "index";
}
	
	public String loginAmministratore(){
		try {
			Amministratore amministratore =this.utenteFacade.loginAmministratore(username);

			if(amministratore.checkpassword(password)){
				System.out.println(username);
				this.setAmministratore(amministratore);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admin", amministratore);
				return "menuAdmin";               // DA MODIFICARE

			}

			else
				FacesContext.getCurrentInstance().addMessage("loginUtente:accedi", new FacesMessage("Login Errato! username o password non inseriti correttamente!"));
			return "fallimento";
		}        catch (Exception e) {
			// Utente non trovato
			FacesContext.getCurrentInstance().addMessage("loginUtente:accedi", new FacesMessage("Login Errato! Email o password non inseriti correttamente!"));
			return "fallimento";
		}
	}
	
	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UtenteFacade getUtenteFacade() {
		return utenteFacade;
	}
	public void setUtenteFacade(UtenteFacade utenteFacade) {
		this.utenteFacade = utenteFacade;
	}

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public List<Paziente> getPazienti() {
		return pazienti;
	}

	public void setPazienti(List<Paziente> pazienti) {
		this.pazienti = pazienti;
	}

}
