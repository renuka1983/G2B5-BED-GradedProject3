package com.greatlearning.tickets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickets.entity.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketSearchService;

@Service
public class TicketSearchServiceImpl implements TicketSearchService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketSearchServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> searchTicket(String keyword) {
		List<Ticket> searchResult = ticketRepository.findByTitleContainsOrDescriptionContainsIgnoreCase(keyword,
				keyword);
		return searchResult;
	}

}
