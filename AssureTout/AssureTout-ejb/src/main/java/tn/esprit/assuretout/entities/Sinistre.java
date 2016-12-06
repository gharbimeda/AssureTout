package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Sinistre implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date date;
	private String image1;
	private String image2;
	private String description;
	private List<SousGarantie> sousgaranties;
	private Expertise expertise;
	private Etat etat;
	private Client client;
	private Redacteur redacteur;

	public Sinistre() {
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

	@NotNull
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany
	@JoinTable(name = "sousgarantie_sinistre", joinColumns = @JoinColumn(name = "sinistre_id") , inverseJoinColumns = @JoinColumn(name = "sousgarantie_id") )
	public List<SousGarantie> getSousgaranties() {
		return sousgaranties;
	}

	public void setSousgaranties(List<SousGarantie> sousgaranties) {
		this.sousgaranties = sousgaranties;
	}

	@OneToOne(mappedBy = "sinistre", cascade = CascadeType.ALL)
	public Expertise getExpertise() {
		return expertise;
	}

	public void setExpertise(Expertise expertise) {
		this.expertise = expertise;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@ManyToOne
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne
	public Redacteur getRedacteur() {
		return redacteur;
	}

	public void setRedacteur(Redacteur redacteur) {
		this.redacteur = redacteur;
	}

	@Override
	public String toString() {
		return "Sinistre [id=" + id + ", date=" + date + ", image1=" + image1 + ", image2=" + image2 + ", description="
				+ description + ", sousgaranties=" + sousgaranties + ", expertise=" + expertise + ", etat=" + etat
				+ ", client=" + client + "]";
	}

}
