package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Historique extends JpaRepository<com.example.demo.Entity.Historique, Long> {



        }

