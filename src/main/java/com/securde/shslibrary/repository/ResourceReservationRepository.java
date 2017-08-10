package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.Resourcereservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceReservationRepository extends JpaRepository<Resourcereservation, Integer> {
    List<Resourcereservation> findResourcereservationByBookidAndUserid(int bookid, int userid);
    Resourcereservation findResourcereservationByResidLike(int resid);
}
