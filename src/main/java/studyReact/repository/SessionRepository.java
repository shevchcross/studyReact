package studyReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyReact.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
