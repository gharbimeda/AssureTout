package tn.esprit.assuretout.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.assuretout.contracts.UserServices;
//import tn.esprit.assuretout.contracts.UserServices;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Courtier;
import tn.esprit.assuretout.entities.Expert;
import tn.esprit.assuretout.entities.Redacteur;
import tn.esprit.assuretout.entities.User;

@Stateless
public class UserServicesImpl implements UserServices {
	@PersistenceContext(name = "AssureToutEjb")
	EntityManager manager;

	@Override
	public User authUser(String login, String motDePasse) {
		User user = null;
		try {
			Query query = manager
					.createQuery("SELECT u FROM User u WHERE u.email = :login AND u.password = :motdepass");
			query.setParameter("login", login);
			query.setParameter("motdepass", motDePasse);
			user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Redacteur getRedacteurByUser(int id) {
		// TODO Auto-generated method stub
		return manager.find(Redacteur.class, id);
	}

	@Override
	public Client getClientByUser(int id) {
		// TODO Auto-generated method stub
		return manager.find(Client.class, id);
	}

	@Override
	public Expert getExpertByUser(int id) {
		// TODO Auto-generated method stub
		return manager.find(Expert.class, id);
	}

	@Override
	public Courtier getCourtierByUser(int id) {
		// TODO Auto-generated method stub
		return manager.find(Courtier.class, id);
	}
}
