package tn.esprit.assuretout.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;

import tn.esprit.assuretout.contracts.ContratServices;
import tn.esprit.assuretout.contracts.TypeBienServices;
import tn.esprit.assuretout.entities.Bien;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Contrat;
import tn.esprit.assuretout.entities.ContratBienGarantie;
import tn.esprit.assuretout.entities.Garantie;
import tn.esprit.assuretout.entities.GarantieSousGarantieNiveau;
import tn.esprit.assuretout.entities.Niveau;
import tn.esprit.assuretout.entities.Propriete;
import tn.esprit.assuretout.entities.SousGarantie;
import tn.esprit.assuretout.entities.TypeBien;
import tn.esprit.assuretout.entities.TypeGarantie;
import tn.esprit.assuretout.entities.TypePropriete;
import tn.esprit.assuretout.entities.FinalGarantie;
import tn.esprit.assuretout.entities.Sousniveau;

@ManagedBean(name = "contrat")
@SessionScoped
public class ContratBean {

	@EJB
	tn.esprit.assuretout.contracts.TypeGarantieServices services;
	@EJB
	tn.esprit.assuretout.contracts.TypeBienServices bienServices;
	@EJB
	tn.esprit.assuretout.contracts.TypeProprieteServices typeProprieteServices;
	@EJB
	tn.esprit.assuretout.contracts.ProprieteServices proprieteServices;
	@EJB
	tn.esprit.assuretout.contracts.BienServices bienServices2;
	@EJB
	tn.esprit.assuretout.contracts.SousGarantieServices sousGarantieServices;
	@EJB
	tn.esprit.assuretout.contracts.NiveauServices niveauServices;
	@EJB
	tn.esprit.assuretout.contracts.ClientServices clientServices;
	@EJB
	tn.esprit.assuretout.contracts.ContratBienGarantieServices contratBienGarantieServices;
	@EJB
	tn.esprit.assuretout.contracts.GarantieSousGarantieNiveauServices garantieSousGarantieNiveauServices;
	@EJB
	tn.esprit.assuretout.contracts.ContratServices contratServices;
	@EJB
	tn.esprit.assuretout.contracts.GarantieServices garantieServices;

	private Bien bien;
	private List<TypeGarantie> garanties;
	private Contrat contrat;
	private TypeGarantie garantie;
	private List<TypeBien> types;
	private List<TypePropriete> typeProprietes;
	private List<Propriete> proprietes;
	private List<Bien> biens;
	private List<Bien> biensGarantie;
	private List<Bien> biensGarantie1;
	private List<SousGarantie> sousGaranties;
	private List<Garantie> garantiesChoisies;
	private Garantie selectedGarantie;
	private List<SousGarantie> selectedSousgarantie;
	private SousGarantie oneSousgarantie;
	private List<Sousniveau> sousniveaus;
	private List<Sousniveau> selectedSousniveaus;
	private List<FinalGarantie> finalGaranties;
	private List<Niveau> niveaus;
	private Float prix;
	@ManagedProperty(value = "#{identityBean.utilisateur}")
	private Client client;
	private ContratBienGarantie contratBienGarentie;
	private Date fin;
	private Sousniveau ss;
	private Niveau nv;
	private FinalGarantie e;

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public ContratBienGarantie getContratBienGarentie() {
		return contratBienGarentie;
	}

