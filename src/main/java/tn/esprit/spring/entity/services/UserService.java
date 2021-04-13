package tn.esprit.spring.entity.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.entity.User;

@Service
public class UserService  implements IUserService{
	
	private static final Logger L=LogManager.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> retreiveALLUSERs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long userId) {
		List<User> users = (List<User>)  userRepository.findAll();
		for(User user : users){
			L.info("user +++: " + user);
			
		}
		 return (User) users ;
	}

	@Override
	public void addUser(User user) {
		
		userRepository.save(user);  
	}

	@Override
	public void deleteUser(long userId) {
	
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);  
	}

}
