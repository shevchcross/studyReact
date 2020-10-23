package studyReact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import studyReact.exceptions.SeatNotFoundException;
import studyReact.models.Seat;
import studyReact.repository.SeatRepository;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository repository;


    public Seat save(Seat seat) {
        repository.save(seat);
        return seat;
    }

    public Seat getById(Long id) throws SeatNotFoundException {
        Seat seat = repository.findById(id).orElseThrow(()-> new SeatNotFoundException(id));
        return seat;
    }

    public List<Seat> findAll() {
        List<Seat> seats = repository.findAll();
        return seats;
    }

    public HttpStatus delete(Long id) throws SeatNotFoundException {
        Seat seat = repository.findById(id).orElse(null);
        repository.delete(seat);
        if (seat != null) {
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.NOT_FOUND;
    }
}
