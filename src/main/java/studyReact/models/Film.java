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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long duration;

    private String name;

    private FilmType filmType;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Session> session;

    public Film() {
    }
}
