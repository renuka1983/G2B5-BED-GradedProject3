package com.greatlearning.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.service.TicketUpdateService;

@Controller
public class TicketUpdateController {

	@Autowired
	private TicketUpdateService ticketUpdateService;

	public TicketUpdateController(TicketUpdateService ticketUpdateService) {

		this.ticketUpdateService = ticketUpdateService;
	}

	@GetMapping("/tickets/{id}/edit")
	public String updateTicketButtonClicked(@PathVariable int id, Model model) {

		Ticket selectedTicket = ticketUpdateService.getTicketById(id);

		model.addAttribute("ticket", selectedTicket);

		return "edit-ticket";
	}

	@PostMapping("/tickets/{id}/edit")
	public String submitButtonClickedForUpdateTicket(@PathVariable int id, @ModelAttribute("ticket") Ticket ticket) {

		// Update the ticket object
		Ticket existingTicketObj = ticketUpdateService.getTicketById(id);

		existingTicketObj.setTitle(ticket.getTitle());
		existingTicketObj.setDescription(ticket.getDescription());
		existingTicketObj.setContent(ticket.getContent());

		ticketUpdateService.updateTicket(ticket);

		return "redirect:/tickets";
	}

	// Update Ticket - End

}
