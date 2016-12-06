package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Garantie;

@Local
public interface GarantieServices {

	public void addGarantie(Garantie Garantie);

	public void deleteGarantie(Garantie Garantie);

	public Garantie findById(int id);

	public void update(Garantie Garantie);

	public List<Garantie> findAll();
}
