package com.sr.Rozgar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sr.Rozgar.model.Job;



@Repository

public interface JobRepository extends JpaRepository<Job, Long> {

}
