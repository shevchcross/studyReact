package studyReact.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class HallEntity {

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)

   private Long id;

   private String name;

   private Integer totalSeats;

   private FilmTypeEntity filmTypeEntity;

   @OneToMany(mappedBy = "filmEntity", cascade = CascadeType.ALL)
   private List<SessionEntity> session;

   @OneToMany(mappedBy = "hallEntity", cascade = CascadeType.ALL)
   private List<SeatEntity> seats;

   public HallEntity() {
   }
}
