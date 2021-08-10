package org.itbl.controller;

import java.util.List;

import org.itbl.entity.UserType;
import org.itbl.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserTypeController {

	@Autowired
	UserTypeService userTypeService;
	
	@GetMapping("/userType")
	public String userType(Model model) {
		
		List<UserType> userTypeList = userTypeService.userTypeList();
		
		model.addAttribute("userTypeList", userTypeList);
		return "userType";
	}
	
	@GetMapping("/addUserType")
	public String getUserType(Model model) {
		
		
		UserType userType = new UserType();
		model.addAttribute("userType", userType);
		
		return "addUserType";
	}
	
	@PostMapping("/addUserType")
	public String saveUserType(UserType userType) {
		
		userTypeService.saveUserType(userType);
		
		return "redirect:/userType";
	}
}
