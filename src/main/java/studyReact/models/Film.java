package studyReact.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Film {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_id")
    @SequenceGenerator(name = "film_id", sequenceName = "film_id", initialValue = 1, allocationSize = 1)
    private Long id;


    private Long duration;


    private String name;


    private FilmType filmType;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Session> session;

    public Film() {
    }
}
