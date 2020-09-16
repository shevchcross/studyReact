package studyReact.repository;

import org.springframework.data.repository.CrudRepository;
import studyReact.models.FilmEntity;
import studyReact.models.TicketEntity;

public interface FilmRepository extends CrudRepository<FilmEntity, Long> {
}
