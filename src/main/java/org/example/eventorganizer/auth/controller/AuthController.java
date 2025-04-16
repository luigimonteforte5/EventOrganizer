package org.example.eventorganizer.auth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	@GetMapping("/")
	public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
		if (principal != null) {
			model.addAttribute("name", principal.getAttribute("name"));
			model.addAttribute("email", principal.getAttribute("email"));
		}
		return "home";
	}
}