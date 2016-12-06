package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "redacteur")
public class Redacteur extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Sinistre> sinistres;

	public Redacteur() {
		super();

	}

	@OneToMany(mappedBy = "redacteur")
	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(List<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

	@Override
	public String toString() {
		return "Redacteur [getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

}
