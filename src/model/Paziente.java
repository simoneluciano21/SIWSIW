package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paziente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaziente;
	private String nomePaziente;
	private String cognomePaziente;
	private String usernamePaziente;
	private String passwordPaziente;
	
	
	
	public Paziente(String nome, String cognome, String username, String password) {
		this.nomePaziente = nome;
		this.cognomePaziente = cognome;
		this.usernamePaziente = username;
		this.passwordPaziente = password;
	}
	public Paziente() {
		// TODO Auto-generated constructor stub
	}
	

	public boolean checkpassword(String password) {
		// TODO Auto-generated method stub
		return this.passwordPaziente.equals(password);
	}
	public Long getIdPaziente() {
		return idPaziente;
	}
	public String getNomePaziente() {
		return nomePaziente;
	}
	public String getCognomePaziente() {
		return cognomePaziente;
	}
	public String getUsernamePaziente() {
		return usernamePaziente;
	}
	public String getPasswordPaziente() {
		return passwordPaziente;
	}
	public void setIdPaziente(Long idPaziente) {
		this.idPaziente = idPaziente;
	}
	public void setNomePaziente(String nomePaziente) {
		this.nomePaziente = nomePaziente;
	}
	public void setCognomePaziente(String cognomePaziente) {
		this.cognomePaziente = cognomePaziente;
	}
	public void setUsernamePaziente(String usernamePaziente) {
		this.usernamePaziente = usernamePaziente;
	}
	public void setPasswordPaziente(String passwordPaziente) {
		this.passwordPaziente = passwordPaziente;
	}
	@Override
	public String toString() {
		return "Paziente [idPaziente=" + idPaziente + ", nomePaziente=" + nomePaziente + ", cognomePaziente="
				+ cognomePaziente + ", usernamePaziente=" + usernamePaziente + ", passwordPaziente=" + passwordPaziente
				+ "]";
	}
}
