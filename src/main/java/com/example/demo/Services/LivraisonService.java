package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entity.Livraison;


public interface LivraisonService {
	 Livraison addNewLivraison(Livraison livraison);
	 
	    List<Livraison> listLivraison();
	   
	    Livraison updateLivraison(Livraison livraison,Long id);
	    String deleteLivraison(Long id);
	    Livraison getLivraison(String version);

}