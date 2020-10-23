package studyReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyReact.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
