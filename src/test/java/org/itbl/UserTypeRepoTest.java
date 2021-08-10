package org.itbl;

import static org.junit.jupiter.api.Assertions.*;

import org.itbl.entity.UserType;
import org.itbl.repository.UserTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTypeRepoTest {

	@Autowired
	UserTypeRepository repo;
	
	@Test
	void saveUserType() {
		
		UserType userType = UserType.builder()
				.description("admin")
				.build();
		
		repo.save(userType);
	}

}
