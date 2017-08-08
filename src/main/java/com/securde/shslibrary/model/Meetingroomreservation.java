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
    private String starttime;
    private String endtime;

    public Meetingroomreservation() {
    }

    public Meetingroomreservation(int mrresid, int mrid, int userid, String resdate, String usagedate, String starttime, String endtime) {
        this.mrresid = mrresid;
        this.mrid = mrid;
        this.userid = userid;
        this.resdate = resdate;
        this.usagedate = usagedate;
        this.starttime = starttime;
        this.endtime = endtime;
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
