package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Hospital;

/**
 * HospitalRepository is a repository interface for managing Hospital entities.
 * It extends JpaRepository to provide CRUD operations for Hospital entities.
 */
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}