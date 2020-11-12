package studyReact.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Hall {

   @Column(name="MY_HALL_ID")
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;

   @Column(name="MY_HALL_NAME")
   private String name;

   @Column(name="MY_HALL_TOTALSEATS")
   private Integer totalSeats;

   @Column(name="MY_HALL_FILMTYPE")
   private FilmType filmType;

   @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
   private List<Session> session;

   @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
   private List<Seat> seats;

   public Hall() {
   }
}
