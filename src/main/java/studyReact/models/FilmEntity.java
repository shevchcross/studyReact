package studyReact.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class FilmEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long duration;

    private String name;

    private FilmTypeEntity filmType;

    @OneToMany(mappedBy = "hallEntity", cascade = CascadeType.ALL)
    private List<SessionEntity> session;

    public FilmEntity() {
    }
}
