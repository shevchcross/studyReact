package studyReact.dto;

import lombok.Getter;
import lombok.Setter;
import studyReact.models.FilmType;


@Setter
@Getter
public class HallDTO {

    private Long id;

    private String name;

    private Integer totalSeats;

    private FilmType filmType;

    private SessionDTO session;

    private SeatDTO seat;

    public HallDTO() {
    }
}

