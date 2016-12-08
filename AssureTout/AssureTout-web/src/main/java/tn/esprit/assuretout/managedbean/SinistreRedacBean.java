package tn.esprit.assuretout.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.assuretout.contracts.SinistreServices;
import tn.esprit.assuretout.entities.Etat;
import tn.esprit.assuretout.entities.Sinistre;

@ManagedBean
@SessionScoped
public class SinistreRedacBean {

	@EJB
	SinistreServices sinistreServices;
	private List<Sinistre> sinistresRedac;

	@PostConstruct
	public void init() {
		
		sinistresRedac = sinistreServices.findAll();
	}

	public List<Sinistre> getSinistresRedac() {
		return sinistresRedac;
	}

	public void setSinistresRedac(List<Sinistre> sinistresRedac) {
		this.sinistresRedac = sinistresRedac;
	}
	
	public String doRefuser(Sinistre sinistre) {
		sinistre.setEtat(Etat.NONVALIDE);
		sinistreServices.update(sinistre);
		return "/pages/Redacteur/dashboardRedacteur?faces-redirect=true";
	}
	
}
