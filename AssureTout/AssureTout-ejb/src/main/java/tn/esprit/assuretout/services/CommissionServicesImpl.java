package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.CommissionServices;
import tn.esprit.assuretout.entities.Commission;

@Stateless
public class CommissionServicesImpl implements CommissionServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addCommission(Commission commission) {
		manager.persist(commission);

	}

	@Override
	public void deleteCommission(Commission commission) {
		manager.remove(commission);

	}

	@Override
	public Commission findById(int id) {
		return manager.find(Commission.class, id);
	}

	@Override
	public void update(Commission a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commission> findAll() {
		Query query = manager.createQuery("SELECT c FROM Commission c");
		return query.getResultList();
	}
}
