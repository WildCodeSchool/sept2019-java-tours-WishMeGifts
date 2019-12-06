package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import entity.Event;

import repository.EventsRepository;



@Controller 
public class ShowController { 
	  private EventsRepository eventRepository = new EventsRepository();
	 
	  
	  @GetMapping("/events/{id}/showEvent")
		public String showEvent(Model model, @PathVariable long id) {
			Event currentEvent = eventRepository.findById(id);
			if (currentEvent == null) 
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'évènement n'existe pas.");
			}
			model.addAttribute("event", currentEvent);	
			
			return "show";
		}
	  
	  
	 

 }
 

  
 
	 
	 
   
