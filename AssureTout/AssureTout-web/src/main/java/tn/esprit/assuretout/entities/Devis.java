package tn.esprit.assuretout.entities;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.TypeBien;

public class Devis {
private List<Bien> biens;
private List<TypeBien> typeBiens;
private List<Garantie> garanties;
public Devis(){
	biens = new ArrayList<Bien>();
	typeBiens = new ArrayList<TypeBien>();
	garanties = new ArrayList<Garantie>();
}

public List<Bien> getBiens() {
	return biens;
}

public void setBiens(List<Bien> biens) {
	this.biens = biens;
}

public List<TypeBien> getTypeBiens() {
	return typeBiens;
}

public void setTypeBiens(List<TypeBien> typeBiens) {
	this.typeBiens = typeBiens;
}

public List<Garantie> getGaranties() {
	return garanties;
}

public void setGaranties(List<Garantie> garanties) {
	this.garanties = garanties;
}
public float calculDevis(){
	float resultat=0;
	for (int i = 0; i < garanties.size(); i++) {
		for (int j = 0; j < biens.size(); j++) {
			
			
		}
		
	}
	return resultat;
	
}

}
