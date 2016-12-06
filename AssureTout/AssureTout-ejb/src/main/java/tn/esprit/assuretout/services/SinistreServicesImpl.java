package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.SinistreServices;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Redacteur;
import tn.esprit.assuretout.entities.Sinistre;

@Stateless
public class SinistreServicesImpl implements SinistreServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addSinistre(Sinistre Sinistre) {
		manager.persist(Sinistre);

	}

	@Override
	public void deleteSinistre(Sinistre Sinistre) {
		manager.remove(Sinistre);

	}

	@Override
	public Sinistre findById(int id) {
		return manager.find(Sinistre.class, id);
	}

	@Override
	public void update(Sinistre a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sinistre> findAll() {
		Query query = manager.createQuery("SELECT c FROM Sinistre c");
		return query.getResultList();
	}

	@Override
	public List<Sinistre> findByClient(Client c) {
		TypedQuery<Sinistre> query = manager.createQuery("SELECT s FROM Sinistre s JOIN s.client c WHERE c.id = :id",
				Sinistre.class);
		query.setParameter("id", c.getId());

		return query.getResultList();

	}

	@Override
	public List<Sinistre> findByRedacteur(Redacteur r) {
		TypedQuery<Sinistre> query = manager.createQuery("select s from Sinistre s where s.redacteur =:redacteur",
				Sinistre.class);
		query.setParameter("redacteur", r);

		return query.getResultList();
	}
}
