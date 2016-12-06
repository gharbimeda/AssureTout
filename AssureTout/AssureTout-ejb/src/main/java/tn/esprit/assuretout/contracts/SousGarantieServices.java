package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.Sinistre;
import tn.esprit.assuretout.entities.SousGarantie;

@Local
public interface SousGarantieServices {
	public void addSousGarantie(SousGarantie SousGarantie);

	public void deleteSousGarantie(SousGarantie SousGarantie);

	public SousGarantie findById(int id);

	public void update(SousGarantie SousGarantie);

	public List<SousGarantie> findAll();

	public List<SousGarantie> findByGarantie(Garantie g);

	public List<SousGarantie> findByTypegarantie(int id);

	public List<SousGarantie> findBySinistre(Sinistre sinistre);

	public SousGarantie findOne(Sinistre sinistre);
}
