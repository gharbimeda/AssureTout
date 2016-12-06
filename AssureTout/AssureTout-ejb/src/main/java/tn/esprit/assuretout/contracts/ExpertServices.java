package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Expert;

@Local
public interface ExpertServices {
	public void addExpert(Expert Expert);

	public void deleteExpert(Expert Expert);

	public Expert findById(int id);

	public void update(Expert Expert);

	public List<Expert> findAll();
}
