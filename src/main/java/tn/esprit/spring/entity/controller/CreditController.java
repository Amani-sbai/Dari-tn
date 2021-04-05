package tn.esprit.spring.entity.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.services.BankService;
import tn.esprit.spring.entity.services.CreditService;

@RestController
@RequestMapping(value="/Credit")
public class CreditController {

	@Autowired  
	CreditService creditService;
	@Autowired
	private BankService bankService;
	/*@Autowired
	private JavaMailSender javaMailSender;
	SimpleMailMessage msg = new SimpleMailMessage();*/
	
	@GetMapping("/credits")  
	@ResponseBody
	private List<Credit> getAllCredits()   
	{  
	     return creditService.getAllCredits();  
	}
	@PostMapping("/savecredit") 
	@ResponseBody
	public Credit saveCredit(@RequestBody Credit credit){
			creditService.saveCredit(credit);
		return credit;
	}
	
	@GetMapping("/credit/{id}")  
	private Credit getCredit(@PathVariable("id") int id)   
	{  
	     return creditService.getCreditById(id);
	}
	
	@RequestMapping(value = "/deletecredit/{id}", method = RequestMethod.DELETE) 
	@ResponseBody
	private void deleteCredit(@PathVariable("id") int id)   
	{  
	     creditService.deleteCredit(id);
	}  
	
	@PutMapping("/updatecredit")  
	private Credit updateCredit(@RequestBody Credit credit) {
		creditService.updateCredit(credit);
		return credit;
	}
	
	@RequestMapping(value = "/savecreditdetails/{name}", method = RequestMethod.POST)
	@ResponseBody
	private Credit saveCreditdetails(@PathVariable ("name") String name, @RequestBody Credit credit){
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
		creditService.saveCredit(credit);
		
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
