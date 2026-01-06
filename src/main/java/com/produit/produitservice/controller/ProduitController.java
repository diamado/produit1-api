package com.produit.produitservice.controller;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {


    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }
    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable long id){
        return produitService.getProduitById(id);

    }
    @DeleteMapping("{id}")
    public String deleteProduitById(@PathVariable("id") long idProduit){
        return produitService.deleteProduitById(idProduit);

    }

    @PutMapping("{id}")
    public Produit editProduit(@PathVariable long id, @RequestBody Produit produit){
        return  produitService.editProduit(id,produit);
    }
}