	public void setContratBienGarentie(ContratBienGarantie contratBienGarentie) {
		this.contratBienGarentie = contratBienGarentie;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public List<Niveau> getNiveaus() {
		return niveaus;
	}

	public void setNiveaus(List<Niveau> niveaus) {
		this.niveaus = niveaus;
	}

	public List<Sousniveau> getSousniveaus() {
		return sousniveaus;
	}

	public void setSousniveaus(List<Sousniveau> sousniveaus) {
		this.sousniveaus = sousniveaus;
	}

	public List<Sousniveau> getSelectedSousniveaus() {
		return selectedSousniveaus;
	}

	public void setSelectedSousniveaus(List<Sousniveau> selectedSousniveaus) {
		this.selectedSousniveaus = selectedSousniveaus;
	}

	public List<FinalGarantie> getFinalGaranties() {
		return finalGaranties;
	}

	public void setFinalGaranties(List<FinalGarantie> finalGaranties) {
		this.finalGaranties = finalGaranties;
	}

	public SousGarantie getOneSousgarantie() {
		return oneSousgarantie;
	}

	public void setOneSousgarantie(SousGarantie oneSousgarantie) {
		this.oneSousgarantie = oneSousgarantie;
	}

	public List<SousGarantie> getSelectedSousgarantie() {
		return selectedSousgarantie;
	}

	public void setSelectedSousgarantie(List<SousGarantie> selectedSousgarantie) {
		this.selectedSousgarantie = selectedSousgarantie;
	}

	public Garantie getSelectedGarantie() {
		return selectedGarantie;
	}

	public void setSelectedGarantie(Garantie selectedGarantie) {
		this.selectedGarantie = selectedGarantie;
	}

	public List<SousGarantie> getSousGaranties() {
		return sousGaranties;
	}

	public void setSousGaranties(List<SousGarantie> sousGaranties) {
		this.sousGaranties = sousGaranties;
	}

	public List<Garantie> getGarantiesChoisies() {
		return garantiesChoisies;
	}

	public void setGarantiesChoisies(List<Garantie> garantiesChoisies) {
		this.garantiesChoisies = garantiesChoisies;
	}

	public List<Bien> getBiensGarantie() {
		return biensGarantie;
	}

	public void setBiensGarantie(List<Bien> biensGarantie) {
		this.biensGarantie = biensGarantie;
	}

	public List<Bien> getBiens() {
		return biens;
	}

	public void setBiens(List<Bien> biens) {
		this.biens = biens;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public List<Propriete> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<Propriete> proprietes) {
		this.proprietes = proprietes;
	}

	public List<TypePropriete> getTypeProprietes() {
		return typeProprietes;
	}

	public void setTypeProprietes(List<TypePropriete> typeProprietes) {
		this.typeProprietes = typeProprietes;
	}

	private TypeBien typeBien;

	public TypeBien getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public TypeGarantie getGarantie() {
		return garantie;
	}

	public void setGarantie(TypeGarantie garantie) {
		this.garantie = garantie;
	}

	public List<TypeGarantie> getGaranties() {
		return garanties;
	}

	public void setGaranties(List<TypeGarantie> garanties) {
		this.garanties = garanties;
	}

	public List<Bien> getBiensGarantie1() {
		return biensGarantie1;
	}

	public void setBiensGarantie1(List<Bien> biensGarantie1) {
		this.biensGarantie1 = biensGarantie1;
	}

	@PostConstruct
	public void init() {
		this.sousGaranties = new ArrayList<SousGarantie>();
		ss = new Sousniveau();
		nv = new Niveau();
		this.selectedSousgarantie = new ArrayList<SousGarantie>();
		this.setGarantie(services.findById(1));
		this.setGaranties(services.findAll());
		this.sousniveaus = new ArrayList<Sousniveau>();
		this.finalGaranties = new ArrayList<FinalGarantie>();
		this.setPrix((float) 0);
		this.fin = new Date();
		types = bienServices.findAll();
		bien = new Bien();
		this.biensGarantie = new ArrayList<Bien>();
		selectedSousniveaus = new ArrayList<Sousniveau>();
		 e = new FinalGarantie();
		 niveaus = new ArrayList<Niveau>();

	}

	public List<TypeBien> getTypes() {
		return types;
	}

	public void setTypes(List<TypeBien> types) {
		this.types = types;
	}

	public List<Propriete> RemplirProp(List<TypePropriete> typeProprietes) {

		List<Propriete> list = new ArrayList<Propriete>();

		for (int i = 0; i < typeProprietes.size(); i++) {
			Propriete p = new Propriete();
			p.setNom(typeProprietes.get(i).getNom());
			p.setInputType(typeProprietes.get(i).getInputType());
			p.setTypePropriete(typeProprietes.get(i));
			p.setBien(bien);
			list.add(p);
		}
		return list;

	}

	public String ajoutGarantie(TypeGarantie garantie) {

		this.setGarantie(garantie);
		this.setTypes(bienServices.findByGaranties(garantie.getId()));
		this.biensGarantie = new ArrayList<Bien>();
		return "bien?faces-redirect=true";
	}

	public String ajoutTypeBien(TypeBien typeBien) {
		this.setTypeBien(typeBien);
		this.setTypeProprietes(typeProprieteServices.findByBien(typeBien.getId()));
		this.setProprietes(this.RemplirProp(typeProprietes));

		return "form?faces-redirect=true";

	}

	public void ajoutSousNiveau(SousGarantie s) {
		
		ss.setNiveau(niveauServices.findById(1));
		ss.setSousGarantie(s);
		selectedSousniveaus.add(ss);
		sousniveaus.remove(ss);
		niveaus.addAll(niveauServices.findAll());
	}

	/*
	 * ajout d'un bien avec ses props
	 */
	public String addBienwProp() {

		bien = new Bien();
		bien.setTypeBien(typeBien);
		bien.setNom(typeBien.getNom());
		bien.setProprietes(this.proprietes);
		this.biensGarantie.add(bien);
		this.setNiveaus(niveauServices.findAll());
		sousniveaus = new ArrayList<Sousniveau>();
		this.setSousGaranties(sousGarantieServices.findByTypegarantie(this.garantie.getId()));
		for (int i = 0; i < sousGaranties.size(); i++) {
			Sousniveau e = new Sousniveau();
			e.setSousGarantie(sousGaranties.get(i));
			e.setNiveau(niveaus.get(0));
			this.sousniveaus.add(e);

		}
		this.selectedSousniveaus = new ArrayList<Sousniveau>();
		return "sousgaranties?faces-redirect=true";
	}

	public String addAutreBien() {

		Bien bien = new Bien();
		bien.setTypeBien(typeBien);
		bien.setNom(typeBien.getNom());
		bien.setProprietes(this.proprietes);
		biensGarantie.add(bien);

		return "bien?faces-redirect=true";
	}

	public void onCarDrop(DragDropEvent ddEvent) {
		Sousniveau s = ((Sousniveau) ddEvent.getData());

		selectedSousniveaus.add(s);

		sousniveaus.remove(s);
	}

	public void removeSousgarantie(Sousniveau s) {

		selectedSousniveaus.remove(s);
		sousniveaus.add(s);

	}

	public void removeBien(Bien b) {

		biensGarantie.remove(b);
	}

	public String validerSousgarantie() {

		for (int i = 0; i < this.selectedSousniveaus.size(); i++) {
			selectedSousniveaus.get(i)
					.setNiveau(this.niveauServices.findById(selectedSousniveaus.get(i).getNiveau().getId()));

		}
		
		e.setGarantie(garantie);
		e.setBiens(biensGarantie);
		e.setSousniveaus(selectedSousniveaus);
		this.finalGaranties.add(e);
		calculPrix();
		return "final?faces-redirect=true";
	}
	
	
	public String validerSousgarantieDevis() {

		for (int i = 0; i < this.selectedSousniveaus.size(); i++) {
			selectedSousniveaus.get(i)
					.setNiveau(this.niveauServices.findById(selectedSousniveaus.get(i).getNiveau().getId()));

		}
		
		e.setGarantie(garantie);
		e.setBiens(biensGarantie);
		e.setSousniveaus(selectedSousniveaus);
		this.finalGaranties.add(e);
		calculPrix();
		return "devis?faces-redirect=true";
	}
	

	public String ajoutergarantie() {

		for (int i = 0; i < this.selectedSousniveaus.size(); i++) {
			selectedSousniveaus.get(i)
					.setNiveau(this.niveauServices.findById(selectedSousniveaus.get(i).getNiveau().getId()));

		}
		FinalGarantie e = new FinalGarantie();

		e.setGarantie(this.garantie);
		e.setBiens(biensGarantie);
		e.setSousniveaus(selectedSousniveaus);
		this.finalGaranties.add(e);
		return "devis?faces-redirect=true";
	}

	public void removaFinal(FinalGarantie f) {
		this.finalGaranties.remove(f);
		calculPrix();

	}

	public void calculPrix() {

		float s = 0;
		float t = 0;
		String v;
		float valeur = 1;
		for (int i = 0; i < finalGaranties.size(); i++) {
			for (int j = 0; j < finalGaranties.get(i).getSousniveaus().size(); j++) {
				s = s + (finalGaranties.get(i).getSousniveaus().get(j).getNiveau().getTauxPrime()
						* finalGaranties.get(i).getSousniveaus().get(j).getSousGarantie().getPrix()) / 100;
			}
			for (int j = 0; j < finalGaranties.get(i).getBiens().size(); j++) {
				for (int k = 0; k < finalGaranties.get(i).getBiens().get(j).getProprietes().size(); k++) {

					t = t + finalGaranties.get(i).getBiens().get(j).getProprietes().get(k).getTypePropriete()
							.getCoeff();
					if (finalGaranties.get(i).getBiens().get(j).getProprietes().get(k).getNom().endsWith("aleur")) {
						v = finalGaranties.get(i).getBiens().get(j).getProprietes().get(k).getValeur();
						valeur = Float.parseFloat(v);
					}
				}

			}
		}
		this.setPrix(s + valeur * t);
	}

	public void souscrire() throws IOException {
		ContratBienGarantie c = new ContratBienGarantie();

		Contrat contrat = new Contrat();
		contrat.setClient(this.client);

		contrat.setPrime(this.prix / 12);
		contrat.setEtat(false);

		Date d = new Date();
		contrat.setDate(d);
		contrat.setDateFin(fin);
		this.contratServices.addContrat(contrat);
		c.setContrat(contrat);

		for (int i = 0; i < finalGaranties.size(); i++) {
			Garantie g = new Garantie();
			g.setTypeGarantie(finalGaranties.get(i).getGarantie());
			garantieServices.addGarantie(g);

			c.setGarantie(g);
			for (int j = 0; j < finalGaranties.get(i).getBiens().size(); j++) {

				bienServices2.addBien(finalGaranties.get(i).getBiens().get(j), c);
				// c.setBien(finalGaranties.get(i).getBiens().get(j));
				// contratBienGarantieServices.addContratBienGarentie(c);
				c = new ContratBienGarantie();
				c.setContrat(contrat);
				c.setGarantie(g);
				for (int k = 0; k < finalGaranties.get(i).getBiens().get(j).getProprietes().size(); k++) {
					Propriete p = new Propriete();
					p = finalGaranties.get(i).getBiens().get(j).getProprietes().get(k);
					p.setBien(finalGaranties.get(i).getBiens().get(j));
					proprieteServices.addPropriete(p);

				}

			}
			for (int j = 0; j < finalGaranties.get(i).getSousniveaus().size(); j++) {
				GarantieSousGarantieNiveau cs = new GarantieSousGarantieNiveau();
				cs.setGarantie(g);
				cs.setSousGarantie(finalGaranties.get(i).getSousniveaus().get(j).getSousGarantie());
				cs.setNiveau(finalGaranties.get(i).getSousniveaus().get(j).getNiveau());
				garantieSousGarantieNiveauServices.addGarantieSousGarantieNiveau(cs);

			}
		}
		init();
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + "/pages/client/index.xhtml");

	}

