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

}
