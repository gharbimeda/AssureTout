package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Redacteur;
import tn.esprit.assuretout.entities.Sinistre;

@Local
public interface SinistreServices {
	public void addSinistre(Sinistre Sinistre);

	public void deleteSinistre(Sinistre Sinistre);

	public Sinistre findById(int id);

	public void update(Sinistre Sinistre);

	public List<Sinistre> findAll();

	public List<Sinistre> findByClient(Client c);

	public List<Sinistre> findByRedacteur(Redacteur r);
}
