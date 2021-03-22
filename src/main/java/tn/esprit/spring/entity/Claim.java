package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;

@Entity
public class Claim implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Claim_PK claim_pk;
	
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false, name="idRealEstate" , referencedColumnName="id_real_estate")
	private Real_estates real_estates;
	
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false, name="idUser" , referencedColumnName="User_Id")
	private Customer customer;
	
	public Claim_PK getClaim_pk() {
		return claim_pk;
	}
	public void setClaim_pk(Claim_PK claim_pk) {
		this.claim_pk = claim_pk;
	}
	public Real_estates getReal_estates() {
		return real_estates;
	}
	public void setReal_estates(Real_estates real_estates) {
		this.real_estates = real_estates;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
