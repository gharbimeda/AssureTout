package tn.esprit.assuretout.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.assuretout.contracts.ClientServices;
import tn.esprit.assuretout.contracts.UserServices;
import tn.esprit.assuretout.entities.Client;
@ManagedBean(name="auth")
@SessionScoped
public class UserBean {
	
	@EJB
	ClientServices services;
	@EJB 
	UserServices userServices;
	
	private Client client = new Client();

	public String inscription() {
		services.addClient(client);
		System.out.println("mcheeeeeeeeeet");
		return "/login.xhtml?faces-redirect=true";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
