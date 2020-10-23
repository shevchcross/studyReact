package studyReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyReact.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
