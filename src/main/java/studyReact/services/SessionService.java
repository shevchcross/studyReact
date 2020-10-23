package studyReact.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import studyReact.exceptions.SessionNotFoundException;
import studyReact.models.Session;
import studyReact.repository.SessionRepository;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository repository;

    public Session save(Session session) {
        repository.save(session);
        return session;
    }

    public Session getById(Long id) throws SessionNotFoundException {
        Session session = repository.findById(id).orElseThrow(() -> new SessionNotFoundException(id));
        return session;
    }

    public List<Session> findAll() {
        List<Session> seats = repository.findAll();
        return seats;
    }

    public HttpStatus deleteById(Long id) {
        Session session = repository.findById(id).orElse(null);
        repository.delete(session);
        if (session != null) {
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.NOT_FOUND;
    }
}







