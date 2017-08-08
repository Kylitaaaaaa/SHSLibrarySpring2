package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 04/08/2017.
 */

@Entity
public class Resourcereservation {
    @Id
    private int resid;
    private int bookid;
    private int userid;
    private int status;
    private String reservationdate;
    private String borrowdate;
    private String returndate;

    /*
    status
    0 - returned
    1 - not returned
    2- reserved
     */

    public Resourcereservation() {
    }

    public Resourcereservation(int resid, int bookid, int userid, int status, String reservationdate, String borrowdate, String returndate) {
        this.resid = resid;
        this.bookid = bookid;
        this.userid = userid;
        this.status = status;
        this.reservationdate = reservationdate;
        this.borrowdate = borrowdate;
        this.returndate = returndate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getReservationdate() {
        return reservationdate;
    }

    public void setReservationdate(String reservationdate) {
        this.reservationdate = reservationdate;
    }

    public String getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }
}
