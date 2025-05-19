package ma.elamrani.sara;

import ma.elamrani.sara.entities.Client;
import ma.elamrani.sara.entities.CreditImmobilier;
import ma.elamrani.sara.entities.CreditPersonnel;
import ma.elamrani.sara.entities.Remboursement;
import ma.elamrani.sara.enums.RemboursementType;
import ma.elamrani.sara.enums.StatutCredit;
import ma.elamrani.sara.repositories.ClientRepository;
import ma.elamrani.sara.repositories.CreditRepository;
import ma.elamrani.sara.repositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CreditBank implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CreditBank.class, args);
    }

    private ClientRepository clientRepository;
    private CreditRepository creditRepository;
    private RemboursementRepository remboursementRepository;

    public CreditBank(ClientRepository clientRepository,
                           CreditRepository creditRepository,
                           RemboursementRepository remboursementRepository) {
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.remboursementRepository = remboursementRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Création de clients
        Client client1 = new Client(null, "Sara El amrani", "sara@email.com", null);
        Client client2 = new Client(null, "Aya El amrani", "aya@email.com", null);
        clientRepository.saveAll(List.of(client1, client2));

        // Crédit personnel pour Sara
        CreditPersonnel credit1 = new CreditPersonnel();
        credit1.setDateDemande(new Date());
        credit1.setStatut(StatutCredit.EN_COURS);
        credit1.setMontant(100000.0);
        credit1.setDureeRemboursement(24);
        credit1.setTauxInteret(4.5);
        credit1.setDateAcceptation(new Date());
        credit1.setMotif("Achat voiture");
        credit1.setClient(client1);
        creditRepository.save(credit1);

        //  Crédit immobilier pour Aya
        CreditImmobilier credit2 = new CreditImmobilier();
        credit2.setDateDemande(new Date());
        credit2.setStatut(StatutCredit.ACCEPTE);
        credit2.setMontant(500000.0);
        credit2.setDureeRemboursement(120);
        credit2.setTauxInteret(3.8);
        credit2.setDateAcceptation(new Date());
        credit2.setTypeBien("Maison");
        credit2.setClient(client2);
        creditRepository.save(credit2);

        //  Ajouter des remboursements pour le 1er crédit
        Remboursement r1 = new Remboursement(null, new Date(), 4500.0, RemboursementType.MENSUALITE, credit1);
        Remboursement r2 = new Remboursement(null, new Date(), 4500.0, RemboursementType.MENSUALITE, credit1);
        remboursementRepository.saveAll(List.of(r1, r2));


    }


}
