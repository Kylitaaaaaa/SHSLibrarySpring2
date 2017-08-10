package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 05/08/2017.
 */
@Entity
public class Meetingroomreservation {
    @Id
    private int mrresid;
    private int mrid;
    private int userid;
    private String resdate;
    private String usagedate;
    private int starttime;

    public Meetingroomreservation() {
    }

    public int getMrresid() {
        return mrresid;
    }

    public void setMrresid(int mrresid) {
        this.mrresid = mrresid;
    }

    public int getMrid() {
        return mrid;
    }

    public void setMrid(int mrid) {
        this.mrid = mrid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    public String getUsagedate() {
        return usagedate;
    }

    public void setUsagedate(String usagedate) {
        this.usagedate = usagedate;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }
}
