package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Contrat implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date date;
	private Date dateFin;
	private List<ContratBienGarantie> contratBienGaranties;
	private Client client;
	private int typeContrat;

	private float Prime;

	private Boolean etat;

	public Contrat() {
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

	public float getPrime() {
		return Prime;
	}

	public void setPrime(float prime) {
		Prime = prime;
	}

	@OneToOne
	public Client getClient() {
		return client;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@OneToMany(mappedBy = "contrat")
	public List<ContratBienGarantie> getContratBienGaranties() {
		return contratBienGaranties;
	}

	public void setContratBienGaranties(List<ContratBienGarantie> contratBienGaranties) {
		this.contratBienGaranties = contratBienGaranties;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", date=" + date + ", duree=" + dateFin + "]";
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public int getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(int typeContrat) {
		this.typeContrat = typeContrat;
	}
}
