package com.cos.howabout.after;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfterRepository extends JpaRepository<After,Integer>{

}
