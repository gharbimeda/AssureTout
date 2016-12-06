package tn.esprit.assuretout.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContratBienGarantie implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Bien bien;
	private Contrat contrat;
	private Garantie garantie;

	public ContratBienGarantie() {
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

	@ManyToOne
	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	@ManyToOne
	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@ManyToOne
	public Garantie getGarantie() {
		return garantie;
	}

	public void setGarantie(Garantie garantie) {
		this.garantie = garantie;
	}

	@Override
	public String toString() {
		return "ContratBienGarentie [id=" + id + ", bien=" + bien + ", contrat=" + contrat + ", garantie=" + garantie
				+ "]";
	}

}
