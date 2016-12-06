package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.PromotionServices;
import tn.esprit.assuretout.entities.Promotion;

@Stateless
public class PromotionServicesImpl implements PromotionServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addPromotion(Promotion Promotion) {
		manager.persist(Promotion);

	}

	@Override
	public void deletePromotion(Promotion Promotion) {
		manager.remove(Promotion);

	}

	@Override
	public Promotion findById(int id) {
		return manager.find(Promotion.class, id);
	}

	@Override
	public void update(Promotion a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Promotion> findAll() {
		Query query = manager.createQuery("SELECT c FROM Promotion c");
		return query.getResultList();
	}

	@Override
	public List<Promotion> findByTypeGarantie(int id) {
		TypedQuery<Promotion> query = manager.createQuery("SELECT s FROM Promotion s WHERE s.typeGarantie.id=:id",
				Promotion.class);
		query.setParameter("id", id);

		return query.getResultList();
	}

}
