
package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.List;


import javax.persistence.OneToMany;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="Customer")
public class Customer extends User implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	//private long id_Customer;
	
	
	@OneToMany(mappedBy="customer")
	private List<Favorite> favorite;
	
	public List<Favorite> getFavorite() {
		return favorite;
	}
	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}
	public void assignFavoriteToThisCustomer(List<Favorite>favorite)
	{ this.setFavorite(favorite);
	for(Favorite f:favorite)
	{f.setCustomer(this);
	}
	}
	
	
	
	/*public long getId_Customer() {
		return id_Customer;
	}
	public void setId_Customer(long id_Customer) {
		this.id_Customer = id_Customer;
	}
	*/
	
	
	@OneToMany(mappedBy="customer")
	private List<Claim> claim;
	
	public List<Claim> getClaim() {
		return claim;
	}
	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}}

