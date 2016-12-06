package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.GarantieSousGarantieNiveauServices;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.GarantieSousGarantieNiveau;

@Stateless
public class GarantieSousGarantieNiveauServicesImpl implements GarantieSousGarantieNiveauServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addGarantieSousGarantieNiveau(GarantieSousGarantieNiveau garantieSousGarantieNiveau) {
		manager.persist(garantieSousGarantieNiveau);

	}

	@Override
	public void deleteGarantieSousGarantieNiveau(GarantieSousGarantieNiveau garantieSousGarantieNiveau) {
		manager.remove(garantieSousGarantieNiveau);

	}

	@Override
	public GarantieSousGarantieNiveau find(int id) {
		return manager.find(GarantieSousGarantieNiveau.class, id);
	}

	@Override
	public void update(GarantieSousGarantieNiveau garantieSousGarantieNiveau) {
		manager.merge(garantieSousGarantieNiveau);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GarantieSousGarantieNiveau> findAll() {
		Query query = manager.createQuery("SELECT c FROM GarantieSousGarantieNiveau c");
		return query.getResultList();
	}

	@Override
	public List<GarantieSousGarantieNiveau> findByGarantie(Garantie g) {

		TypedQuery<GarantieSousGarantieNiveau> query = manager.createQuery(
				"SELECT co FROM GarantieSousGarantieNiveau co JOIN co.garantie c WHERE c.id = :id",
				GarantieSousGarantieNiveau.class);
		query.setParameter("id", g.getId());

		return query.getResultList();
	}
}
