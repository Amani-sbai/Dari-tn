package tn.esprit.spring.entity.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;


import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.services.CreditService;
import tn.esprit.spring.entity.services.PdfCreditService;
@RestController
@RequestMapping(value="/Credit")
public class CreditController {

	@Autowired  
	CreditService creditService;
	@Autowired 
	private PdfCreditService pdfService;
    @Autowired
	private JavaMailSender javaMailSender;
	
    //Display all credits
	@GetMapping("/credits")  
	@ResponseBody
	private List<Credit> getAllCredits()   
	{  
	     return creditService.getAllCredits();  
	}
	
	//Display credit by id
	@GetMapping("/credit/{id}")  
	private Credit getCredit(@PathVariable("id") int id)   
	{  
	     return creditService.getCreditById(id);
	}
	
	//Delete Credit by id
	@RequestMapping(value = "/deletecredit/{id}", method = RequestMethod.DELETE) 
	@ResponseBody
	private void deleteCredit(@PathVariable("id") int id)   
	{  
	     creditService.deleteCredit(id);
	}  
	
	//Update a credit
	@PutMapping("/updatecredit")  
	private Credit updateCredit(@RequestBody Credit credit) {
		creditService.updateCredit(credit);
		return credit;
	}
	
	//Save a credit + Mail Sent pdf attachment
	@RequestMapping(value = "/savecreditdetails/{name}", method = RequestMethod.POST) 
	@ResponseBody
	private Credit saveCreditdetails(@PathVariable ("name") String name, @RequestBody Credit credit)throws MessagingException, IOException, DocumentException{
		MimeMessage message = javaMailSender.createMimeMessage();
		creditService.savecreditdetails(name,credit);
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom("daritn1@gmail.com");
	        helper.setTo("nourhene.oueslati@esprit.tn");
	        helper.setSubject("Credit Simulation");
	        helper.setText("Here is an attached file of your credit simulation");
	      byte[] content = Files.readAllBytes(Paths.get(pdfService.generatePdf(Optional.of(credit)).getAbsolutePath()));
	      helper.addAttachment("My Credit Simulation File.pdf", new ByteArrayResource(content));
	        javaMailSender.send(message);
	    }
	        catch (MessagingException  e) {
	        e.printStackTrace();
	    }
		return credit;
	}
	
	//statistics used bank
	@GetMapping(value ="/count/{name}")  
	@ResponseBody
	private int Count(@PathVariable ("name") String name){
		return creditService.Count(name);
	}
	//statistics used banks
	@GetMapping(value ="/Stat")  
	@ResponseBody
	private Map<String, Integer> barGraph(){
		return creditService.barGraph();
	}
}