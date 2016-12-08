package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Garantie implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private TypeGarantie typeGarantie;
	private List<ContratBienGarantie> contratBienGaranties;
	private List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaux;

	public Garantie() {
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

	@OneToMany(mappedBy = "garantie")
	public List<ContratBienGarantie> getContratBienGaranties() {
		return contratBienGaranties;
	}

	public void setContratBienGaranties(List<ContratBienGarantie> contratBienGaranties) {
		this.contratBienGaranties = contratBienGaranties;
	}

	@ManyToOne
	public TypeGarantie getTypeGarantie() {
		return typeGarantie;
	}

	public void setTypeGarantie(TypeGarantie typeGarantie) {
		this.typeGarantie = typeGarantie;
	}

	@Override
	public String toString() {
		return "Garantie [id=" + id + "]";
	}

	@OneToMany(mappedBy = "garantie", fetch=FetchType.LAZY)
	public List<GarantieSousGarantieNiveau> getGarantieSousGarantieNiveaux() {
		return garantieSousGarantieNiveaux;
	}

	public void setGarantieSousGarantieNiveaux(List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaux) {
		this.garantieSousGarantieNiveaux = garantieSousGarantieNiveaux;
	}
}
