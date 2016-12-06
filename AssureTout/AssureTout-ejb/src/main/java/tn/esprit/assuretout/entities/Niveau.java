package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Niveau implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private Float tauxPrime;
	private Float tauxRisque;
	private List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaux;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Niveau() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getTauxPrime() {
		return tauxPrime;
	}

	public void setTauxPrime(Float tauxPrime) {
		this.tauxPrime = tauxPrime;
	}

	public Float getTauxRisque() {
		return tauxRisque;
	}

	public void setTauxRisque(Float tauxRisque) {
		this.tauxRisque = tauxRisque;
	}

	@OneToMany(mappedBy = "niveau")
	public List<GarantieSousGarantieNiveau> getGarantieSousGarantieNiveaux() {
		return garantieSousGarantieNiveaux;
	}

	public void setGarantieSousGarantieNiveaux(List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaux) {
		this.garantieSousGarantieNiveaux = garantieSousGarantieNiveaux;
	}

}
