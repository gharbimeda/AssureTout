package tn.esprit.assuretout.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GarantieSousGarantieNiveau implements Serializable {

	private static final long serialVersionUID = 1L;
	private Garantie garantie;
	private SousGarantie sousGarantie;
	private Niveau niveau;
	private Integer id;

	public GarantieSousGarantieNiveau() {
		super();
	}

	@ManyToOne
	public Garantie getGarantie() {
		return garantie;
	}

	public void setGarantie(Garantie garantie) {
		this.garantie = garantie;
	}

	@ManyToOne
	public SousGarantie getSousGarantie() {
		return sousGarantie;
	}

	public void setSousGarantie(SousGarantie sousGarantie) {
		this.sousGarantie = sousGarantie;
	}

	@ManyToOne
	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GarantieSousGarantieNiveau [garantie=" + garantie + ", sousGarantie=" + sousGarantie + ", niveau="
				+ niveau + ", id=" + id + "]";
	}
}
