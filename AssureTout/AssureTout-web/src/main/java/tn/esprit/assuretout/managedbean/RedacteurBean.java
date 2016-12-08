package tn.esprit.assuretout.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.assuretout.contracts.ContratBienGarantieServices;
import tn.esprit.assuretout.contracts.ContratServices;
import tn.esprit.assuretout.contracts.GarantieSousGarantieNiveauServices;
import tn.esprit.assuretout.entities.Contrat;
import tn.esprit.assuretout.entities.ContratBienGarantie;
import tn.esprit.assuretout.entities.GarantieSousGarantieNiveau;


@ManagedBean
@ViewScoped
public class RedacteurBean {

	@EJB
	GarantieSousGarantieNiveauServices service;

	@EJB
	ContratBienGarantieServices serviceC;
	
	@EJB
	ContratServices contratService;
	
	private int step=0;
	
	private List<ContratBienGarantie> list;
	
	private List<GarantieSousGarantieNiveau> listSG ;

	@PostConstruct
	public void init() {
		list = serviceC.findAll();
		listSG = new ArrayList<GarantieSousGarantieNiveau>();
	}
	
	public String doValiderContrat(Contrat c){
		c.setEtat(true);
		contratService.update(c);
		return "/pages/Redacteur/gestionContrat?faces-redirect=true";
	}

	public List<ContratBienGarantie> getList() {
		return list;
	}

	public void setList(List<ContratBienGarantie> list) {
		this.list = list;
	}

	public List<GarantieSousGarantieNiveau> getListSG() {
		return listSG;
	}

	public void setListSG(List<GarantieSousGarantieNiveau> listSG) {
		this.listSG = listSG;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	
}
