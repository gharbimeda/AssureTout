package tn.esprit.assuretout.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@DiscriminatorValue(value = "client")
public class Client extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String adresse;
	private String sexe;
	private boolean tabagisme;
	private Date dateNaissance;
	private Integer telephone;

	private Contrat contrat;
	private Courtier courtier;
	private String region;
	private List<Sinistre> sinistres;

	public Client() {
		super();
	}

	@NotNull
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@NotNull
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public boolean isTabagisme() {
		return tabagisme;
	}

	public void setTabagisme(boolean tabagisme) {
		this.tabagisme = tabagisme;
	}

	@Past(message="La date n'est pas valide")
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Min(10000000)
	@Max(99999999)
	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@ManyToOne
	public Courtier getCourtier() {
		return courtier;
	}

	public void setCourtier(Courtier courtier) {
		this.courtier = courtier;
	}

	@NotNull
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@OneToMany(mappedBy="client")
	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(List<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", sexe=" + sexe + ", tabagisme="
				+ tabagisme + ", dateNaissance=" + dateNaissance
				+ ", telephone=" + telephone + ", region=" + region
				+ ", sinistres=" +  "]";
	}
	
	
}
