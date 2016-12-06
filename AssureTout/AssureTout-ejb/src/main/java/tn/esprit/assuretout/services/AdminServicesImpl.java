package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.AdminServices;
import tn.esprit.assuretout.entities.Administrateur;

@Stateless
public class AdminServicesImpl implements AdminServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addAdmin(Administrateur Administrateur) {
		manager.persist(Administrateur);

	}

	@Override
	public void deleteAdmin(Administrateur Administrateur) {
		manager.remove(Administrateur);

	}

	@Override
	public Administrateur findById(int id) {
		return manager.find(Administrateur.class, id);
	}

	@Override
	public void update(Administrateur a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrateur> findAll() {
		Query query = manager.createQuery("SELECT c FROM Administrateur c");
		return query.getResultList();
	}
}
