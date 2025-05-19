package ma.elamrani.sara.repositories;

import ma.elamrani.sara.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findByClientId(Long clientId);

}
