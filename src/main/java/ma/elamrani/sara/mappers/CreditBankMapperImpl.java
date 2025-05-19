package ma.elamrani.sara.mappers;

import ma.elamrani.sara.dtos.*;
import ma.elamrani.sara.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CreditBankMapperImpl {

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }
    public List<ClientDTO> fromClientList(List<Client> clients) {
        return clients.stream()
                .map(this::fromClient)
                .collect(Collectors.toList());
    }

    public CreditDTO fromCredit(Credit credit) {
        if (credit instanceof CreditImmobilier) {
            CreditImmobilierDTO dto = new CreditImmobilierDTO();
            BeanUtils.copyProperties(credit, dto);
            return dto;
        } else if (credit instanceof CreditPersonnel) {
            CreditPersonnelDTO dto = new CreditPersonnelDTO();
            BeanUtils.copyProperties(credit, dto);
            return dto;
        } else if (credit instanceof CreditProfessionnel) {
            CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
            BeanUtils.copyProperties(credit, dto);
            return dto;
        } else {
            throw new IllegalArgumentException("Type de crédit inconnu : " + credit.getClass().getSimpleName());
        }
    }

    public Credit fromCreditDTO(CreditDTO creditDTO) {
        if (creditDTO instanceof CreditImmobilierDTO) {
            CreditImmobilier credit = new CreditImmobilier();
            BeanUtils.copyProperties(creditDTO, credit);
            return credit;
        } else if (creditDTO instanceof CreditPersonnelDTO) {
            CreditPersonnel credit = new CreditPersonnel();
            BeanUtils.copyProperties(creditDTO, credit);
            return credit;
        } else if (creditDTO instanceof CreditProfessionnelDTO) {
            CreditProfessionnel credit = new CreditProfessionnel();
            BeanUtils.copyProperties(creditDTO, credit);
            return credit;
        } else {
            throw new IllegalArgumentException("Type de DTO inconnu : " + creditDTO.getClass().getSimpleName());
        }
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);
        return dto;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto) {
        CreditImmobilier credit = new CreditImmobilier();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);
        return dto;
    }

    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto) {
        CreditPersonnel credit = new CreditPersonnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);
        return dto;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto) {
        CreditProfessionnel credit = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        return dto;
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(dto, remboursement);
        return remboursement;
    }
}
