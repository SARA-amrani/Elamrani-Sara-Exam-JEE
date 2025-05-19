package ma.elamrani.sara.dtos;

import lombok.Data;
import ma.elamrani.sara.enums.RemboursementType;

import java.util.Date;


@Data
public class RemboursementDTO {

    private Long id;
    private Date date;
    private Double montant;
    private RemboursementType type;
    private CreditDTO credit;
}