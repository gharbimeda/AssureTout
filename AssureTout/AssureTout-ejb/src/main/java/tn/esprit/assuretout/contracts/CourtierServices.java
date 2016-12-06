package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Courtier;

@Local
public interface CourtierServices {
	public void addCourtier(Courtier Courtier);

	public void deleteCourtier(Courtier Courtier);

	public Courtier findById(int id);

	public void update(Courtier Courtier);

	public List<Courtier> findCourtierByRegion(String region);

	public List<Courtier> findAll();
}
