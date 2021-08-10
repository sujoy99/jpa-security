package org.itbl.controller;

import org.itbl.CustomUserDetails;
import org.itbl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	
	@GetMapping({"/", "/login"})
	public String home() {
		
		return "login";
	}
	
//	@GetMapping("/login")
//	public String login(Model model) {
//		
//		User user = new User();
//		model.addAttribute("user", user);
//		return "login";
//	}
	
	@GetMapping("/admin")
	public String admin(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
		
		System.out.println(customUserDetails.getUser());
		
		return "admin";
	}
	
	@GetMapping("/test")
	public String admin1(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
		System.out.println(customUserDetails.getUser());
		
		return "admin";
	}
	
	@GetMapping("/bida")
	public String bida() {
		
		return "bida";
	}

}
