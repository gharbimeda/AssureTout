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
public class Bien implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private List<Propriete> proprietes;
	private List<ContratBienGarantie> contratBienGaranties;
	private TypeBien typeBien;

	public Bien() {
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

	@OneToMany(mappedBy = "bien")
	public List<Propriete> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<Propriete> proprietes) {
		this.proprietes = proprietes;
	}

	@OneToMany(mappedBy = "bien")
	public List<ContratBienGarantie> getContratBienGaranties() {
		return contratBienGaranties;
	}

	public void setContratBienGaranties(List<ContratBienGarantie> contratBienGaranties) {
		this.contratBienGaranties = contratBienGaranties;
	}

	@ManyToOne
	public TypeBien getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	@Override
	public String toString() {
		return "Bien [id=" + id + ", nom=" + nom + "]";
	}

}
