package tn.esprit.assuretout.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.assuretout.contracts.SinistreServices;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Etat;
import tn.esprit.assuretout.entities.Sinistre;

@ManagedBean
@SessionScoped
public class SinistreBean {

	@EJB
	SinistreServices sinistreServices;

	Sinistre sinistre = new Sinistre();

	@ManagedProperty(value = "#{identityBean.utilisateur}")
	private Client client;

	private List<String> images = new ArrayList<String>();
	
	private List<Sinistre> sinistres ;
	
	@PostConstruct
	public void init() {
		sinistres = sinistreServices.findByClient(client);
	}

	public String submit() {

		sinistre.setEtat(Etat.ENCOURS);
		sinistre.setDate(new Date());
		sinistre.setClient(client);
		images.add(FileUploadView.filePath);
		sinistre.setImage1(images.get(0));
		System.out.println(sinistre.toString());
		sinistreServices.addSinistre(sinistre);
		return "/pages/client/index?faces-redirect=true";
	}
	
	public String doContester(Sinistre sinistre){
		sinistre.setEtat(Etat.CONTESTE);
		sinistreServices.update(sinistre);
		return "/pages/client/mesSinistre?faces-redirect=true";
	}

	public Sinistre getSinistre() {
		return sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(List<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

}
