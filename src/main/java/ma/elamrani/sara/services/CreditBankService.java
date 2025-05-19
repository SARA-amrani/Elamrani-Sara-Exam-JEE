package ma.elamrani.sara.services;

import ma.elamrani.sara.dtos.ClientDTO;
import ma.elamrani.sara.dtos.CreditDTO;

import java.util.List;

public interface CreditBankService {
    CreditDTO saveCredit(CreditDTO creditDTO);
    CreditDTO getCredit(Long id);
    List<CreditDTO> listCredits();
    void deleteCredit(Long id);

    ClientDTO save(ClientDTO clientDTO);

    List<ClientDTO> listClients();

    ClientDTO getClientById(Long id);

    ClientDTO saveClient(ClientDTO clientDTO);

    ClientDTO updateClient(ClientDTO clientDTO);

    void deleteClient(Long id);
}
