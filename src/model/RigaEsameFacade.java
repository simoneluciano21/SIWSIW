package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "rigaEsameFacade")
public class RigaEsameFacade {

    @PersistenceContext(unitName = "products")
    EntityManager em;

    public RigaEsameFacade(){

    }

	public RigaEsame createRigaEsame(String nome, String valore, Esame esame) {
		RigaEsame rigaEsame= new RigaEsame(nome, valore, esame);
		em.persist(rigaEsame);
		return rigaEsame;
	}

	public List<RigaEsame> getRisultati(Esame esame) {
		// TODO Auto-generated method stub
		
	
			Query q= em.createQuery("Select r from RigaEsame r where r.esame=:es");
			q.setParameter("es", esame);
			List<RigaEsame> risultati= q.getResultList();

		
		
		return risultati;
	}

	public void eliminaRigaEsame(RigaEsame r) {
		em.remove(em.merge(r));
	}


	

}
