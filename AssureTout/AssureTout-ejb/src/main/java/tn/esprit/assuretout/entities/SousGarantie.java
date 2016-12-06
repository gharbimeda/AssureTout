package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SousGarantie implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private String description;
	private Float prix;
	private String type;
	private List<Sinistre> sinistres;
	private TypeGarantie typeGarantie;
	private List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaux;

	public SousGarantie() {
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

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(mappedBy = "sousgaranties")
	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(List<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

	@ManyToOne
	public TypeGarantie getTypeGarantie() {
		return typeGarantie;
	}

	public void setTypeGarantie(TypeGarantie typeGarantie) {
		this.typeGarantie = typeGarantie;
	}

	@OneToMany(mappedBy = "sousGarantie")
	public List<GarantieSousGarantieNiveau> getGarantieSousGarantieNiveaux() {
		return garantieSousGarantieNiveaux;
	}

	public void setGarantieSousGarantieNiveaux(List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaux) {
		this.garantieSousGarantieNiveaux = garantieSousGarantieNiveaux;
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
		SousGarantie other = (SousGarantie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SousGarantie [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", type="
				+ type + ", typeGarantie=" + typeGarantie + "]";
	}
}
