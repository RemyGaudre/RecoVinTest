package ctie.dmf.RecoVinApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ctie.dmf.RecoVinApplication.repository.WineRepository;
import ctie.dmf.RecoVinApplication.security.MyUserDetails;

@Controller
public class MyController {
	
	@Autowired
	WineRepository winerepository;

	@GetMapping("/welcomePage")
	public String viewWelcomePage(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
		model.addAttribute("user", userDetails.getUser());
		model.addAttribute("wines",winerepository.findAll());
		return "welcomePage";
	}
}
