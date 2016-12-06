package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.ProprieteServices;
import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Propriete;

@Stateless
public class ProprieteServicesImpl implements ProprieteServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addPropriete(Propriete Propriete) {
		manager.persist(Propriete);

	}

	@Override
	public void deletePropriete(Propriete Propriete) {
		manager.remove(Propriete);

	}

	@Override
	public Propriete findById(int id) {
		return manager.find(Propriete.class, id);
	}

	@Override
	public void update(Propriete a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Propriete> findAll() {
		Query query = manager.createQuery("SELECT c FROM Propriete c");
		return query.getResultList();
	}

	@Override
	public List<Propriete> findByBien(Bien bien) {

		TypedQuery<Propriete> query = manager.createQuery("SELECT p FROM Propriete p JOIN p.bien b WHERE b.id = :id",
				Propriete.class);
		query.setParameter("id", bien.getId());

		return query.getResultList();
	}

}
