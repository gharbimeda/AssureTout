package tn.esprit.assuretout.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.assuretout.contracts.ClientServices;
import tn.esprit.assuretout.contracts.CourtierServices;
import tn.esprit.assuretout.contracts.SinistreServices;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Courtier;
import tn.esprit.assuretout.entities.Etat;
import tn.esprit.assuretout.entities.Sinistre;

@ManagedBean
@ViewScoped
public class SinnistreCourtBean {

	@EJB
	SinistreServices sinistreServices;
	
	@EJB
	ClientServices clientService;
	
	@ManagedProperty(value = "#{identityBean.utilisateur}")
	private Courtier courtier;
	
	private Client client;
	
	private Sinistre sinistre= new Sinistre();
	
	private List<Client> clients;
	
	private List<String> images = new ArrayList<String>();
	
	@PostConstruct
	public void init() {
		clients = clientService.findAll();
	}
	
	public String submit() {

		sinistre.setEtat(Etat.ENCOURS);
		sinistre.setDate(new Date());
		sinistre.setClient(client);
		images.add(FileUploadView.filePath);
		sinistre.setImage1(images.get(0));
		System.out.println(sinistre.toString());
		sinistreServices.addSinistre(sinistre);
		return "/pages/courtier/dashboardCourtier?faces-redirect=true";
	}

	public Courtier getCourtier() {
		return courtier;
	}

	public void setCourtier(Courtier courtier) {
		this.courtier = courtier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Sinistre getSinistre() {
		return sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	
}
