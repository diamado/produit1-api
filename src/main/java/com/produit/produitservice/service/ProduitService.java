package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id) {
        Optional<Produit> optionalproduit= produitRepository.findById(id);
        if(optionalproduit.isEmpty()){
            throw new RuntimeException("Désole produit inexistant");

        }else{
            return optionalproduit.get();
        }
    }

    public String deleteProduitById(long idProduit) {
        Optional<Produit> optionalProduit= produitRepository.findById(idProduit);

        if(optionalProduit.isEmpty()){
            throw  new RuntimeException(("suppression de produit est impossible!"));
        }else{
            produitRepository.delete(optionalProduit.get());
            return "produit supprimer avec succés !";
        }
    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit= produitRepository.findById(id);

        if(optionalProduit.isEmpty()){
            throw  new RuntimeException("Mise à jour impossible !");
        }else{
            Produit produitModifier = optionalProduit.get();
            produitModifier.setName(produit.getName());
            produitModifier.setPrice(produit.getPrice());
            return produitRepository.save(produitModifier);
        }
    }
}
