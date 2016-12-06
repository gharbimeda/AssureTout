package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeGarantie implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private String description;
	private String icone;
	private List<Commission> commissions;
	private List<Promotion> promotions;

	private List<SousGarantie> sousgaranties;
	private List<TypeBien> typeBiens;
	private List<Garantie> garanties;

	public TypeGarantie() {
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "typeGarantie")
	public List<SousGarantie> getSousgaranties() {
		return sousgaranties;
	}

	public void setSousgaranties(List<SousGarantie> sousgaranties) {
		this.sousgaranties = sousgaranties;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	@OneToMany(mappedBy = "typeGarantie")
	public List<Garantie> getGaranties() {
		return garanties;
	}

	public void setGaranties(List<Garantie> garanties) {
		this.garanties = garanties;
	}

	@OneToMany(mappedBy = "typeGarantie")
	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	@OneToMany(mappedBy = "typeGarantie")
	public List<Commission> getCommissions() {
		return commissions;
	}

	public void setCommissions(List<Commission> commissions) {
		this.commissions = commissions;
	}

	@OneToMany(mappedBy = "typeGarantie")
	public List<TypeBien> getTypeBiens() {
		return typeBiens;
	}

	public void setTypeBiens(List<TypeBien> typeBiens) {
		this.typeBiens = typeBiens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeGarantie other = (TypeGarantie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
