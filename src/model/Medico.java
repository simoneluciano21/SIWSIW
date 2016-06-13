package model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Medico {
	private String nomeMedico;
	private String cognomeMedico;
	@Id
	private String idMedico;
	private String specializzazione;
	
	
	
	public Medico(String nome, String cognome, String id, String specializzazione) {
		this.nomeMedico = nome;
		this.cognomeMedico = cognome;
		this.idMedico = id;
		this.specializzazione = specializzazione;
	}
	public Medico() {
		// TODO Auto-generated constructor stub
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public String getCognomeMedico() {
		return cognomeMedico;
	}
	public String getIdMedico() {
		return idMedico;
	}
	public String getSpecializzazione() {
		return specializzazione;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public void setCognomeMedico(String cognomeMedico) {
		this.cognomeMedico = cognomeMedico;
	}
	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	@Override
	public String toString() {
		return "Medico [nomeMedico=" + nomeMedico + ", cognomeMedico=" + cognomeMedico + ", idMedico=" + idMedico
				+ ", specializzazione=" + specializzazione + "]";
	}
	
	
}
