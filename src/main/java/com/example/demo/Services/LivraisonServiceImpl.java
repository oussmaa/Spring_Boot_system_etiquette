package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Livraison;
import com.example.demo.Repository.LivraisonRepository;


@Service
@Transactional
public class LivraisonServiceImpl implements LivraisonService {
	private LivraisonRepository livraisonRepository;
	 

    public LivraisonServiceImpl(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }
   
    /**
     * Livraison Crud
     */
    @Override
    public Livraison addNewLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    @Override
    public List<Livraison> listLivraison() { return livraisonRepository.findAll(); }

    public Livraison getUserById(Long id){
        return livraisonRepository.findById(id).orElse(null);
    }
    public Livraison getUserByVersion(String version){
        return livraisonRepository.findByVersion(version);
    }

    public Livraison updateLivraison(Livraison livraison, Long id){
    	Livraison Livraison = livraisonRepository.getById(id);
  
    	Livraison.setVersion(livraison.getVersion());
    	Livraison.setDate_livraison(livraison.getDate_livraison());
    	Livraison.setEtat(livraison.getEtat());
    	livraisonRepository.save(livraison);
    return livraison;
    }
    public String deleteLivraison(Long id){
    	livraisonRepository.deleteById(id);
        return "Livraison removed  !! "+id;
    }
    @Override
   public Livraison getLivraison(String version) {
    	return livraisonRepository.findByVersion(version);
    	
    }

}