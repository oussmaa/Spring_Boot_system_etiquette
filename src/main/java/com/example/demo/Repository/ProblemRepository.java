package com.example.demo.Repository;

import com.example.demo.Entity.Livraison;
import com.example.demo.Entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
