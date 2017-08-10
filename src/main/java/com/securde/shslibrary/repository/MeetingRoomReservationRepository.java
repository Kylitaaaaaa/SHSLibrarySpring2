package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.Meetingroom;
import com.securde.shslibrary.model.Meetingroomreservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRoomReservationRepository extends JpaRepository<Meetingroomreservation, Integer> {
    List<Meetingroomreservation> findMeetingroomreservationByUsagedateLike(String searchdate);
    Meetingroomreservation findMeetingroomreservationByUsagedateAndTimeslotAndMrid(String searchdate, int timeslot, int mrid);

}
