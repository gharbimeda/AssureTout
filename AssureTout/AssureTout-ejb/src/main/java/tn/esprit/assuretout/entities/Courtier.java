package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "courtier")
public class Courtier extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String adresse;
	private Integer telephone;
	private List<Client> clients;
	private String region;

	public Courtier() {
		super();
	}

	@NotNull
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Min(value=10000000,message="téléphone non valide")
	@Max(99999999)
	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	@OneToMany(mappedBy="courtier")
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@NotNull
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Courtier [adresse=" + adresse + ", telephone=" + telephone
				+ ", clients="+ ", region=" + region + "]";
	}
}
