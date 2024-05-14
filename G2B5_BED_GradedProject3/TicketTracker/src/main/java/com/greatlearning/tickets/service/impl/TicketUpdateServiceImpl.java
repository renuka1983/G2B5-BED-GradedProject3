package com.greatlearning.tickets.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketUpdateService;

@Service
public class TicketUpdateServiceImpl implements TicketUpdateService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketUpdateServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		ticket.setCreatedate(LocalDate.now().toString());
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepository.findById(id).get();
	}
}
