package tn.esprit.assuretout.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.assuretout.contracts.ClientServices;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Courtier;

@Stateless
public class ClientServicesImpl implements ClientServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public void addClient(Client Client) {
		manager.persist(Client);

	}

	@Override
	public void deleteClient(Client Client) {
		manager.remove(Client);

	}

	@Override
	public Client findById(int id) {
		return manager.find(Client.class, id);
	}

	@Override
	public void update(Client a) {
		manager.merge(a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		Query query = manager.createQuery("SELECT c FROM Client c");
		return query.getResultList();
	}

	@Override
	public List<Client> findClientByCourtier(Courtier courtier) {
		TypedQuery<Client> query = manager.createQuery("select c from Client c where c.courtier =:courtier",
				Client.class);
		query.setParameter("courtier", courtier);
		return query.getResultList();

	}
}
