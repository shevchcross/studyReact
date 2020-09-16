package studyReact.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SessionDTO {

    private Long id;

    private Double baseCost;

    private Date date;

    private FilmDTO film;

    private HallDTO hall;

    private TicketDTO ticket;

    public SessionDTO() {
    }
}
