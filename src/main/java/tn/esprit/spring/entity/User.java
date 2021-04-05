package tn.esprit.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.mapping.Set;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="User_Role")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
    private long userId;
	
	@Column(name = "First_Name")
    private String firstName;
	
	@Column(name = "Last_Name")
    private String LastName;
	
	
	@Column(name = "Encryted_Password")
	 private String encrytedPassword;

    @Column(name="number")
    private long nb;
    
    
    private String e_mail;
    
    private String Role;
	public long  getUserId() {
        return userId;
    }
 
    public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUserFirstname() {
        return firstName;
    }
 
 public void setUserFirstName(String FirstName ) {
        this.firstName = FirstName; 
    }
 
 
 public String getUserLastname() {
        return LastName;
    }
 
  public void setUserLastName(String LastName ) {
        this.LastName = LastName;
    }
    
    public String getEncrytedPassword() {
        return encrytedPassword;
        }

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
    //send user_id to credit
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy="user") 
     private Set<Credit> Credit;*/
    }
     