package studyReact.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class SessionEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Double baseCost;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "HALL_ID")
    private HallEntity hallEntity;

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FILM_ID")
    private FilmEntity filmEntity;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;

    public SessionEntity() {
    }
}
