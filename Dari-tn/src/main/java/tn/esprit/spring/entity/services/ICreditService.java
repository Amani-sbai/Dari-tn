package tn.esprit.spring.entity.services;

import java.util.List;

import tn.esprit.spring.entity.Credit;

public interface ICreditService {

	List<Credit> getAllCredits();
	Credit getCreditById(int id);
	void saveCredit(Credit credit);
	void deleteCredit(int id) ;
	void updateCredit(Credit credit);
}
