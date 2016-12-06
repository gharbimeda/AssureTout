package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Courtier;

@Local
public interface ClientServices {
	public void addClient(Client client);

	public void deleteClient(Client client);

	public Client findById(int id);

	public void update(Client client);

	public List<Client> findAll();

	public List<Client> findClientByCourtier(Courtier courtier);
}
