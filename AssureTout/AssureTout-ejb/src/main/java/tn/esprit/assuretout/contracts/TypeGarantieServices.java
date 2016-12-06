package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.TypeGarantie;

@Local
public interface TypeGarantieServices {

	public void addGarantie(TypeGarantie Garantie);

	public void deleteGarantie(TypeGarantie Garantie);

	public TypeGarantie findById(int id);

	public void update(TypeGarantie Garantie);

	public List<TypeGarantie> findAll();

}
