package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.ContratServices;
import tn.esprit.assuretout.entities.Contrat;

@Stateless
public class ContratServicesImpl implements ContratServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addContrat(Contrat Contrat) {
		manager.persist(Contrat);

	}

	@Override
	public void deleteContrat(Contrat Contrat) {
		manager.remove(Contrat);

	}

	@Override
	public Contrat findById(int id) {
		return manager.find(Contrat.class, id);
	}

	@Override
	public void update(Contrat a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contrat> findAll() {
		Query query = manager.createQuery("SELECT c FROM Contrat c");
		return query.getResultList();
	}

	@Override
	public Contrat findByClient(int id) {
		TypedQuery<Contrat> query = manager.createQuery("SELECT co FROM Contrat co WHERE co.client.id = :id",
				Contrat.class);
		query.setParameter("id", id);

		return query.getSingleResult();
	}
}
