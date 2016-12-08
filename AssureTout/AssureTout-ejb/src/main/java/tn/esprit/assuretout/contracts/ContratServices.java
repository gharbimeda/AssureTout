package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Contrat;

@Local
public interface ContratServices {

	public void addContrat(Contrat Contrat);

	public void deleteContrat(Contrat Contrat);

	public Contrat findById(int id);

	public void update(Contrat Contrat);

	public List<Contrat> findAll();

	public Contrat findByClient(int id);
	
	public List<Contrat> findAllByType(int type);
}
