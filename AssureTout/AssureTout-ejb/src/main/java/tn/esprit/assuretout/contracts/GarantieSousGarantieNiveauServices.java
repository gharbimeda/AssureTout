package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.GarantieSousGarantieNiveau;

@Local
public interface GarantieSousGarantieNiveauServices {
	public void addGarantieSousGarantieNiveau(GarantieSousGarantieNiveau garantieSousGarantieNiveau);

	public void deleteGarantieSousGarantieNiveau(GarantieSousGarantieNiveau garantieSousGarantieNiveau);

	public GarantieSousGarantieNiveau find(int id);

	public void update(GarantieSousGarantieNiveau garantieSousGarantieNiveau);

	public List<GarantieSousGarantieNiveau> findAll();

	public List<GarantieSousGarantieNiveau> findByGarantie(Garantie g);
}
