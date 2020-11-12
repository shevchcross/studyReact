package studyReact.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class TicketEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEASSION_ID")
    private Session session;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;


    public TicketEntity() {
    }


}
