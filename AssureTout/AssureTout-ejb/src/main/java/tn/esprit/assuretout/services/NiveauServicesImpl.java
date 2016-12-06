package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.NiveauServices;
import tn.esprit.assuretout.entities.Niveau;

@Stateless
public class NiveauServicesImpl implements NiveauServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addNiveau(Niveau Niveau) {
		manager.persist(Niveau);

	}

	@Override
	public void deleteNiveau(Niveau Niveau) {
		manager.remove(Niveau);

	}

	@Override
	public Niveau findById(int id) {
		return manager.find(Niveau.class, id);
	}

	@Override
	public void update(Niveau a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Niveau> findAll() {
		Query query = manager.createQuery("SELECT c FROM Niveau c");
		return query.getResultList();
	}
}
