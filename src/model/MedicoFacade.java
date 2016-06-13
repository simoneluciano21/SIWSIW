package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "medicoFacade")
public class MedicoFacade {

    @PersistenceContext(unitName = "products")
    EntityManager em;

    public MedicoFacade(){

    }
    
	public List<TipologiaEsame> visualizzaTipologie() {
		// TODO Auto-generated method stub
		 Query q = em.createQuery("SELECT t FROM TipologiaEsame t");
	        List<TipologiaEsame> tipologiaEsames = q.getResultList();
	        return tipologiaEsames;
		
	}

	public List<Medico> visualizzaMedici() {
		Query q= em.createQuery("Select m FROM Medico m");
		List<Medico> medici= q.getResultList();
		return medici;
	}

	public List<Esame> getEsamiEffettuati(Medico medico) {
		// TODO Auto-generated method stub
		Query q= em.createQuery("Select e from Esame e where e.medico=:id");
		q.setParameter("id", medico);
		List<Esame> esamiEffettuati= q.getResultList();
		
		
		return esamiEffettuati;
	}

	public Medico getMedicoById(String idMedico) {
	
			// TODO Auto-generated method stub
			Medico m;
	        Query q = em.createQuery("SELECT m FROM Medico m WHERE m.idMedico=:id");
	        q.setParameter("id", idMedico);
			List<Medico> medico = q.getResultList();
	        if (q.getResultList().isEmpty())
	            return null;
	        else {
	            m = (Medico) q.getSingleResult();
	            return m;
	        }
		
		}





}
