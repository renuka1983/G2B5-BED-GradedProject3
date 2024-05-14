package com.greatlearning.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.greatlearning.tickets.service.TicketDeleteService;

@Controller
public class TicketDeleteController {

	@Autowired
	private TicketDeleteService ticketDeleteService;

	public TicketDeleteController(TicketDeleteService ticketDeleteService) {

		this.ticketDeleteService = ticketDeleteService;
	}

	@GetMapping("/tickets/{id}/delete")
	public String deleteTicket(@PathVariable int id) {

		ticketDeleteService.deleteById(id);
		return "redirect:/tickets";
	}
}
