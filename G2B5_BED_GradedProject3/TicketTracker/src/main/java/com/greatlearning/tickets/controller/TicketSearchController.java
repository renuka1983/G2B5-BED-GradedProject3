package com.greatlearning.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.service.TicketSearchService;
import com.greatlearning.tickets.service.TicketUpdateService;

@Controller
@RequestMapping("/tickets")
public class TicketSearchController {

	@Autowired
	private TicketSearchService ticketSearchService;

	@Autowired
	private TicketUpdateService ticketUpdateService;

	public TicketSearchController(TicketSearchService ticketSearchService, TicketUpdateService ticketUpdateService) {

		this.ticketSearchService = ticketSearchService;
		this.ticketUpdateService = ticketUpdateService;
	}

	@GetMapping("/search/{searchString}")
	public String searchTickets(@PathVariable String searchString, Model model) {
		List<Ticket> tickets = ticketSearchService.searchTicket(searchString);
		model.addAttribute("tickets", tickets);
		model.addAttribute("searchString", searchString);
		return "Tickets";
	}

	@GetMapping("/search/")
	public String searchdefTickets() {
		return "redirect:/tickets";
	}

	@GetMapping("/{id}/view")
	public String viewTicketButtonClicked(@PathVariable int id, Model model) {

		Ticket selectedTicket = ticketUpdateService.getTicketById(id);

		model.addAttribute("ticket", selectedTicket);

		return "view-ticket";
	}

}
