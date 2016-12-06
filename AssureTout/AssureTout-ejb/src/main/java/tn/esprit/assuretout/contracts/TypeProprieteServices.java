package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.TypePropriete;

@Local
public interface TypeProprieteServices {

	public void addTypePropriete(TypePropriete typePropriete);

	public void deleteTypePropriete(TypePropriete typePropriete);

	public TypePropriete findById(int id);

	public void update(TypePropriete typePropriete);

	public List<TypePropriete> findAll();

	public List<TypePropriete> findByBien(int id);
}
