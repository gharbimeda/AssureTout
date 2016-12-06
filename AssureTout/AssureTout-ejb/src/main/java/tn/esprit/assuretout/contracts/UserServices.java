package tn.esprit.assuretout.contracts;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Courtier;
import tn.esprit.assuretout.entities.Expert;
import tn.esprit.assuretout.entities.Redacteur;
import tn.esprit.assuretout.entities.User;

@Local
public interface UserServices {

	public User authUser(String login, String motDePasse);

	public Redacteur getRedacteurByUser(int id);

	public Client getClientByUser(int id);

	public Expert getExpertByUser(int id);

	public Courtier getCourtierByUser(int id);
}
