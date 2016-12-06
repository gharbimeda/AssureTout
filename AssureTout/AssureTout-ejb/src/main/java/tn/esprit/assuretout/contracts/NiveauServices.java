package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Niveau;

@Local
public interface NiveauServices {

	public void addNiveau(Niveau Niveau);

	public void deleteNiveau(Niveau Niveau);

	public Niveau findById(int id);

	public void update(Niveau Niveau);

	public List<Niveau> findAll();
}
