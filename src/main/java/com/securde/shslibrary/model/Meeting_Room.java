package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 19/07/2017.
 */

@Entity
public class Meeting_Room {

	/*
	 * 0 - Free
	 * 1 - Not Free
	 *
	 */

    @Id
    private int meeting_room_id;
    private String room_name;
    private int room_status;

    public int getMeeting_room_id() {
        return meeting_room_id;
    }

    public void setMeeting_room_id(int meeting_room_id) {
        this.meeting_room_id = meeting_room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getRoom_status() {
        return room_status;
    }

    public void setRoom_status(int room_status) {
        this.room_status = room_status;
    }
}

