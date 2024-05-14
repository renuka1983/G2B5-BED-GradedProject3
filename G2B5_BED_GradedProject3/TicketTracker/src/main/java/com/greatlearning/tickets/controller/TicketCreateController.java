package com.greatlearning.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.service.TicketCreateService;

@Controller
@RequestMapping("/tickets")
public class TicketCreateController {

	@Autowired
	private TicketCreateService ticketCreateService;

	public TicketCreateController(TicketCreateService ticketCreateService) {

		this.ticketCreateService = ticketCreateService;
	}

	@GetMapping("/newTicket")
	public String addTicketButtonClick(Model model) {
		Ticket tickets = new Ticket();
		model.addAttribute("ticket", tickets);
		return "create-ticket";
	}

	@PostMapping
	public String submitButtonClickforAdd(@ModelAttribute("ticket") Ticket ticket) {
		ticketCreateService.saveTicket(ticket);
		return "redirect:/tickets";
	}

}
