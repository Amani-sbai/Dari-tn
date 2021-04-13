package tn.esprit.spring.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class FavoritePK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private long id_ads ;

    private long id_favorite;
	public long getId_favorite() {
	return id_favorite;
}
public void setId_favorite(long id_favorite) {
	this.id_favorite = id_favorite;
}
	private long User_Id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (User_Id ^ (User_Id >>> 32));
		result = prime * result + (int) (id_ads ^ (id_ads >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoritePK other = (FavoritePK) obj;
		if (User_Id != other.User_Id)
			return false;
		if (id_ads != other.id_ads)
			return false;
		return true;
	}
	
	public long getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(long user_Id) {
		User_Id = user_Id;
	}
	public long getId_ads() {
		return id_ads;
	}
	public void setId_ads(long id_ads) {
		this.id_ads = id_ads;
	}

	public static Object findById() {
		
		return null;
	}
	
}
