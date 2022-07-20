package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Notification;


@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long>{

List<Notification> findByIdevent(long idevent);
}