package tn.esprit.assuretout.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.assuretout.entities.Promotion;

@Local
public interface PromotionServices {

	public void addPromotion(Promotion Promotion);

	public void deletePromotion(Promotion Promotion);

	public Promotion findById(int id);

	public void update(Promotion Promotion);

	public List<Promotion> findAll();

	public List<Promotion> findByTypeGarantie(int id);
}
