package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 16/07/2017.
 */
@Entity
public class Review {
    @Id
    private int reviewid;

    private String reviewcontent;
    private int bookid;
    private int userid;
    private String reviewdate;

    public Review() {
    }

    public Review(int reviewid, String reviewcontent, int bookid, int userid, String reviewdate) {
        this.reviewid = reviewid;
        this.reviewcontent = reviewcontent;
        this.bookid = bookid;
        this.userid = userid;
        this.reviewdate = reviewdate;
    }

    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    public String getReviewcontent() {
        return reviewcontent;
    }

    public void setReviewcontent(String reviewcontent) {
        this.reviewcontent = reviewcontent;
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

    public String getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(String reviewdate) {
        this.reviewdate = reviewdate;
    }
}
