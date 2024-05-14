package com.greatlearning.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.service.TicketReadService;

@Controller
@RequestMapping("/tickets")
public class TicketReadController {

	@Autowired
	private TicketReadService ticketReadService;

	public TicketReadController(TicketReadService ticketReadService) {

		this.ticketReadService = ticketReadService;
	}

	@GetMapping
	public String listTickets(Model model) {

		List<Ticket> tickets = ticketReadService.listTickets();

		model.addAttribute("tickets", tickets);

		return "Tickets";
	}

}
