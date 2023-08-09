package com.example.SpringbootCRUDAPI.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringbootCRUDAPI.entity.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, UUID> {

}
