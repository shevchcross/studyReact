package studyReact.dto;

import lombok.Getter;
import lombok.Setter;
import studyReact.models.SeatType;

@Setter
@Getter
public class SeatDTO {

    private Long id;

    private SeatType seatType;

    private HallDTO hall;

    private TicketDTO ticket;

    public SeatDTO() {
    }
}

