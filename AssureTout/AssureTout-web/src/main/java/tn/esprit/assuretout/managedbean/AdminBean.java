package tn.esprit.assuretout.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.assuretout.contracts.ContratBienGarantieServices;
import tn.esprit.assuretout.contracts.ContratServices;
import tn.esprit.assuretout.contracts.GarantieServices;
import tn.esprit.assuretout.contracts.GarantieSousGarantieNiveauServices;
import tn.esprit.assuretout.contracts.ProprieteServices;
import tn.esprit.assuretout.contracts.SinistreServices;
import tn.esprit.assuretout.contracts.SousGarantieServices;
import tn.esprit.assuretout.contracts.TypeBienServices;
import tn.esprit.assuretout.contracts.TypeGarantieServices;
import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Contrat;
import tn.esprit.assuretout.entities.ContratBienGarantie;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.GarantieSousGarantieNiveau;
import tn.esprit.assuretout.entities.Propriete;
import tn.esprit.assuretout.entities.Sinistre;
import tn.esprit.assuretout.entities.SousGarantie;
import tn.esprit.assuretout.entities.TypeBien;
import tn.esprit.assuretout.entities.TypeGarantie;

@ManagedBean
@SessionScoped
public class AdminBean {

	@EJB
	GarantieServices garantieServices;
	@EJB
	SousGarantieServices sousGarantieServices;
	@EJB
	ContratBienGarantieServices contratBienGarantieServices;
	@EJB
	SinistreServices sinistreServices;
	@EJB
	GarantieSousGarantieNiveauServices garantieSousGarantieNiveauServices;
	@EJB
	ProprieteServices proprieteServices;
	@EJB
	ContratServices contratServices;
	@EJB
	TypeBienServices typeBienServices;
	@EJB
	TypeGarantieServices typeGarantiesServices;

	private List<Garantie> garantiesTab;
	private List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaus;
	private List<ContratBienGarantie> ContratBienGaranties;
	private Map<Garantie, List<Bien>> mapGrantieBien;
	private Map<Bien, List<Propriete>> mapBienProp;
	private List<Sinistre> sinistres;
	private Sinistre selectedSinistre;
	private Contrat c = new Contrat();
	private Client client = new Client();
	private List<TypeGarantie> typeGaranties;
	private TypeGarantie typeGarantie = new TypeGarantie();
	private TypeGarantie typeGarantieActuel = new TypeGarantie();
	private List<TypeBien> typesBiens;
	private TypeBien typeBien = new TypeBien();
	private TypeBien typeBienActuel = new TypeBien();
	private SousGarantie sousGarantie = new SousGarantie();
	private List<SousGarantie> sousGaranties;

	@PostConstruct
	public void init() {

		garantiesTab = new ArrayList<Garantie>();
		Set<Garantie> garanties = new HashSet<Garantie>();
		mapGrantieBien = new HashMap<Garantie, List<Bien>>();
		mapBienProp = new HashMap<Bien, List<Propriete>>();
		ContratBienGaranties = contratBienGarantieServices.findByContract(c);
		sinistres = sinistreServices.findByClient(client);
		List<SousGarantie> sousGaranties = new ArrayList<SousGarantie>();
		typesBiens = new ArrayList<TypeBien>();
		typeGaranties = new ArrayList<TypeGarantie>();
		typeGaranties = typeGarantiesServices.findAll();
		sousGaranties = new ArrayList<SousGarantie>();

		for (ContratBienGarantie cbg : ContratBienGaranties) {
			garanties.add(cbg.getGarantie());
		}
		for (Garantie g : garanties) {
			garantiesTab.add(g);
		}
		for (int j = 0; j < garantiesTab.size(); j++) {
			garantieSousGarantieNiveaus = garantieSousGarantieNiveauServices.findByGarantie(garantiesTab.get(j));
			garantiesTab.get(j).setGarantieSousGarantieNiveaux(garantieSousGarantieNiveaus);
		}
		for (Garantie g : garanties) {
			List<Bien> bien = new ArrayList<Bien>();
			for (ContratBienGarantie cbg : ContratBienGaranties) {
				if (cbg.getGarantie().equals(g)) {
					bien.add(cbg.getBien());
					mapGrantieBien.put(g, bien);
				}
			}
		}
		for (ContratBienGarantie cbg : ContratBienGaranties) {

			mapBienProp.put(cbg.getBien(), proprieteServices.findByBien(cbg.getBien()));

		}
		for (int i = 0; i < sinistres.size(); i++) {
			sousGaranties = sousGarantieServices.findBySinistre(sinistres.get(i));
			sinistres.get(i).setSousgaranties(sousGaranties);
		}

	}

	public void doAddTypeGarantie() {
		typeGarantiesServices.addGarantie(typeGarantie);
		init();
	}

