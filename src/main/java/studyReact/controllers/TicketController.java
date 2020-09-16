package studyReact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyReact.dto.TicketDTO;
import studyReact.models.TicketEntity;
import studyReact.services.TicketService;

import java.math.BigInteger;
import java.util.Map;

@RestController
public class TicketController {
    private static BigInteger nextId;
    private static Map<BigInteger, TicketEntity> ticketMap;


    @Autowired
    private TicketService ticketService;

//    private static TicketEntity save(TicketEntity ticketEntity) {
//        if (ticketMap == null) {
//            ticketMap = new HashMap<BigInteger, TicketEntity>();
//            nextId = BigInteger.ONE;
//        }
//        if (ticketEntity.getId() != null) {
//            TicketEntity oldTicketEntity = ticketMap.get(ticketEntity.getId());
//            if (oldTicketEntity == null) {
//                return null;
//            }
//            ticketMap.remove(ticketEntity.getId());
//            ticketMap.put(ticketEntity.getId(), ticketEntity);
//            return ticketEntity;
//        }
//
//        ticketEntity.setId(nextId);
//        nextId = nextId.add(BigInteger.ONE);
//        ticketMap.put(ticketEntity.getId(), ticketEntity);
//        return ticketEntity;
//    }
//
//    private static boolean delete(BigInteger id) {
//        TicketEntity deletedTicketEntity = ticketMap.remove(id);
//        if (deletedTicketEntity == null) {
//            return false;
//        }
//        return true;
//    }
//
//    static {
//        TicketEntity ticketEntity1 = new TicketEntity();
//        ticketEntity1.setNamePerformance("Zolushka");
//        save(ticketEntity1);
//
//        TicketEntity ticketEntity2 = new TicketEntity();
//        ticketEntity2.setNamePerformance("Shreck");
//        save(ticketEntity2);
//    }
//
//    @RequestMapping(
//            value = "/api/gettickets",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<Collection<TicketEntity>> getTickets() {
//        Collection<TicketEntity> ticketEntities = ticketMap.values();
//        return new ResponseEntity<Collection<TicketEntity>>(ticketEntities, HttpStatus.OK);
//    }
//
//    @RequestMapping(
//            value = "/api/getticket/{id}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<TicketEntity> getTicket(@PathVariable("id") BigInteger id) {
//        TicketEntity ticketEntity = ticketMap.get(id);
//        if (ticketEntity == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<TicketEntity>(ticketEntity, HttpStatus.OK);
////    }
//
//    @RequestMapping(
//            value = "/api/gettickets",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticket) {
//        TicketDTO savedTicketEntity = ticketService.save(ticket);
//        return new ResponseEntity<TicketDTO>(savedTicketEntity, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(
//            value = "/api/getticket/{id}",
//            method = RequestMethod.PUT,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<TicketDTO> updateTicket(@RequestBody TicketDTO ticket) {
//        TicketDTO updadedTicket = ticketService.updateTicket(ticket);
//        if (updadedTicket == null) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<TicketDTO>(updadedTicket, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(
//            value = "/api/getticket/{id}",
//            method = RequestMethod.DELETE,
//            consumes = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<TicketDTO> deleteTicket(@PathVariable("id") BigInteger id, @RequestBody TicketDTO ticketEntity) {
//        TicketDTO deletedTicket = ticketService.deleteTicket(id);
//        if (deletedTicket == null) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<TicketDTO>(HttpStatus.CREATED);
//    }


}
