package tn.esprit.spring.entity;



import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class Claim_PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private long idClaim;	
private long  idUser;
private long  idRealEstate;


public long getIdUser() {
	return idUser;
}
public void setIdUser(long idUser) {
	this.idUser = idUser;
}
public long getIdRealEstate() {
	return idRealEstate;
}
public void setIdRealEstate(long idRealEstate) {
	this.idRealEstate = idRealEstate;
}
public long getIdClaim() {
	return idClaim;
}
public void setIdClaim(long idClaim) {
	this.idClaim = idClaim;
}
}

