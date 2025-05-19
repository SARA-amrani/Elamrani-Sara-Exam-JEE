package ma.elamrani.sara.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CI")
public class CreditImmobilier extends Credit {
    private String typeBien; // Exemple : "Appartement", "Maison", "Local Commercial"
}
