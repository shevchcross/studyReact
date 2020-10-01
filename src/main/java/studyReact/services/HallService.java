package studyReact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studyReact.exceptions.HallNotFoundException;
import studyReact.models.Hall;
import studyReact.repository.HallRepository;

import java.util.List;

@Service
public class HallService {

    @Autowired
    private HallRepository repository;

    public Hall save(Hall hall) {
        repository.save(hall);
        return hall;
    }

    public Hall getById(Long id) {
        Hall hall = repository.findById(id).orElse(new Hall());
        return hall;
    }


    public List<Hall> findAll() {
        List<Hall> halls = repository.findAll();
        return halls;
    }


    public Hall halldById(Long id) throws HallNotFoundException {
        Hall halldById = repository.findById(id).orElseThrow(() -> new HallNotFoundException(id));
        return halldById;
    }

//    public Hall findHallByName(String name) throws HallNotFoundException {
//        Hall findHallByName = repository.hallByName(name).orElseThrow(() -> new HallNotFoundException(name));
//        return findHallByName;
//    }

    public Hall delete(Long id) throws HallNotFoundException {
        Hall hallById = repository.findById(id).orElseThrow(() -> new HallNotFoundException(id));
        repository.delete(hallById);
        return hallById;
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
