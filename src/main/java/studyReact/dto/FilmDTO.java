package studyReact.dto;


import lombok.Getter;
import lombok.Setter;
import studyReact.models.FilmType;


@Setter
@Getter
public class FilmDTO {

    private Long id;

    private Long duration;

    private FilmType filmType;

    private SessionDTO session;

    public FilmDTO() {
    }
}
