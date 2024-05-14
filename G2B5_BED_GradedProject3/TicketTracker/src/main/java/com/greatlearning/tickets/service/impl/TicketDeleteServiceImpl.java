package com.greatlearning.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketDeleteService;

@Service
public class TicketDeleteServiceImpl implements TicketDeleteService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketDeleteServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public void deleteById(int id) {
		ticketRepository.deleteById(id);

	}
}
