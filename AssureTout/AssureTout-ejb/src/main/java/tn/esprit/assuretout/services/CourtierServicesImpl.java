package tn.esprit.assuretout.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.CourtierServices;
import tn.esprit.assuretout.entities.Courtier;

@Stateless
public class CourtierServicesImpl implements CourtierServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addCourtier(Courtier Courtier) {
		manager.persist(Courtier);

	}

	@Override
	public void deleteCourtier(Courtier Courtier) {
		manager.remove(Courtier);

	}

	@Override
	public Courtier findById(int id) {
		return manager.find(Courtier.class, id);
	}

	@Override
	public void update(Courtier a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Courtier> findAll() {
		Query query = manager.createQuery("SELECT c FROM Courtier c");
		return query.getResultList();
	}

	@Override
	public List<Courtier> findCourtierByRegion(String region) {
		TypedQuery<Courtier> query = manager.createQuery("select c from Courtier c where c.region =:region",
				Courtier.class);
		query.setParameter("region", region);
		try {
			return query.getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
			if (query.getSingleResult() != null) {
				List<Courtier> list = new ArrayList<Courtier>();
				list.add(query.getSingleResult());
				return list;
			} else
				return null;

		}
	}
}
