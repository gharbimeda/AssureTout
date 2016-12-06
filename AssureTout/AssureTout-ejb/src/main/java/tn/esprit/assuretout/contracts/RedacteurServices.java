package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Redacteur;

@Local
public interface RedacteurServices {
	public void addRedacteur(Redacteur Redacteur);

	public void deleteRedacteur(Redacteur Redacteur);

	public Redacteur findById(int id);

	public void update(Redacteur Redacteur);

	public List<Redacteur> findAll();
}