	public void doAddTypeBien() {
		typeBien.setTypeGarantie(typeGarantieActuel);
		typeBienServices.addTypeBien(typeBien);
		typesBiens = typeBienServices.findByGaranties(typeGarantieActuel.getId());
		typeBien = new TypeBien();
	}

	public void doAddSousGarantie() {
		sousGarantie.setTypeGarantie(typeGarantieActuel);
		sousGarantieServices.addSousGarantie(sousGarantie);
		sousGaranties = sousGarantieServices.findByTypegarantie(typeGarantieActuel.getId());
		sousGarantie = new SousGarantie();
	}

	public String detailGarantie(TypeGarantie garantie) {
		typeGarantieActuel = garantie;
		typesBiens = typeBienServices.findByGaranties(typeGarantieActuel.getId());
		sousGaranties = sousGarantieServices.findByTypegarantie(typeGarantieActuel.getId());
		return "detailTypeGarantie?faces-redirect=true";
	}

	public String SelectClient(Contrat c) {
		this.setClient(c.getClient());

		this.setC(c);
		init();
		System.out.println("**********************" + c.getEtat() + "********************************");
		return "/Redacteur/ConsultGarantie/ConsulterContract.jsf?faces-redirect=true";
	}

	public String detailBien(TypeBien bien) {
		typeBienActuel = bien;
		return "detailBien?faces-redirect=true";
	}

	public List<TypeBien> getTypesBiens() {
		return typesBiens;
	}

	public void setTypesBiens(List<TypeBien> typesBiens) {
		this.typesBiens = typesBiens;
	}

	public String ValiderContrat() {
		this.c.setEtat(true);
		contratServices.update(c);
		return null;
	}

	public List<Garantie> getGarantiesTab() {
		return garantiesTab;
	}

	public void setGarantiesTab(List<Garantie> garantiesTab) {
		this.garantiesTab = garantiesTab;
	}

	public List<GarantieSousGarantieNiveau> getGarantieSousGarantieNiveaus() {
		return garantieSousGarantieNiveaus;
	}

	public void setGarantieSousGarantieNiveaus(List<GarantieSousGarantieNiveau> garantieSousGarantieNiveaus) {
		this.garantieSousGarantieNiveaus = garantieSousGarantieNiveaus;
	}

	public List<ContratBienGarantie> getContratBienGaranties() {
		return ContratBienGaranties;
	}

	public void setContratBienGaranties(List<ContratBienGarantie> ContratBienGaranties) {
		this.ContratBienGaranties = ContratBienGaranties;
	}

	public Contrat getC() {
		return c;
	}

	public void setC(Contrat c) {
		this.c = c;
	}

	public Map<Garantie, List<Bien>> getMapGrantieBien() {
		return mapGrantieBien;
	}

	public void setMapGrantieBien(Map<Garantie, List<Bien>> mapGrantieBien) {
		this.mapGrantieBien = mapGrantieBien;
	}

	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(List<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Map<Bien, List<Propriete>> getMapBienProp() {
		return mapBienProp;
	}

	public void setMapBienProp(Map<Bien, List<Propriete>> mapBienProp) {
		this.mapBienProp = mapBienProp;
	}

	public Sinistre getSelectedSinistre() {
		return selectedSinistre;
	}

	public void setSelectedSinistre(Sinistre selectedSinistre) {
		this.selectedSinistre = selectedSinistre;
	}

	public List<TypeGarantie> getTypeGaranties() {
		return typeGaranties;
	}

	public void setTypeGaranties(List<TypeGarantie> typeGaranties) {
		this.typeGaranties = typeGaranties;
	}

	public TypeGarantie getTypeGarantie() {
		return typeGarantie;
	}

	public void setTypeGarantie(TypeGarantie typeGarantie) {
		this.typeGarantie = typeGarantie;
	}

	public TypeGarantie getTypeGarantieActuel() {
		return typeGarantieActuel;
	}

	public void setTypeGarantieActuel(TypeGarantie typeGarantieActuel) {
		this.typeGarantieActuel = typeGarantieActuel;
	}

	public TypeBien getTypeBien() {
		return typeBien;
	}

	public TypeBien getTypeBienActuel() {
		return typeBienActuel;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	public void setTypeBienActuel(TypeBien typeBienActuel) {
		this.typeBienActuel = typeBienActuel;
	}

	public SousGarantie getSousGarantie() {
		return sousGarantie;
	}

	public List<SousGarantie> getSousGaranties() {
		return sousGaranties;
	}

	public void setSousGarantie(SousGarantie sousGarantie) {
		this.sousGarantie = sousGarantie;
	}

	public void setSousGaranties(List<SousGarantie> sousGaranties) {
		this.sousGaranties = sousGaranties;
	}

}
