package studyReact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyReact.dto.TicketDTO;
import studyReact.models.TicketEntity;
import studyReact.repository.TicketRepository;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
//
//    public TicketDTO save(TicketDTO ticket) {
//        TicketEntity ticketToSave = new TicketEntity(ticket);
//        TicketEntity savedTicket = ticketRepository.save(ticketToSave);
//        return new TicketDTO(savedTicket);
//    }
//
//    public TicketDTO updateTicket(TicketDTO ticket) {
//        TicketEntity ticketToSave = new TicketEntity(ticket);
//        TicketEntity savedTicket = ticketRepository.save(ticketToSave);
//        return new TicketDTO(savedTicket);
//    }
//
//    public TicketDTO deleteTicket(BigInteger id) {
//        Optional<TicketEntity> existedTicket = ticketRepository.findById(id);
//        if (existedTicket == null) {
//            return null;
//        }
//        TicketEntity ticket = existedTicket.get();
//        ticketRepository.delete(ticket);
//        return new TicketDTO(ticket);
//
//    }
}
