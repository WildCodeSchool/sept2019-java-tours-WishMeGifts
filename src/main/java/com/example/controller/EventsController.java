package com.example.controller;


import java.sql.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	private final EventsRepository eventRepository = new EventsRepository();
	private final GiftRepository giftRepository = new GiftRepository();

	/**
	 * Controlleur fabriquant la page d'administration d'un évènement - Affiche le
	 * détail de l'évènement ; - Affiche l'ensemble des cadeaux présents dans
	 * l'évènement ; - Propose un formulaire permettant d'ajouter un cadeau à
	 * l'évènement. l'id dans l'URL est l'id de l'évènement à afficher.
	 */
	// Recupere la liste des cadeaux pour l'evenement d'identité id
	@GetMapping("/events/{id}/list")
	public String getEvents(final Model model, @PathVariable final long id,
			@RequestParam(required = false) final Long giftId) {
		final Event currentEvent = eventRepository.findById(id);

		if (currentEvent == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'évènement n'existe pas.");
		}

		model.addAttribute("event", currentEvent);

		Gift currentGift = new Gift();
		if (giftId != null) {
			currentGift = giftRepository.findById(giftId);
		}
		model.addAttribute("gift", currentGift);
		model.addAttribute("giftList", giftRepository.findAllByEventId(id));

		return "events_get";
	}

	// Recupere la liste des cadeaux pour l'evenement d'identité id
	@GetMapping("/events/{id}/show")
	public String getEventList(final Model model, @PathVariable final long id) {
		final Event currentEvent = eventRepository.findById(id);

		if (currentEvent == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'évènement n'existe pas.");
		}

		model.addAttribute("event", currentEvent);
		// model.addAttribute("gift", new Gift());
		model.addAttribute("giftList", giftRepository.findAllByEventId(id));

		return "show";
	}

	// Enregistre un nouveau cadeau dans la liste des cadeaux appartenant
	// A l'evenement de l'id currentEvent.getId()
	@PostMapping("/events/{id}/list")
	public String postEvents(final Model model, @PathVariable final long id, @ModelAttribute final Gift gift) {
		final Event currentEvent = eventRepository.findById(id);
		giftRepository.save(gift.getNom(), gift.getLien(), id);
		return "redirect:/events/" + currentEvent.getId() + "/list";
	}

	// Enreristre un nouvel Evenement
	@PostMapping("/events/list/create")
	public String postEvents(final Model model, @RequestParam final String intitule, @RequestParam final String adresse,
			@RequestParam final String message, @RequestParam final Date dateEvent, @RequestParam final String occasion

	) {

		final Event createdEvent = eventRepository.save(intitule, adresse, message, dateEvent, occasion);
		return "redirect:/events/" + createdEvent.getId() + "/list";
	}

	@GetMapping("/events/{id}/list/delete")
	public String delete(@PathVariable final long id, final long idGift) {

		giftRepository.deleteById(idGift);

		return "redirect:/events/" + id + "/list";
	}

	@GetMapping("/events/{id}/gift")
	public String editGift(@PathVariable final long id, @RequestParam final long idGift, final Model model) {
		// I get the event by id from database
		final Event event = eventRepository.findById(id);
		// I check the return
		if (event == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
		}

		final Gift gift = giftRepository.findById(idGift);
		if (gift == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gift not found");
		}

		// Passing variable to the view using the model
		model.addAttribute("event", event);
		model.addAttribute("gift", gift);

		return "update_gift.html";
	}

	@PostMapping("/events/{id}/gift")
	public String editGift(@Valid final Gift gift, final BindingResult bindingResult, @PathVariable final long id,
			final Model model) {
		if (bindingResult.hasErrors()) {
			// I get the event by id from database
			final Event event = eventRepository.findById(id);
        	// I check the return
        	if(event == null) {
        		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Event not found");
        	}
    		return "update_gift";
    	}
    	
    	if (null != giftRepository.update(gift.getNom(), gift.getLien(), gift.getId_event_list(), gift.getId())) {
    		return "redirect:/events/"+ id+ "/list";
    	}
    	return "Home.html"; // Should redirect to an error page
    }
}