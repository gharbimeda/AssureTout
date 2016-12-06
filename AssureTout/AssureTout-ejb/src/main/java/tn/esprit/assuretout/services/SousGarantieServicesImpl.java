package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.SousGarantieServices;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.Sinistre;
import tn.esprit.assuretout.entities.SousGarantie;

@Stateless
public class SousGarantieServicesImpl implements SousGarantieServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addSousGarantie(SousGarantie SousGarantie) {
		manager.persist(SousGarantie);

	}

	@Override
	public void deleteSousGarantie(SousGarantie SousGarantie) {
		manager.remove(SousGarantie);

	}

	@Override
	public SousGarantie findById(int id) {
		return manager.find(SousGarantie.class, id);
	}

	@Override
	public void update(SousGarantie a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SousGarantie> findAll() {
		Query query = manager.createQuery("SELECT c FROM SousGarantie c");
		return query.getResultList();
	}

	@Override
	public List<SousGarantie> findByGarantie(Garantie g) {
		TypedQuery<SousGarantie> query = manager
				.createQuery("SELECT b FROM SousGarantie b JOIN b.garanties a WHERE a.id = :id", SousGarantie.class);
		query.setParameter("id", g.getId());

		return query.getResultList();

	}

	@Override
	public List<SousGarantie> findByTypegarantie(int id) {
		TypedQuery<SousGarantie> query = manager.createQuery("SELECT s FROM SousGarantie s WHERE s.typeGarantie.id=:id",
				SousGarantie.class);
		query.setParameter("id", id);

		return query.getResultList();
	}

	@Override
	public List<SousGarantie> findBySinistre(Sinistre sinistre) {
		TypedQuery<SousGarantie> query = manager
				.createQuery("SELECT s FROM SousGarantie s JOIN s.sinistres a WHERE a.id = :id", SousGarantie.class);
		query.setParameter("id", sinistre.getId());

		return query.getResultList();
	}

	@Override
	public SousGarantie findOne(Sinistre sinistre) {
		TypedQuery<SousGarantie> query = manager
				.createQuery("SELECT s FROM SousGarantie s JOIN s.sinistres a WHERE a.id = :id", SousGarantie.class);
		query.setParameter("id", sinistre.getId());
		query.setFirstResult(0);
		query.setMaxResults(1);
		return query.getSingleResult();
	}
}
