package studyReact.dto;

import lombok.Getter;
import lombok.Setter;
import studyReact.models.SeatTypeEntity;

import javax.persistence.Entity;

@Setter
@Getter
public class SeatDTO {

    private Long id;

    private SeatTypeEntity seatType;

    private HallDTO hall;

    private TicketDTO ticket;

    public SeatDTO() {
    }
}

