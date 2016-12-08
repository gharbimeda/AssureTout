package tn.esprit.assuretout.entities;

import tn.esprit.assuretout.entities.Niveau;
import tn.esprit.assuretout.entities.SousGarantie;

public class Sousniveau {

	private SousGarantie sousGarantie;
	private Niveau niveau;
	public SousGarantie getSousGarantie() {
		return sousGarantie;
	}
	public void setSousGarantie(SousGarantie sousGarantie) {
		this.sousGarantie = sousGarantie;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
}
