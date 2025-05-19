package ma.elamrani.sara.services;

import lombok.AllArgsConstructor;
import ma.elamrani.sara.dtos.ClientDTO;
import ma.elamrani.sara.dtos.CreditDTO;
import ma.elamrani.sara.entities.Client;
import ma.elamrani.sara.entities.Credit;
import ma.elamrani.sara.mappers.CreditBankMapperImpl;
import ma.elamrani.sara.repositories.ClientRepository;
import ma.elamrani.sara.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreditBankServiceImpl implements CreditBankService {
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CreditBankMapperImpl mapper;

    @Override
    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Credit credit = mapper.fromCreditDTO(creditDTO);
        Credit saved = creditRepository.save(credit);
        return mapper.fromCredit(saved);
    }

    @Override
    public CreditDTO getCredit(Long id) {
        Credit credit = creditRepository.findById(id).orElseThrow();
        return mapper.fromCredit(credit);
    }

    @Override
    public List<CreditDTO> listCredits() {
        return creditRepository.findAll().stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);

    }
    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        Client saved = clientRepository.save(client);
        return mapper.fromClient(saved);
    }
    @Override
    public List<ClientDTO> listClients() {
        List<Client> clients = clientRepository.findAll();
        return mapper.fromClientList(clients);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec id = " + id));
        return mapper.fromClient(client);
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return mapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        if(clientDTO.getId() == null) {
            throw new RuntimeException("Client ID must not be null for update.");
        }
        Optional<Client> existingClientOpt = clientRepository.findById(clientDTO.getId());
        if (!existingClientOpt.isPresent()) {
            throw new RuntimeException("Client not found with id: " + clientDTO.getId());
        }
        Client clientToUpdate = existingClientOpt.get();
        // Copier les propriétés depuis DTO vers entité existante (sauf id)
        clientToUpdate.setNom(clientDTO.getNom()); // Exemple : adapter selon tes champs
        clientToUpdate.setEmail(clientDTO.getEmail());
        // Ajoute ici les autres champs à mettre à jour

        Client updatedClient = clientRepository.save(clientToUpdate);
        return mapper.fromClient(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found with id: " + id);
        }
        clientRepository.deleteById(id);
    }

}
