package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.TypeGarantieServices;
import tn.esprit.assuretout.entities.TypeGarantie;

@Stateless
public class TypeGarantieServicesImpl implements TypeGarantieServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addGarantie(TypeGarantie Garantie) {
		manager.persist(Garantie);

	}

	@Override
	public void deleteGarantie(TypeGarantie Garantie) {
		manager.remove(Garantie);

	}

	@Override
	public TypeGarantie findById(int id) {
		return manager.find(TypeGarantie.class, id);
	}

	@Override
	public void update(TypeGarantie Garantie) {
		manager.merge(Garantie);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeGarantie> findAll() {
		Query query = manager.createQuery("SELECT c FROM TypeGarantie c");
		return query.getResultList();
	}

}
