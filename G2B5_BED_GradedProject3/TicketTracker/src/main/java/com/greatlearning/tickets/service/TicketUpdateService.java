package com.greatlearning.tickets.service;

import com.greatlearning.tickets.entity.Ticket;

public interface TicketUpdateService {

	Ticket getTicketById(int id);

	Ticket updateTicket(Ticket Ticket);
}
