package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.TypeBien;

@Local
public interface TypeBienServices {
	public void addTypeBien(TypeBien typeBien);

	public void deleteTypeBien(TypeBien typeBien);

	public TypeBien findById(int id);

	public void update(TypeBien typeBien);

	public List<TypeBien> findAll();

	public List<TypeBien> findByGaranties(int id);
}
