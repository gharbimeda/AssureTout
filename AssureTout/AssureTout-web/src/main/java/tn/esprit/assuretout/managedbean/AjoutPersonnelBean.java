package tn.esprit.assuretout.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.assuretout.contracts.CourtierServices;
import tn.esprit.assuretout.contracts.ExpertServices;
import tn.esprit.assuretout.contracts.RedacteurServices;
import tn.esprit.assuretout.contracts.UserServices;
import tn.esprit.assuretout.entities.Courtier;
import tn.esprit.assuretout.entities.Expert;
import tn.esprit.assuretout.entities.Redacteur;

@ManagedBean
@ViewScoped
public class AjoutPersonnelBean {

	@EJB
	UserServices userServices;
	@EJB
	ExpertServices expertServices;
	@EJB
	CourtierServices courtierServices;
	@EJB
	RedacteurServices redacteurServices;


	private Expert expert = new Expert();
	private Courtier courtier = new Courtier();
	private Redacteur redacteur = new Redacteur();

	public String doAddExpert() {
		expertServices.addExpert(expert);
		return "gestionUsers?faces-redirect=true";
	}

	public String doAddCourtier() {
		courtierServices.addCourtier(courtier);
		return "gestionUsers?faces-redirect=true";
	}

	public String doAddRedacteur() {
		redacteurServices.addRedacteur(redacteur);
		return "gestionUsers?faces-redirect=true";
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public Courtier getCourtier() {
		return courtier;
	}

	public void setCourtier(Courtier courtier) {
		this.courtier = courtier;
	}

	public Redacteur getRedacteur() {
		return redacteur;
	}

	public void setRedacteur(Redacteur redacteur) {
		this.redacteur = redacteur;
	}

}
