package com.example.demo.Repository;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.TestQA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByTitle (String title);


}
