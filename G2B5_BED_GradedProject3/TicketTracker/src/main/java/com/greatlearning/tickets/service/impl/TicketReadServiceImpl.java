package com.greatlearning.tickets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketReadService;

@Service
public class TicketReadServiceImpl implements TicketReadService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketReadServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> listTickets() {
		return ticketRepository.findAll();
	}

}
