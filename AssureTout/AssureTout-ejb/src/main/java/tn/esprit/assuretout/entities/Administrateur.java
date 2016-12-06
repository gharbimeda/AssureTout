package tn.esprit.assuretout.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "administrateur")
public class Administrateur extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
	}

}
