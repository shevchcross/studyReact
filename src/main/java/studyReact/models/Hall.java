package studyReact.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Hall {


   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;


   private String name;


   private Integer totalSeats;


   private FilmType filmType;

   @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
   private List<Session> session;

   @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
   private List<Seat> seats;

   public Hall() {
   }
}
