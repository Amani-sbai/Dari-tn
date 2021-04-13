package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Pack;

@Repository
public interface PackRepository extends CrudRepository<Pack, Integer> {
	

}