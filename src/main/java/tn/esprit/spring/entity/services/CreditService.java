package tn.esprit.spring.entity.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.repository.CreditRepository;

@Service 
public class CreditService {
	@Autowired
	private CreditRepository creditRepository;
	public List<Credit> getAllCredits()   
	{  
		return (List<Credit>) creditRepository.findAll();
	}  
	//Add a credit
	public Credit saveCredit(Credit credit){
		return creditRepository.save(credit);
	}
	//displaying credit info
	public Credit getCreditById(int id)   
	{  
		return creditRepository.findById(id).get();
	}
	//deleting a credit
	public void deleteCredit(int id)   
	{  
	creditRepository.deleteById(id);
	}  
	//updating a credit  
	public Credit updateCredit(Credit credit)   
	{  
		return creditRepository.save(credit);  
	}
	

}
