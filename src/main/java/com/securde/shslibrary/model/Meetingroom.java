package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 19/07/2017.
 */

@Entity
public class Meetingroom {

    @Id
    private int meetingroomid;
    private String roomname;

    public Meetingroom() {
    }

    public Meetingroom(int meetingroomid, String roomname) {
        this.meetingroomid = meetingroomid;
        this.roomname = roomname;
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
}

