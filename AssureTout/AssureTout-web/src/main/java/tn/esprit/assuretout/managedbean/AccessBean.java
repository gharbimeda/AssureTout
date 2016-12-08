package tn.esprit.assuretout.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import tn.esprit.assuretout.contracts.UserServices;
import tn.esprit.assuretout.entities.Administrateur;
import tn.esprit.assuretout.entities.Client;
import tn.esprit.assuretout.entities.Courtier;
import tn.esprit.assuretout.entities.Expert;
import tn.esprit.assuretout.entities.Redacteur;
import tn.esprit.assuretout.entities.User;

@ManagedBean(name = "access")
@RequestScoped
public class AccessBean {

	@EJB
	private UserServices auth;

	@ManagedProperty("#{identityBean}")
	private IdentityBean identityBean;

	private String login;
	private String password;

	public AccessBean() {
	}

	public String doLogin() {
		String navigateTo = null;
		User found = auth.authUser(login, password);
		if (found != null) {
			if (found instanceof Client) {
				Client foundClient = (Client) auth.authUser(login, password);
				identityBean.setUtilisateur(foundClient);
				identityBean.setRole("client");
				navigateTo = "/pages/client/index?faces-redirect=true";
			} else if (found instanceof Courtier) {
				Courtier foundCourtier = (Courtier) auth.authUser(login, password);
				identityBean.setUtilisateur(foundCourtier);
				identityBean.setRole("courtier");
				navigateTo = "/pages/courtier/dashboardCourtier?faces-redirect=true";
			} else if (found instanceof Redacteur) {
				Redacteur foundRedacteur = (Redacteur) auth.authUser(login, password);
				identityBean.setUtilisateur(foundRedacteur);
				identityBean.setRole("redacteur");
				navigateTo = "/pages/Redacteur/dashboardRedacteur?faces-redirect=true";
			} else if (found instanceof Expert) {
				Expert foundExpert = (Expert) auth.authUser(login, password);
				identityBean.setUtilisateur(foundExpert);
				identityBean.setRole("expert");
				navigateTo = "/pages/expert/dashbordExpert?faces-redirect=true";
			} else if (found instanceof Administrateur) {
				Administrateur foundAdmin = (Administrateur) auth.authUser(login, password);
				identityBean.setUtilisateur(foundAdmin);
				identityBean.setRole("admin");
				navigateTo = "/pages/admin/dashbordAdmin?faces-redirect=true";
			}
		}
		return navigateTo;
	}

	public String doLogout() {
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		navigateTo = "/pages/public/login?faces-redirect=true";
		return navigateTo;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	public UserServices getAuth() {
		return auth;
	}

	public void setAuth(UserServices auth) {
		this.auth = auth;
	}

	public UserServices getAuthan() {
		return auth;
	}

	public void setAuthan(UserServices auth) {
		this.auth = auth;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
