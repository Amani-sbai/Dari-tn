package tn.esprit.spring.entity.services;

import java.util.List;

import tn.esprit.spring.entity.Bank;

public interface IBankService {
  
		public List<Bank> getAllBanks();
		public Bank getBankById(int id);
		public Bank saveBank(Bank bank);
		public void deleteBank(int id) ;
		public Bank updateBank(Bank bank);
		public Bank getBankByName(String name);
		
		
}
