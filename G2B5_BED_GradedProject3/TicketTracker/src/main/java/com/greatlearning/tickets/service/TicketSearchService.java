package com.greatlearning.tickets.service;

import java.util.List;

import com.greatlearning.tickets.entity.Ticket;

public interface TicketSearchService {

	List<Ticket> searchTicket(String keyword);

}
