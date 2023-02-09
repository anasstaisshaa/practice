package edu.AnastasiiaTkachuk.service;

import edu.AnastasiiaTkachuk.dao.TicketDao;
import edu.AnastasiiaTkachuk.dto.TicketDto;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@NoArgsConstructor
public class TicketService {
    private static final TicketService INSTANCE = new TicketService();
    private final TicketDao ticketDao = TicketDao.getInstance();

    public List<TicketDto> findAllByFlightId(Long flightId){
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()
                ))
                .collect(toList());
    }

    public static TicketService getInstance(){
        return INSTANCE;
    }
}
