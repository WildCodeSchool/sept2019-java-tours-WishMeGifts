package com.example.demo;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import entity.Gift;
import repository.GiftRepository;

public class GiftController {
	
	
	  private GiftRepository repository = new GiftRepository();
	  
	  @PostMapping("/events/list") public String postGift(Model model,
	  
	  @RequestParam String nom,
	  
	  @RequestParam String lien
	  
	  ) { model.addAttribute("gift", repository.save(nom, lien));
	  
	  return "events_get"; }
	 
    

}
