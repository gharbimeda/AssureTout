package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.ContratBienGarantieServices;
import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Contrat;
import tn.esprit.assuretout.entities.ContratBienGarantie;

@Stateless
public class ContratBienGarantieServicesImpl implements ContratBienGarantieServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addContratBienGarantie(ContratBienGarantie ContratBienGarantie) {
		manager.persist(ContratBienGarantie);

	}

	@Override
	public void deleteContratBienGarantie(ContratBienGarantie ContratBienGarantie) {
		manager.remove(ContratBienGarantie);

	}

	@Override
	public ContratBienGarantie findById(int id) {
		return manager.find(ContratBienGarantie.class, id);
	}

	@Override
	public void update(ContratBienGarantie a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContratBienGarantie> findAll() {
		Query query = manager.createQuery("SELECT c FROM ContratBienGarantie c");
		return query.getResultList();
	}

	@Override
	public List<ContratBienGarantie> findByContract(Contrat contrat) {
		TypedQuery<ContratBienGarantie> query = manager.createQuery(
				"SELECT co FROM ContratBienGarantie co JOIN co.contrat c WHERE c.id = :id", ContratBienGarantie.class);
		query.setParameter("id", contrat.getId());

		return query.getResultList();

	}

	@Override
	public List<ContratBienGarantie> findByBien(Bien bien) {
		TypedQuery<ContratBienGarantie> query = manager.createQuery(
				"SELECT co FROM ContratBienGarantie co JOIN co.bien c WHERE c.id = :id", ContratBienGarantie.class);
		query.setParameter("id", bien.getId());

		return query.getResultList();
	}
}
