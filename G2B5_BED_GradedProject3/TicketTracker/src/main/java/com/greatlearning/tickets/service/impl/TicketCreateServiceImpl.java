package com.greatlearning.tickets.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketCreateService;

@Service
public class TicketCreateServiceImpl implements TicketCreateService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketCreateServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		ticket.setCreatedate(LocalDate.now().toString());
		return ticketRepository.save(ticket);
	}

}
