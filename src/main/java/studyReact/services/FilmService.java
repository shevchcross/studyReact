package studyReact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyReact.dto.TicketDTO;
import studyReact.models.FilmEntity;
import studyReact.repository.FilmRepository;
import studyReact.repository.TicketRepository;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public FilmEntity save(FilmEntity film) {
        filmRepository.save(film);
        return film;
    }


    public FilmEntity getById(Long id) {
        FilmEntity film = filmRepository.findById(id).orElse(new FilmEntity());
        return film;
    }
}
