package tn.esprit.assuretout.entities;

import java.util.List;

import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.TypeGarantie;

public class FinalGarantie {

	private TypeGarantie garantie;
	private List<Bien> biens;
	private List<Sousniveau> sousniveaus;
	public TypeGarantie getGarantie() {
		return garantie;
	}
	public void setGarantie(TypeGarantie garantie) {
		this.garantie = garantie;
	}
	public List<Bien> getBiens() {
		return biens;
	}
	public void setBiens(List<Bien> biens) {
		this.biens = biens;
	}
	public List<Sousniveau> getSousniveaus() {
		return sousniveaus;
	}
	public void setSousniveaus(List<Sousniveau> sousniveaus) {
		this.sousniveaus = sousniveaus;
	}
	
}