	public void ajouterGarantie() {
		ContratBienGarantie c = new ContratBienGarantie();

		Contrat contrat = contratServices.findByClient(this.client.getId());
		contrat.setPrime(contrat.getPrime() + prix / 12);
		contratServices.update(contrat);
		c.setContrat(contrat);

		for (int i = 0; i < finalGaranties.size(); i++) {
			Garantie g = new Garantie();
			g.setTypeGarantie(finalGaranties.get(i).getGarantie());
			garantieServices.addGarantie(g);
			for (int j = 0; j < finalGaranties.get(i).getSousniveaus().size(); j++) {
				GarantieSousGarantieNiveau cs = new GarantieSousGarantieNiveau();
				cs.setGarantie(g);
				cs.setSousGarantie(finalGaranties.get(i).getSousniveaus().get(j).getSousGarantie());
				cs.setNiveau(finalGaranties.get(i).getSousniveaus().get(j).getNiveau());
				garantieSousGarantieNiveauServices.addGarantieSousGarantieNiveau(cs);

			}
			c.setGarantie(g);
			for (int j = 0; j < finalGaranties.get(i).getBiens().size(); j++) {

				bienServices2.addBien(finalGaranties.get(i).getBiens().get(j), c);
				// c.setBien(finalGaranties.get(i).getBiens().get(j));
				// contratBienGarantieServices.addContratBienGarentie(c);
				c = new ContratBienGarantie();
				c.setContrat(contrat);
				c.setGarantie(g);
				for (int k = 0; k < finalGaranties.get(i).getBiens().get(j).getProprietes().size(); k++) {
					Propriete p = new Propriete();
					p = finalGaranties.get(i).getBiens().get(j).getProprietes().get(k);
					p.setBien(finalGaranties.get(i).getBiens().get(j));
					proprieteServices.addPropriete(p);

				}

			}
		}
		init();
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/client/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Sousniveau getSs() {
		return ss;
	}

	public Niveau getNv() {
		return nv;
	}

	public void setSs(Sousniveau ss) {
		this.ss = ss;
	}

	public void setNv(Niveau nv) {
		this.nv = nv;
	}

	public FinalGarantie getE() {
		return e;
	}

	public void setE(FinalGarantie e) {
		this.e = e;
	}
	
}
