package studyReact.dto;


import lombok.Getter;
import lombok.Setter;
import studyReact.models.FilmTypeEntity;


@Setter
@Getter
public class FilmDTO {

    private Long id;

    private Long duration;

    private FilmTypeEntity filmType;

    private SessionDTO session;

    public FilmDTO() {
    }
}
