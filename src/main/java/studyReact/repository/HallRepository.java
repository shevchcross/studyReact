package studyReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyReact.models.Hall;

import java.util.Optional;

public interface HallRepository extends JpaRepository<Hall, Long> {
//    Optional<Hall> hallByName(String name);
}
