package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.RedacteurServices;
import tn.esprit.assuretout.entities.Redacteur;

@Stateless
public class RedacteurServicesImpl implements RedacteurServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addRedacteur(Redacteur Redacteur) {
		manager.persist(Redacteur);

	}

	@Override
	public void deleteRedacteur(Redacteur Redacteur) {
		manager.remove(Redacteur);

	}

	@Override
	public Redacteur findById(int id) {
		return manager.find(Redacteur.class, id);
	}

	@Override
	public void update(Redacteur a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Redacteur> findAll() {
		Query query = manager.createQuery("SELECT c FROM Redacteur c");
		return query.getResultList();
	}

}
