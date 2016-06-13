package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Clinica {
	
	private HashMap<String, Paziente> pazienti;
	private ArrayList<Medico> medici;
	private HashMap<String, Amministratore> amministratori;
	private ArrayList<Esame> esami;
	private ArrayList<TipologiaEsame> tipologie;
	
	
	
	
	public Clinica(HashMap<String, Paziente> pazienti, ArrayList<Medico> medici, HashMap<String, Amministratore> amministratori, ArrayList<Esame> esami,
			ArrayList<TipologiaEsame> tipologie) {
		
		this.pazienti = pazienti;
		this.medici = medici;
		this.amministratori = amministratori;
		this.esami = esami;
		this.tipologie = tipologie;
	}

	public Collection<Paziente> getPazienti() {
		return pazienti.values();
	}

	public ArrayList<Medico> getMedici() {
		return medici;
	}

	public Collection<Amministratore> getAmministratori() {
		return amministratori.values();
	}

	public ArrayList<Esame> getEsami() {
		return esami;
	}


	public ArrayList<TipologiaEsame> getTipologie() {
		return tipologie;
	}


	
	
	
	
}
