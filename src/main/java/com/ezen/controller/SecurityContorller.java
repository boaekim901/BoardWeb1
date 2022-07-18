package com.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ezen.domain.Member;
import com.ezen.domain.SecurityUser;
import com.ezen.service.SecurityUserDetailsService;

@Controller
@SessionAttributes("member")
public class SecurityContorller {
	
	@GetMapping("/system/login")
	public String loginView() {
		return "system/login";
	}
	
	@PostMapping("/system/login")
	public void login() {
		
	}
	
	@GetMapping("/system/accessDenied")
	public void accessDenied() {
	
	}
	
	@GetMapping("/admin/adminPage")
	public void adminPage() {
		
	}
}
