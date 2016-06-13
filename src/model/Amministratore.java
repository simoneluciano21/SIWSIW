package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amministratore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeAmministratore;
	private String cognomeAmministratore;
	private String usernameAmministratore;
	private String passwordAmministratore;
	
	
	
	public Amministratore(String nome, String cognome, String username, String password) {
		this.nomeAmministratore = nome;
		this.cognomeAmministratore = cognome;
		this.usernameAmministratore = username;
		this.passwordAmministratore = password;
	}
	public Amministratore() {
		// TODO Auto-generated constructor stub
	}

	public boolean checkpassword(String password) {
		// TODO Auto-generated method stub
		return this.passwordAmministratore.equals(password);
	}
	public Long getId() {
		return id;
	}
	public String getNomeAmministratore() {
		return nomeAmministratore;
	}
	public String getCognomeAmministratore() {
		return cognomeAmministratore;
	}
	public String getUsernameAmministratore() {
		return usernameAmministratore;
	}
	public String getPasswordAmministratore() {
		return passwordAmministratore;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNomeAmministratore(String nomeAmministratore) {
		this.nomeAmministratore = nomeAmministratore;
	}
	public void setCognomeAmministratore(String cognomeAmministratore) {
		this.cognomeAmministratore = cognomeAmministratore;
	}
	public void setUsernameAmministratore(String usernameAmministratore) {
		this.usernameAmministratore = usernameAmministratore;
	}
	public void setPasswordAmministratore(String passwordAmministratore) {
		this.passwordAmministratore = passwordAmministratore;
	}
	
}
