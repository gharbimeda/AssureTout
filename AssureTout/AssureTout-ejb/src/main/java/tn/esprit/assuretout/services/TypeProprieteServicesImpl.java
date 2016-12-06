package tn.esprit.assuretout.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.TypeProprieteServices;
import tn.esprit.assuretout.entities.TypePropriete;

@Stateless
public class TypeProprieteServicesImpl implements TypeProprieteServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addTypePropriete(TypePropriete typePropriete) {
		manager.persist(typePropriete);

	}

	@Override
	public void deleteTypePropriete(TypePropriete typePropriete) {
		manager.remove(typePropriete);

	}

	@Override
	public TypePropriete findById(int id) {
		return manager.find(TypePropriete.class, id);
	}

	@Override
	public void update(TypePropriete typePropriete) {
		manager.merge(typePropriete);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypePropriete> findAll() {
		Query query = manager.createQuery("SELECT t FROM TypePropriete t");
		return query.getResultList();
	}

	@Override
	public List<TypePropriete> findByBien(int id) {
		TypedQuery<TypePropriete> query = manager.createQuery("select c from TypePropriete c where c.typeBien.id =:id",
				TypePropriete.class);
		query.setParameter("id", id);
		try {
			return query.getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
			if (query.getSingleResult() != null) {
				List<TypePropriete> list = new ArrayList<TypePropriete>();
				list.add(query.getSingleResult());
				return list;
			} else
				return null;

		}
	}
}
