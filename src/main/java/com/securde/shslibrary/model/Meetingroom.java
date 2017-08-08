package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 19/07/2017.
 */

@Entity
public class Meetingroom {

	/*
	 * 0 - Free
	 * 1 - Not Free
	 * 2 - Reserved
	 */

    @Id
    private int meetingroomid;
    private String roomname;
    private int roomstatus;

    public Meetingroom() {
    }

    public Meetingroom(int meetingroomid, String roomname, int roomstatus) {
        this.meetingroomid = meetingroomid;
        this.roomname = roomname;
        this.roomstatus = roomstatus;
    }

    public int getMeetingroomid() {
        return meetingroomid;
    }

    public void setMeetingroomid(int meetingroomid) {
        this.meetingroomid = meetingroomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public int getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(int roomstatus) {
        this.roomstatus = roomstatus;
    }
}

