package tn.esprit.spring.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tn.esprit.spring.entity.Pack;
import tn.esprit.spring.entity.services.IPackService;
;

@Controller
public class PackController {
		@Autowired
		IPackService ipackservice;
		
		
	 //  http://localhost:8083/SpringMVC/servlet/ajouterPack #POST
		@PostMapping("/ajouterPack")
		@ResponseBody
		public void ajouterPack(@RequestBody Pack pack) {
			ipackservice.ajouterPack(pack);
		}
	//  http://localhost:8083/SpringMVC/servlet/supprimerPack #DELETE
			@DeleteMapping("/supprimerPack")
			@ResponseBody
			public void supprimerPack(@RequestBody Pack pack) {
				ipackservice.supprimerPack(pack);
				}
	//  http://localhost:8083/SpringMVC/servlet/modiferPack #UPDATE
			@PutMapping("/modifierPack")
			@ResponseBody
			public void modiferPack(@RequestBody Pack pack) {
				ipackservice.modiferPack(pack);
				}
}

