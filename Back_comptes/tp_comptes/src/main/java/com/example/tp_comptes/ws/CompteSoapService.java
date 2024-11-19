package com.example.tp_comptes.ws;


import com.example.tp_comptes.entities.Compte;
import com.example.tp_comptes.entities.TypeCompte;
import com.example.tp_comptes.repositories.CompteRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {

    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }


    @WebMethod
    public Compte getCompteById(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).orElse(null);
    }

    @WebMethod
    public Compte createCompte(@WebParam(name = "type")TypeCompte type, @WebParam(name = "solde") double solde){
        Compte compte = new Compte(null, solde, new Date(), type);
        System.out.println("Created Compte with Date: " + compte.getDateCreation());  // Log date

        return compteRepository.save(compte);
    }

    @WebMethod
    public boolean deleteCompte(@WebParam(name = "id") Long id){
        if(compteRepository.existsById(id)){
            compteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
