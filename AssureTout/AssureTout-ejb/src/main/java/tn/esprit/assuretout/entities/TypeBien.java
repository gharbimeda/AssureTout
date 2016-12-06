package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TypeBien implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nom;
	private List<TypePropriete> typeProprietes;
	private List<Bien> biens;
	private TypeGarantie typeGarantie;
	private String icone;

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public TypeBien() {
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

	@OneToMany(mappedBy = "typeBien")
	public List<TypePropriete> getTypeProprietes() {
		return typeProprietes;
	}

	public void setTypeProprietes(List<TypePropriete> typeProprietes) {
		this.typeProprietes = typeProprietes;
	}

	@OneToMany(mappedBy = "typeBien")
	public List<Bien> getBiens() {
		return biens;
	}

	public void setBiens(List<Bien> biens) {
		this.biens = biens;
	}

	@ManyToOne
	public TypeGarantie getTypeGarantie() {
		return typeGarantie;
	}

	public void setTypeGarantie(TypeGarantie typeGarantie) {
		this.typeGarantie = typeGarantie;
	}
}
