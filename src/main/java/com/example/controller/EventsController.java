package com.example.controller;


import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import entity.Event;
import entity.Gift;
import repository.EventsRepository;
import repository.GiftRepository;

/**
 * Classe de controlleur permettant de gérer les évènements et les cadeaux. 
 */
@Controller
public class EventsController {
	//Les attributs 
	private EventsRepository eventRepository = new EventsRepository();
	private GiftRepository giftRepository = new GiftRepository();

	/**
	 * Controlleur fabriquant la page d'administration d'un évènement
	 * - Affiche le détail de l'évènement ;
	 * - Affiche l'ensemble des cadeaux présents dans l'évènement ;
	 * - Propose un formulaire permettant d'ajouter un cadeau à l'évènement.
	 * l'id dans l'URL est l'id de l'évènement à afficher.
	 */
	@GetMapping("/events/{id}/list")
	public String getEvents(Model model, @PathVariable long id) {
		Event currentEvent = eventRepository.findById(id);
		if (currentEvent == null) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'évènement n'existe pas.");
		}
		model.addAttribute("event", currentEvent);	
		model.addAttribute("gift", new Gift());	
		model.addAttribute("giftList", giftRepository.findAllByEventId(id));
		return "events_get";
	}
	
	@PostMapping("/events/{id}/list")
	public String postEvents(Model model,
							@PathVariable long id,
							@ModelAttribute Gift gift
														
	) {
		Event currentEvent = eventRepository.findById(id);
		giftRepository.save(gift.getNom(), gift.getLien(), id);
		return  "redirect:/events/"+ currentEvent.getId()+ "/list";
	}
	
	
	@PostMapping("/events/list/create")
	public String postEvents(Model model,
								@RequestParam String intitule,
								@RequestParam String adresse,
								@RequestParam String message,
								@RequestParam Date dateEvent,
								@RequestParam String occasion
														
	) {
		
		Event createdEvent = eventRepository.save(intitule, adresse,  message, dateEvent, occasion);
		return "redirect:/events/"+ createdEvent.getId()+ "/list";
	}

}
