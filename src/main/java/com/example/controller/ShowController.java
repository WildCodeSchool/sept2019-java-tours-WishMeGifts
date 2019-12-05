package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import entity.Event;
import entity.Gift;
import repository.EventsRepository;
import repository.GiftRepository;


@Controller 
public class ShowController { 
	  private EventsRepository eventRepository = new EventsRepository();
	  private GiftRepository giftRepository = new GiftRepository();
	  
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
	  
	  
	  @GetMapping("/events/{id}/show")
		public String showGifts(Model model, @PathVariable long id) {
			Event currentEvent = eventRepository.findById(id);
			if (currentEvent == null) 
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cette page n'existe pas.");
			}
			model.addAttribute("event", currentEvent);	
			model.addAttribute("gift", new Gift());	
			model.addAttribute("giftList", giftRepository.findAllByEventId(id));
			return "show";
		}
	  
	  
	  @GetMapping("/gift/delete")
	    public String deleteGift(@RequestParam long id) {
		    Event currentEvent = eventRepository.findById(id);
	        giftRepository.deleteById(id);

	        return  "redirect:/events/"+ currentEvent.getId()+ "/list";
	    }
	 

 }
 

  
 
	 
	 
   
