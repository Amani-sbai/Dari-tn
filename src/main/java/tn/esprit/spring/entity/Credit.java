package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "CREDIT")
public class Credit implements Serializable {

	private static final long serialVersionUID = -3619989487395029338L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Id
	@Column(name="Amount")
	private float amount;
	
	@Column(name="Period")
	private String period;
	
	
	@Column(name="Periodicity")
	private String periodicity;

	@Column(name="Bank")
	private String bank;
	
	@Column(name="Interest")
	private float interest;
	
	@Column(name="Stallements")
	private String stallements;
	
	@ManyToOne 
	Bank Bank;
	
public Credit() {
		
	}
	
	public Credit (float amount, int period, String periodicity, String bank, float interest, String stallements){
		this.amount = amount;
		this.period = periodicity;
		this.bank = bank;
		this.interest = interest;
		this.stallements = stallements;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public String getStallements() {
		return stallements;
	}

	public void setStallements(String stallements) {
		this.stallements = stallements;
	}

}