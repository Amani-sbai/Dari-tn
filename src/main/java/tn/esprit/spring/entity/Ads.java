/* package tn.esprit.spring.entity;




import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name= "ads")
public class Ads implements Serializable  {
	

	
	private static final long serialVersionUID = 1558670426578301848L;
	private List<Favorite> favorite;
	
	@OneToMany(mappedBy="ads")
	private Favorite favorites;
	
	public List<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}
	public void assignFavoriteToThisAds(List<Favorite>favorite)
	{ this.setFavorite(favorite);
	for(Favorite f:favorite)
	{f.setAds(this);
	}}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ads;
	
	@Column(name="Description")
	private String description;
	
	
	
	
	
	@Enumerated(EnumType.STRING)
	Type type;
	
	

	
	public Ads() {
		
	}
	
	public Ads(String description, String favorite_ads, Type type){
		this.description = description;
		
		this.type = type;
	}

	public Long getId() {
		return id_ads;
	}

	public void setId(Long id_ads) {
		this.id_ads = id_ads;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
//les getters et setters sur quoi et le constructeur ??
	@OneToOne(mappedBy="ads")
	private Real_estates real_estates;




	public Real_estates getReal_estates() {
		return real_estates;
	}

	public void setReal_estates(Real_estates real_estates) {
		this.real_estates = real_estates;
	}
	
} 


*/