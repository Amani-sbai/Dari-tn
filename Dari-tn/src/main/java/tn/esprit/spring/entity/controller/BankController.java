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

import tn.esprit.spring.entity.Bank;
import tn.esprit.spring.entity.services.IBankService;
@RestController
@RequestMapping(value="/Bank")
public class BankController {
	
	@Autowired  
	private IBankService IbankService;  
	
	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping(value="/banks")  
	@ResponseBody
	private List<Bank> getAllBanks()   
	{  
	     return IbankService.getAllBanks();  
	}
	@PostMapping(value="/savebank") 
	@ResponseBody
	public Bank saveBank(@RequestBody Bank bank){
			IbankService.saveBank(bank);
		return bank;
	}
	
	//creating a get mapping that display the detail of a specific bank
	 
	@RequestMapping(value = "/getbank/{name}", method = RequestMethod.GET)
	private Bank getBank(@PathVariable("name") String name)   
	{  
	     return IbankService.getBankByName(name);  
	}
	
	@RequestMapping(value = "/deletebank/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	private void deleteBank(@PathVariable("id") int id)   
	{  
	     IbankService.deleteBank(id);  
	}  
	
	@PutMapping("/updatebank")  
	private Bank update(@RequestBody Bank bank)   
	{  
	    IbankService.updateBank(bank);
	    return bank;
	}  
	

}
