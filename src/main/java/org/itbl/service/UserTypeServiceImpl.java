package org.itbl.service;

import java.util.List;

import org.itbl.entity.UserType;
import org.itbl.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements UserTypeService {
	
	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public List<UserType> userTypeList() {
		
		return userTypeRepository.findAll();
	}
	
	
	@Override
	public UserType saveUserType(UserType entity) {
		
		return userTypeRepository.save(entity);
	}



}
