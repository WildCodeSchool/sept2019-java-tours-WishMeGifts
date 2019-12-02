package com.example.controller;


import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Event;
import entity.Gift;
import repository.EventsRepository;
import repository.GiftRepository;


@Controller
public class EventsController {
		private EventsRepository repository = new EventsRepository();
		private GiftRepository giftrepository = new GiftRepository();

		@GetMapping("/events/{id}/list")
	    public String getEvents(Model model, @PathVariable long id) {
			Event currentEvent = repository.findById(id);
	        model.addAttribute("event", currentEvent);	
	    	model.addAttribute("gift", new Gift());	
	    	model.addAttribute("giftList", giftrepository.findByEventId(currentEvent.getId()));	
	        return "events_get";
	    }
		
	    @PostMapping("/events/{id}/list")
	    public String postEvents(Model model,
	    						@PathVariable long id,
	    						@ModelAttribute Gift gift
                          	                             
	    ) {
			Event currentEvent = repository.findById(id);
			giftrepository.save(gift.getNom(), gift.getLien(), id);
	        return  "redirect:/events/"+ currentEvent.getId()+ "/list";
	    }
	    
	    @GetMapping("/events/{id}/list/delete")
	    public String deleteGift(@RequestParam Long id) {
	    	Event currentEvent = repository.findById(id);
	        giftrepository.deleteById(id);

	        return "redirect:/events/"+ currentEvent.getId()+ "/list";
	    }
	    
	    @PostMapping("/events/list/create")
	    public String postEvents(Model model,
	                             @RequestParam String intitule,
	                             @RequestParam String adresse,
	                             @RequestParam String message,
	                             @RequestParam Date dateEvent,
	                             @RequestParam String occasion
                          	                             
	    ) {
	        
	    	Event createdEvent = repository.save(intitule, adresse,  message, dateEvent, occasion);
//	    	model.addAttribute("event", createdEvent);	
//	    	model.addAttribute("gift", new Gift());	
//	    	model.addAttribute("giftList", null);	
	        return "redirect:/events/"+ createdEvent.getId()+ "/list";
	    }

}
