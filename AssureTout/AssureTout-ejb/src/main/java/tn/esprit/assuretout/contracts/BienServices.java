package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Contrat;
import tn.esprit.assuretout.entities.ContratBienGarantie;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.Propriete;

@Local
public interface BienServices {
	public void addBien(Bien Bien, ContratBienGarantie contratBienGarantie);

	public void deleteBien(Bien Bien);

	public Bien findById(int id);

	public void update(Bien Bien);

	public List<Bien> findAll();

	public void addBienProp(Bien bien, List<Propriete> proprietes);

	public List<Bien> findBienByContract(Contrat contrat);

	public List<Bien> findBienByContractandGarantie(Contrat contrat, Garantie garantie);
}
