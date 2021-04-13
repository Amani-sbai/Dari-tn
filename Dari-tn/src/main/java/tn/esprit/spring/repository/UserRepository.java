package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Customer;



@Repository

public interface UserRepository extends CrudRepository<Customer,Integer> {

}