package com.emp.basicform.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.basicform.Details.details;

@Repository
public interface Repo extends JpaRepository<details, Integer> {

}
