package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RigaEsame {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idRigaEsame;
private String nome;
private String valore;

@ManyToOne
private Esame esame;




public RigaEsame(String nome, String valore, Esame esame) {

	this.setNome(nome);
	this.valore = valore;
	this.esame = esame;
}

public String getValore() {
	return valore;
}
public void setValore(String valore) {
	this.valore = valore;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Long getIdRigaEsame() {
	return idRigaEsame;
}

public void setIdRigaEsame(Long idRigaEsame) {
	this.idRigaEsame = idRigaEsame;
}

@Override
public String toString() {
	return "RigaEsame [idRigaEsame=" + idRigaEsame + ", nome=" + nome + ", valore=" + valore + ", esame=" + esame + "]";
}

	
}
