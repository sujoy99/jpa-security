package org.itbl.service;

import java.util.List;

import org.itbl.entity.UserType;

public interface UserTypeService {
	
	List<UserType>userTypeList();
	
	UserType saveUserType(UserType userType);

}
