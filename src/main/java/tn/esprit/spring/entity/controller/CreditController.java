package tn.esprit.spring.entity.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import tn.esprit.spring.entity.services.CreditService;

@RestController
@RequestMapping(value="/Credit")
public class CreditController {

	@Autowired  
	CreditService creditService;
	
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
	
		creditService.savecreditdetails(name,credit);
		
		return credit;
	}
}
