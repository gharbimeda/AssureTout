package tn.esprit.assuretout.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.assuretout.entities.User;

@ManagedBean
@SessionScoped
public class IdentityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private User utilisateur;
	private String role;

	public IdentityBean() {
	}

	public Boolean hasRole(String r) {
		Boolean response = false;
		if (role.equals(r)) {
			response = true;
		}
		return response;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "IdentityBean [utilisateur=" + utilisateur + ", role=" + role + ", getUtilisateur()=" + getUtilisateur()
				+ ", getRole()=" + getRole() + "]";
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
