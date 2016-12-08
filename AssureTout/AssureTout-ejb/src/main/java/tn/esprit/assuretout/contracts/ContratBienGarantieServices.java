package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Contrat;
import tn.esprit.assuretout.entities.ContratBienGarantie;

@Local
public interface ContratBienGarantieServices {

	public void addContratBienGarantie(ContratBienGarantie ContratBienGarantie);

	public void deleteContratBienGarantie(ContratBienGarantie ContratBienGarantie);

	public ContratBienGarantie findById(int id);

	public void update(ContratBienGarantie ContratBienGarantie);

	public List<ContratBienGarantie> findAll();

	public List<ContratBienGarantie> findByContract(Contrat c);
	
	public List<ContratBienGarantie> findByTypeContract(int type);

	public List<ContratBienGarantie> findByBien(Bien bien);
}
