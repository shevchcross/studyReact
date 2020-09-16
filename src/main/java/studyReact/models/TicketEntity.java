package studyReact.models;

import lombok.Getter;
import lombok.Setter;
import studyReact.dto.TicketDTO;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Getter
@Setter
public class TicketEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEAT_ID")
    private SeatEntity seat;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEASSION_ID")
    private SessionEntity session;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;


    public TicketEntity() {
    }


}
