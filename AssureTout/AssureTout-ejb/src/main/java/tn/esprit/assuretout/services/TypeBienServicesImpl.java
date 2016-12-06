package tn.esprit.assuretout.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.TypeBienServices;
import tn.esprit.assuretout.entities.TypeBien;

@Stateless
public class TypeBienServicesImpl implements TypeBienServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addTypeBien(TypeBien typeBien) {
		manager.persist(typeBien);

	}

	@Override
	public void deleteTypeBien(TypeBien typeBien) {
		manager.remove(typeBien);

	}

	@Override
	public TypeBien findById(int id) {
		return manager.find(TypeBien.class, id);

	}

	@Override
	public void update(TypeBien typeBien) {
		manager.merge(typeBien);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeBien> findAll() {
		Query query = manager.createQuery("SELECT t FROM TypeBien t");
		return query.getResultList();
	}

	@Override
	public List<TypeBien> findByGaranties(int id) {
		TypedQuery<TypeBien> query = manager.createQuery("select c from TypeBien c where c.typeGarantie.id =:id",
				TypeBien.class);
		query.setParameter("id", id);
		try {
			return query.getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
			if (query.getSingleResult() != null) {
				List<TypeBien> list = new ArrayList<TypeBien>();
				list.add(query.getSingleResult());
				return list;
			} else
				return null;

		}
	}
}
