package org.itbl.service;

import java.util.List;

import org.itbl.entity.User;

public interface UserService {

	List<User> userList();
	
	User saveUser(User user);

}
