package tn.esprit.spring.entity;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "BANK")
public class Bank implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Id
	@Column(name="NAME")
	private String Name;
	
	@Column(name="ADRESSE")
	private String adresse;
	
	
	@Column(name="INTEREST")
	private float interest;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private int phone;
	
	@Column(name="WEBSITE")
	private String website;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Bank") 
	private Set<Credit> Credit;
	
public Bank() {
		
	}
	
	public Bank (String name, String adresse, float interest, String email, int phone, String website){
		this.Name = name;
		this.adresse = adresse;
		this.interest = interest;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getSiteweb() {
		return website;
	}

	public void setSiteweb(String siteweb) {
		this.website = siteweb;
	}

}
