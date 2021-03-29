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


@Entity 
public class Real_estates implements Serializable{
	

	

	private static final long serialVersionUID = -6187465752707179593L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_real_estate;
	private float Price;
	private String Adress;
	private float Area;
	private int nb_room;
	private String description;
	private String title;
	
	@Temporal (TemporalType.DATE)
	private Date Creation_date;
	
	@Enumerated(EnumType.STRING)
	 City city ;
	Category category;
	
	public String getTitle() {
        return title;
    }
 
 public void setTitle(String title ) {
        this.title=title; 
    }
 
 public String getDescription() {
     return description;
 }

public void setDescription(String description ) {
     this.description = description; 
 }
 
public String getAdress() {
    return Adress;
}

public void setAdress(String Adress ) {
    this.Adress = Adress; 
}
 
 
public long getIdRealEstate() {
    return  id_real_estate ;
}

public void setIdRealEstate(long id_real_estate) {
        this.id_real_estate =id_real_estate;
    }
 

public float getPrice() {
    return  Price ;
}

public void setPrice(float Price) {
        this.Price =Price;
    }
 
public float getArea() {
    return  Area ;
}

public void setArea(float Area) {
        this.Area=Area;
    }
public int getNbRoom() {
    return  nb_room ;
}

public void setNbRoom(int nb_room) {
        this.nb_room=nb_room;
    }
@OneToOne 
private Ads ads;
}
