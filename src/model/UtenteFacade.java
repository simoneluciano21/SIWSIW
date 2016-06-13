package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "utentefacade")
public class UtenteFacade {

	@PersistenceContext(unitName = "products")
	EntityManager em;

	public UtenteFacade(){

	}

	public Paziente createUtente(String nome, String cognome, String username, String password) {
		Paziente paziente= new Paziente(nome, cognome, username, password);
		em.persist(paziente);
		return paziente;
	}

	public Paziente loginPaziente(String username) {

		Paziente u;
        Query q = em.createQuery("SELECT p FROM Paziente p WHERE p.usernamePaziente=:username");
        q.setParameter("username", username);
		List<Paziente> paziente = q.getResultList();
        if (q.getResultList().isEmpty())
            return null;
        else {
            u = (Paziente) q.getSingleResult();
            return u;
        }
	

	}
	public Amministratore loginAmministratore(String username) {

		Amministratore u;
        Query q = em.createQuery("SELECT a FROM Amministratore a WHERE a.usernameAmministratore=:username");
        q.setParameter("username", username);
		List<Amministratore> amministratore = q.getResultList();
        if (q.getResultList().isEmpty())
            return null;
        else {
            u = (Amministratore) q.getSingleResult();
            return u;
        }
	

	}

	public List<Paziente> getAllPazienti() {
		Query q= em.createQuery("SELECT p FROM Paziente p");
		List<Paziente> pazienti = q.getResultList();
		
	return pazienti;
	}

	public Paziente getPazienteByID(Long idPaziente) {
		// TODO Auto-generated method stub
		Paziente p;
        Query q = em.createQuery("SELECT p FROM Paziente p WHERE p.idPaziente=:id");
        q.setParameter("id", idPaziente);
		List<Paziente> paziente = q.getResultList();
        if (q.getResultList().isEmpty())
            return null;
        else {
            p = (Paziente) q.getSingleResult();
            return p;
        }
	}




}