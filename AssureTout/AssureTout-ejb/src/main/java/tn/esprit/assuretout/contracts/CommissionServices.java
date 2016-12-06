package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Commission;

@Local
public interface CommissionServices {

	public void addCommission(Commission commission);

	public void deleteCommission(Commission commission);

	public Commission findById(int id);

	public void update(Commission a);

	public List<Commission> findAll();
}
