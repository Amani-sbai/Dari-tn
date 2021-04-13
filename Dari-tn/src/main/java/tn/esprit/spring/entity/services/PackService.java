package tn.esprit.spring.entity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Pack;
import tn.esprit.spring.repository.PackRepository;



@Service

public class PackService implements IPackService {
	@Autowired
	 PackRepository packrep;
	@Override
	public void ajouterPack(Pack pack)
	{
		packrep.save(pack);
	}
	public void supprimerPack(Pack pack){
		
		packrep.deleteById(pack.getId_pack());
	}
	public Pack modiferPack(Pack pack ){
	return packrep.save(pack);
	}

}

