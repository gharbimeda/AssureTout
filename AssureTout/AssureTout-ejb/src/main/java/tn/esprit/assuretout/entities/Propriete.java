package tn.esprit.assuretout.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Propriete implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private String valeur;
	private Bien bien;
	private String inputType;
	private TypePropriete typePropriete;

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public Propriete() {
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

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	@ManyToOne
	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	@ManyToOne
	public TypePropriete getTypePropriete() {
		return typePropriete;
	}

	public void setTypePropriete(TypePropriete typePropriete) {
		this.typePropriete = typePropriete;
	}
}
