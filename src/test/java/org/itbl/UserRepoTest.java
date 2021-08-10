package org.itbl;

import static org.junit.jupiter.api.Assertions.*;

import org.itbl.entity.User;
import org.itbl.entity.UserType;
import org.itbl.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepoTest {
	
	@Autowired
	UserRepository userRepository;

	@Test
	void saveUser() {
		
		User user = 
				User.builder()
				.name("TEST".toUpperCase())
				.password("1234")
				.build();
		
		
		userRepository.save(user);
		
	}

}
