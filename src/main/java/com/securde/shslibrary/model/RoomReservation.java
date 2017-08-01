package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 25/07/2017.
 */
@Entity
public class RoomReservation {
    @Id
    private String room_reservation_id;
    private String reservation_date;
    private String usage_date;
    private String start_time;
    private String end_time;
    private int user_id;
    private int meeting_room_id;

    public String getRoom_reservation_id() {
        return room_reservation_id;
    }

    public void setRoom_reservation_id(String room_reservation_id) {
        this.room_reservation_id = room_reservation_id;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public String getUsage_date() {
        return usage_date;
    }

    public void setUsage_date(String usage_date) {
        this.usage_date = usage_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMeeting_room_id() {
        return meeting_room_id;
    }

    public void setMeeting_room_id(int meeting_room_id) {
        this.meeting_room_id = meeting_room_id;
    }
}
