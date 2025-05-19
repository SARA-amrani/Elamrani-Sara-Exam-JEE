package ma.elamrani.sara.dtos;


import lombok.Data;
import ma.elamrani.sara.enums.StatutCredit;

import java.util.Date;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;

    private Date dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement; // en mois
    private Double tauxInteret;
    private ClientDTO client;
}

