package ma.elamrani.sara.repositories;

import ma.elamrani.sara.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier,Long> {
}
