package studyReact.repository;

import org.springframework.data.repository.CrudRepository;
import studyReact.models.TicketEntity;




public interface TicketRepository  extends CrudRepository<TicketEntity, Long> {
}
