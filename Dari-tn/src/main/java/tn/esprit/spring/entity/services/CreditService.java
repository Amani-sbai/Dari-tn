package tn.esprit.spring.entity.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.services.BankService;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.repository.CreditRepository;

@Service 
public class CreditService {
	@Autowired
	private CreditRepository creditRepository;
	@Autowired
	private BankService bankService;
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
	
	public Credit savecreditdetails(String name, Credit credit){
		float int_bank;
		float amount_credit = 0;
        int_bank = bankService.getBankByName(name).getInterest();
		int period_credit;
		String periodicity_credit;
		int Number_Installments = 0;
		float amount_int=0;
		float installment_credit=0;
		String bankname;
		period_credit = credit.getPeriod();
		periodicity_credit = credit.getPeriodicity();
		if (periodicity_credit.equals("monthly")){
			Number_Installments = period_credit*12;
		}
		if (periodicity_credit.equals("termly")){
			Number_Installments = period_credit*4;
		}
		if (periodicity_credit.equals("biannual")){
			Number_Installments = period_credit*2;
		}
		if (periodicity_credit.equals("annual")){
			Number_Installments = period_credit;
		}
		amount_credit = credit.getAmount();
		bankname = bankService.getBankByName(name).getName();
		credit.setBankname(bankname);
		amount_int = amount_credit+((amount_credit*int_bank)/100);
		installment_credit = amount_int/Number_Installments;
		credit.setAmountinstallment(installment_credit);
		credit.setInstallment(Number_Installments);
		credit.setInterest(int_bank);
		creditRepository.save(credit);
		
		/*String mailAdress=packRep.findById(pack.getId_pack()).get().getCustomer().getEmail();
		//Receiver
		msg.setTo( mailAdress); 
		//mail subject
		msg.setSubject("Confirmation Abonement"); 
		//Mail body
		msg.setText("votre abonnement est activé");
		javaMailSender.send(msg);
	    */
		return credit;
	}
}
