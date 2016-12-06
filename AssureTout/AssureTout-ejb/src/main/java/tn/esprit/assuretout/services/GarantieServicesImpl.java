package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.GarantieServices;
import tn.esprit.assuretout.entities.Garantie;

@Stateless
public class GarantieServicesImpl implements GarantieServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addGarantie(Garantie Garantie) {
		manager.persist(Garantie);

	}

	@Override
	public void deleteGarantie(Garantie Garantie) {
		manager.remove(Garantie);

	}

	@Override
	public Garantie findById(int id) {
		return manager.find(Garantie.class, id);
	}

	@Override
	public void update(Garantie a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Garantie> findAll() {
		Query query = manager.createQuery("SELECT c FROM Garantie c");
		return query.getResultList();
	}
}
