package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.Meetingroom;
import com.securde.shslibrary.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MeetingRoomRepository extends JpaRepository<Meetingroom, Integer> {
    List<Meetingroom> findMeetingroomByRoomstatusLike(int status);
    Meetingroom findMeetingroomByMeetingroomidLike(int mrid);
}
