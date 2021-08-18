package com.cos.howabout.reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "select * from reservation where user_id = :userId", nativeQuery = true)
    List<Reservation> mFindUserReservation(@Param("userId")  int userId);
    
  
}
