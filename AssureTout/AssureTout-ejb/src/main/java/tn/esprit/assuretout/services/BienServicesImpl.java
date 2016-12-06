package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.BienServices;
import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Contrat;
import tn.esprit.assuretout.entities.ContratBienGarantie;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.Propriete;

@Stateless
public class BienServicesImpl implements BienServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addBien(Bien Bien, ContratBienGarantie ContratBienGarantie) {
		ContratBienGarantie.setBien(Bien);
		manager.persist(Bien);
		manager.persist(ContratBienGarantie);

	}

	@Override
	public void deleteBien(Bien Bien) {
		manager.remove(Bien);

	}

	@Override
	public Bien findById(int id) {
		return manager.find(Bien.class, id);
	}

	@Override
	public void update(Bien a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bien> findAll() {
		Query query = manager.createQuery("SELECT c FROM Bien c");
		return query.getResultList();
	}

	@Override
	public void addBienProp(Bien bien, List<Propriete> proprietes) {
		manager.persist(bien);
		for (int i = 0; i < proprietes.size(); i++) {
			proprietes.get(i).setBien(bien);
			manager.persist(proprietes.get(i));

		}

	}

	@Override
	public List<Bien> findBienByContract(Contrat contrat) {
		TypedQuery<Bien> query = manager.createQuery("SELECT b FROM Bien b JOIN b.Contrat c WHERE c.id = :id",
				Bien.class);
		query.setParameter("id", contrat.getId());

		return query.getResultList();

	}

	@Override
	public List<Bien> findBienByContractandGarantie(Contrat contrat, Garantie garantie) {

		TypedQuery<Bien> query = manager.createQuery(
				"SELECT b FROM Bien b JOIN b.Contrat c JOIN b.Garantie g WHERE c.id = :idc AND g.id = :idg",
				Bien.class);
		query.setParameter("idc", contrat.getId());
		query.setParameter("idg", garantie.getId());

		return query.getResultList();
	}
}
