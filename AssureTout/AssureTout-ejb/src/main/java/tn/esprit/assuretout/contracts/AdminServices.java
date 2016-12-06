package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Administrateur;

@Local
public interface AdminServices {

	public void addAdmin(Administrateur administrateur);

	public void deleteAdmin(Administrateur administrateur);

	public Administrateur findById(int id);

	public void update(Administrateur administrateur);

	public List<Administrateur> findAll();
}
