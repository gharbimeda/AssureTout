package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Expert;
import tn.esprit.assuretout.entities.Expertise;

@Local
public interface ExpertiseServices {
	public void addExpertise(Expertise Expertise);

	public void deleteExpertise(Expertise Expertise);

	public Expertise findById(int id);

	public void update(Expertise Expertise);

	public List<Expertise> findAll();

	public List<Expertise> findByExpert(Expert expert);
}
