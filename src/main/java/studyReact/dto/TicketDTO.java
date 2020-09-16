package studyReact.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class TicketDTO {

    private Long id;

    private SessionDTO session;

    private SeatDTO seat;

    public TicketDTO() {
    }


}
