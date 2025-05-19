package ma.elamrani.sara.web;


import lombok.AllArgsConstructor;
import ma.elamrani.sara.dtos.ClientDTO;
import ma.elamrani.sara.dtos.CreditDTO;
import ma.elamrani.sara.services.CreditBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CreditRestController {

    @Autowired
    private CreditBankService creditBankService;

    @GetMapping("/credits")
    public List<CreditDTO> getAllCredits() {
        return creditBankService.listCredits();
    }

    @GetMapping("/credits/{id}")
    public CreditDTO getCredit(@PathVariable Long id) {
        return creditBankService.getCredit(id);
    }

    @PostMapping("/credits")
    public CreditDTO saveCredit(@RequestBody CreditDTO creditDTO) {
        return creditBankService.saveCredit(creditDTO);
    }

    @DeleteMapping("/credits/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditBankService.deleteCredit(id);
    }

    // Liste tous les clients
    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return creditBankService.listClients();
    }

    // Client par ID
    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return creditBankService.getClientById(id);  // à implémenter dans service si pas encore fait
    }

    // Créer client
    @PostMapping("/clients")
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return creditBankService.saveClient(clientDTO);
    }

    // Mettre à jour client
    @PutMapping("/clients/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO.setId(id);
        return creditBankService.updateClient(clientDTO);
    }

    // Supprimer client
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        creditBankService.deleteClient(id);
    }

}
