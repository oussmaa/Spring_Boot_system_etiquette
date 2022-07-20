package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Livraison;

import java.util.List;
import java.util.Optional;


@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long>{
	Livraison findByVersion (String version);


}
