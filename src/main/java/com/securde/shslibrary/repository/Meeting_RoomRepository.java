package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.Meeting_Room;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Meeting_RoomRepository extends CrudRepository<Meeting_Room, Integer> {

}
