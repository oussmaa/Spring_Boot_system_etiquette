package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Scripts;


@Repository
public interface ScriptsRepository extends JpaRepository<Scripts, Long>{
 Scripts findByVersion (String version);
}
