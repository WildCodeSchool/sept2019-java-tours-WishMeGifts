package com.example.demo;



import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import repository.EventsRepository;


@Controller
public class EventsController {
		private EventsRepository repository = new EventsRepository();
		
		
	    @PostMapping("/events/list")
	    public String postEvents(Model model,
	    		                 
	                             @RequestParam String intitule,
	                             @RequestParam String adresse,
	                             @RequestParam String message,
	                             @RequestParam Date dateEvents,
	                             @RequestParam String occasion
	                            
	                             
	    ) {
	        
	        
	    	model.addAttribute("events", repository.save(intitule, adresse,  message, dateEvents, occasion));
	    	
			
			
	        return "events_get";
	        
	    }

}
