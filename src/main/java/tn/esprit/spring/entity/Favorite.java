package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name= "favorite")
public class Favorite implements Serializable {

	
private static final long serialVersionUID = 1L;
private Date date;

@ManyToOne  //(fetch = FetchType.EAGER)
@JoinColumn(insertable=false,updatable=false,name="id_ads",referencedColumnName="id_ads",nullable = false)
private Ads ads;

@ManyToOne  //(fetch = FetchType.EAGER)
@JoinColumn(insertable=false,updatable=false,name="User_Id",referencedColumnName="User_Id",nullable = false)
private Customer customer;

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@EmbeddedId
private FavoritePK favoritePK;




public Ads getAds() {
	return ads;
}
public void setAds(Ads ads) {
	this.ads = ads;
}


public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

public FavoritePK getFavoritePK() {
	return favoritePK;
}
public void setFavoritePK(FavoritePK favoritePK) {
	this.favoritePK = favoritePK;
}
public static Optional<Favorite> findById() {
	// TODO Auto-generated method stub
	return null;
}
}
