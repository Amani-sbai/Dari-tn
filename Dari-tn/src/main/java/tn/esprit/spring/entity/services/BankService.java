package tn.esprit.spring.entity.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Bank;
import tn.esprit.spring.repository.BankRepository;

@Service 
public class BankService implements IBankService {
	@Autowired
	private BankRepository bankRepository;  
	//getting all banks
	public List<Bank> getAllBanks()   
	{  
		return (List<Bank>) bankRepository.findAll();
	}  
	//displaying bank info
	public Bank getBankByName(String name) 
	{  
		return bankRepository.findByName(name);
	}
	//deleting a bank
	public void deleteBank(int id)   
	{  
		//Bank bank = bankRepository.findById(id).get();
	bankRepository.deleteById(id);
	}
	
	@Override
	public Bank getBankById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Bank saveBank(Bank bank) {
		return bankRepository.save(bank);
		
	}
	@Override
	public Bank updateBank(Bank bank) {
		return bankRepository.save(bank);
		
	}
}

