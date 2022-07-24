package com.example.demo.Repository;

import com.example.demo.Entity.Livraison;
import com.example.demo.Entity.TestQA;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestQARepository extends JpaRepository<TestQA, Long> {

    @Override
    List<TestQA> findAll();

    TestQA findByVersion (String version);

}
