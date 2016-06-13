package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "esamefacade")
public class EsameFacade {

    @PersistenceContext(unitName = "products")
    EntityManager em;

    public EsameFacade(){

    }

	public Esame createEsame(TipologiaEsame tipologiaEsame, Paziente paziente) {
		Esame esame= new Esame(tipologiaEsame,paziente);
		em.persist(esame);
		return esame;
	}

	public List<TipologiaEsame> visualizzaTipologie() {
		// TODO Auto-generated method stub
		 Query q = em.createQuery("SELECT t FROM TipologiaEsame t");
	        List<TipologiaEsame> tipologiaEsames = q.getResultList();
	        return tipologiaEsames;
		
	}

	public List<Esame> getAllEsami() {
		Query q = em.createQuery("Select e from Esame e");
		List<Esame> esami= q.getResultList();
		
		return esami;
	}

	public List<Esame> getEsamiByPaziente(Paziente paziente) {
		Query q= em.createQuery("Select e from Esame e where e.paziente=:paz");
		q.setParameter("paz", paziente);
		List<Esame> esamiSostenuti= q.getResultList();

		return esamiSostenuti;
	}


}
