package studyReact.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class SeatEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private SeatTypeEntity seatType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "HALL_ID")
    private HallEntity hallEntity;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;

    public SeatEntity() {
    }
}
