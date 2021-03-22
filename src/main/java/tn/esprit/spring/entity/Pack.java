package tn.esprit.spring.entity;


import java.io.Serializable;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
public class Pack implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int id_pack;
	@Enumerated(EnumType.STRING)
	private Type_pack type_pack;
	private int price;
	private String devis;

	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne
	private Customer customer;
	
	public Pack(int id_pack, Type_pack type_pack, int price, String devis, Date date, Customer customer,
			 Assurance assurance) {
		super();
		this.id_pack = id_pack;
		this.type_pack = type_pack;
		this.price = price;
		this.devis = devis;
		this.date = date;
		this.customer = customer;
		this.assurance = assurance;
	}
	@OneToOne(mappedBy = "pack")
	private Assurance assurance;
	public Pack(int id_pack, int price) {
		super();
		this.id_pack = id_pack;
		this.price = price;
	}
	public Pack(int price) {
		super();
		this.price = price;
	}
	public int getId_pack() {
		return id_pack;
	}
	public Pack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId_pack(int id_pack) {
		this.id_pack = id_pack;
	}

	public Type_pack getType_pack() {
		return type_pack;
	}
	public void setType_pack(Type_pack type_pack) {
		this.type_pack = type_pack;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Pack [id_pack=" + id_pack + ", type_pack=" + type_pack + ", price=" + price + ", devis=" + devis
				+ ", date=" + date + ", costumer=" + customer + ", listeCard="  + ", assurance=" + assurance
				+ "]";
	}
	public String getDevis() {
		return devis;
	}
	public void setDevis(String devis) {
		this.devis = devis;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Pack(int price, String devis) {
		super();
		this.price = price;
		this.devis = devis;
		
	}

	public Customer getCustumer() {
		return customer;
	}
	public void setCustumer(Customer customer) {
		this.customer = customer;
	}
	public Assurance getAssurance() {
		return assurance;
	}
	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
	

}
