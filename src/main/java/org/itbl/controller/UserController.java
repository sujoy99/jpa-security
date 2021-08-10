package org.itbl.controller;

import java.util.List;

import org.itbl.entity.User;
import org.itbl.entity.UserType;
import org.itbl.repository.UserTypeRepository;
import org.itbl.service.UserService;
import org.itbl.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTypeService userTypeService;
	
	@GetMapping("/user")
	public String user(Model model) {
		
		List<User> userList = userService.userList();
		
		model.addAttribute("userList", userList);
		return "user";
	}
	
	@GetMapping("/addUser")
	public String getAddUser(Model model) {
		
		User user = new User();
		List<UserType>userTypeList = userTypeService.userTypeList();
		
		model.addAttribute("user", user);
		model.addAttribute("userTypeList", userTypeList);
		
		return "addUser";
	}
	
	@PostMapping("/addUser")
	public String saveAddUser(User user) {
		
		
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		System.out.println(user);
		
		userService.saveUser(user);
		
		return "redirect:/user";
	}
}
