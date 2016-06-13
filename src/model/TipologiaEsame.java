package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "findAllTipologiaEsame", query = "SELECT p FROM TipologiaEsame p")

public class TipologiaEsame {
	
	
	@Id 
	private String codiceTipologia;
	@Column
	private String nomeTipologia;
	@Column
	private String descrizione;
	@Column
	private String costo;
	@Column
	private String prerequisiti;
	
	public TipologiaEsame(String nome, String descrizione, String costo, String prerequisiti, String codiceTipologia) {
		this.nomeTipologia = nome;
		this.descrizione = descrizione;
		this.costo = costo;
		this.prerequisiti = prerequisiti;
		this.codiceTipologia= codiceTipologia;
	}
	public TipologiaEsame() {
		
	}
	public String getNomeTipologia() {
		return nomeTipologia;
	}
	public void setNomeTipologia(String nome) {
		this.nomeTipologia = nome;
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
	public String getCodiceTipologia() {
		return codiceTipologia;
	}
	public void setCodiceTipologia(String codiceTipologia) {
		this.codiceTipologia = codiceTipologia;
	}
	@Override
	public String toString() {
		return "TipologiaEsame [codiceTipologia=" + codiceTipologia + ", nomeTipologia=" + nomeTipologia
				+ ", descrizione=" + descrizione + ", costo=" + costo + ", prerequisiti=" + prerequisiti + "]";
	}
	
}
