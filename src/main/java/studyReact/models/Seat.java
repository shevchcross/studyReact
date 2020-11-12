package studyReact.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Seat {

    @Column(name="MY_SEAT_ID")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="MY_SEAT_SEATTYPE")
    private SeatType seatType;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "HALL_ID")
    private Hall hall;


    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;

    public Seat() {
    }
}
