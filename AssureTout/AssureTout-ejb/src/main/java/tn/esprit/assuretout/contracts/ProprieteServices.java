package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Propriete;

@Local
public interface ProprieteServices {

	public void addPropriete(Propriete Propriete);

	public void deletePropriete(Propriete Propriete);

	public Propriete findById(int id);

	public void update(Propriete Propriete);

	public List<Propriete> findAll();

	public List<Propriete> findByBien(Bien bien);
}
