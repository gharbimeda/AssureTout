package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.ExpertiseServices;
import tn.esprit.assuretout.entities.Etat;
import tn.esprit.assuretout.entities.Expert;
import tn.esprit.assuretout.entities.Expertise;

@Stateless
public class ExpertiseServicesImpl implements ExpertiseServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addExpertise(Expertise Expertise) {
		manager.persist(Expertise);

	}

	@Override
	public void deleteExpertise(Expertise Expertise) {
		manager.remove(Expertise);

	}

	@Override
	public Expertise findById(int id) {
		return manager.find(Expertise.class, id);
	}

	@Override
	public void update(Expertise a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expertise> findAll() {
		Query query = manager.createQuery("SELECT c FROM Expertise c");
		return query.getResultList();
	}

	@Override
	public List<Expertise> findByExpert(Expert expert) {

		TypedQuery<Expertise> query = manager.createQuery(
				"SELECT ex FROM Expertise ex JOIN ex.expert e WHERE e.id = :id AND ex.sinistre.etat =:etat",
				Expertise.class);
		query.setParameter("id", expert.getId());
		query.setParameter("etat", Etat.ENCOURS);
		return query.getResultList();
	}
}
