package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "tipologiafacade")
public class TipologiaEsameFacade {

    @PersistenceContext(unitName = "products")
    EntityManager em;

    public TipologiaEsameFacade(){

    }

	public TipologiaEsame createTipologiaEsame(String codiceTipologia, String nomeTipologia, String descrizione, String costo, String prerequisiti) {
		TipologiaEsame tipologiaEsame= new TipologiaEsame(nomeTipologia, descrizione, costo, prerequisiti, codiceTipologia);
		em.persist(tipologiaEsame);
		return tipologiaEsame;
	}

	public List<TipologiaEsame> visualizzaTipologie() {
		// TODO Auto-generated method stub
		 Query q = em.createQuery("SELECT t FROM TipologiaEsame t");
	        List<TipologiaEsame> tipologiaEsames = q.getResultList();
	        return tipologiaEsames;
		
	}

	public TipologiaEsame getTipologiaByID(String codiceTipologia) {
		// TODO Auto-generated method stub
		TipologiaEsame t;
        Query q = em.createQuery("SELECT t FROM TipologiaEsame t WHERE t.codiceTipologia=:codice");
        q.setParameter("codice", codiceTipologia);
		List<TipologiaEsame> tipologia = q.getResultList();
        if (q.getResultList().isEmpty())
            return null;
        else {
            t = (TipologiaEsame) q.getSingleResult();
            return t;
        }
	
	}


}
