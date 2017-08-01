package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.RoomReservation;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RoomReservationRepository extends CrudRepository<RoomReservation, Integer> {

}
