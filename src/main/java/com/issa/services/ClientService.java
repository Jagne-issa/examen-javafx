package main.java.com.issa.services;

import com.issa.entities.Client;
import com.issa.repositories.ClientRepository;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public Client getClientByPhoneNumber(String phoneNumber) {
        return clientRepository.findClientByPhoneNumber(phoneNumber);
    }
}









// package main.java.com.issa.services;

// import com.issa.entities.Client;
// import com.issa.repositories.ClientRepository;

// import java.util.List;

// public class ClientService {
//     private final ClientRepository clientRepository;

//     public ClientService(ClientRepository clientRepository) {
//         this.clientRepository = clientRepository;
//     }

//     public void ajouterClient(Client client) {
//         clientRepository.save(client);
//     }

//     public Client rechercherParTelephone(String telephone) {
//         try {
//             return clientRepository.findByTelephone(telephone);
//         } catch (Exception e) {
//             System.out.println("Client introuvable !");
//             return null;
//         }
//     }

//     public List<Client> listerClients() {
//         return clientRepository.findAll();
//     }
// }
