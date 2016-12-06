package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.ExpertServices;
import tn.esprit.assuretout.entities.Expert;

@Stateless
public class ExpertServicesImpl implements ExpertServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addExpert(Expert Expert) {
		manager.persist(Expert);

	}

	@Override
	public void deleteExpert(Expert Expert) {
		manager.remove(Expert);

	}

	@Override
	public Expert findById(int id) {
		return manager.find(Expert.class, id);
	}

	@Override
	public void update(Expert a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expert> findAll() {
		Query query = manager.createQuery("SELECT c FROM Expert c");
		return query.getResultList();
	}
}
