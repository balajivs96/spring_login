package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
