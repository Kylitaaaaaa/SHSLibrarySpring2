package com.securde.shslibrary.controller;

import com.securde.shslibrary.model.*;
import com.securde.shslibrary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    ResourceReservationRepository resourceReservationRepository;

    @Autowired
    MeetingRoomReservationRepository meetingRoomReservationRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @RequestMapping(value = "/onSearchResources/{restype}/{options}/{searchitem}", method = RequestMethod.GET)
    public @ResponseBody Iterable <Resource> onSearchResources(@PathParam(value = "restype") @PathVariable int restype,
                                                               @PathParam(value = "options") @PathVariable int options,
                                                               @PathParam(value = "searchitem") @PathVariable String searchitem) {
        System.out.println("Restype "+restype+" AAA Option "+options);
        if(restype == 3){
            if(options == 0) {
                String searchitem2 = searchitem;
                String searchitem3 = searchitem;
                return resourceRepository.findResourceByAuthorIgnoreCaseContainingOrPublisherIgnoreCaseContainingOrTitleIgnoreCaseContaining(searchitem, searchitem2, searchitem3);
            }
            else if(options == 1)
                return resourceRepository.findResourceByAuthorIgnoreCaseContaining(searchitem);
            else if(options == 2)
                return resourceRepository.findResourceByPublisherIgnoreCaseContaining(searchitem);
            else if(options == 3)
                return resourceRepository.findResourceByTitleIgnoreCaseContaining(searchitem);
        }

        else{
            if(options == 0) {
                String searchitem2 = searchitem;
                String searchitem3 = searchitem;
                return resourceRepository.findResourceByAuthorIgnoreCaseContainingOrPublisherIgnoreCaseContainingOrTitleIgnoreCaseContainingAndBooktype(searchitem, searchitem2, searchitem3, restype);
            }
            if(options == 1)
                return resourceRepository.findResourceByAuthorIgnoreCaseContainingAndBooktype(searchitem, restype);
            else if(options == 2)
                return resourceRepository.findResourceByPublisherIgnoreCaseContainingAndBooktype(searchitem, restype);
            else if(options == 3)
                return resourceRepository.findResourceByTitleIgnoreCaseContainingAndBooktype(searchitem, restype);
        }
        return null;

    }

    @RequestMapping(value = "/getAllResources", method = RequestMethod.GET)
    public @ResponseBody Iterable <Resource> getAllResources() {
        return resourceRepository.findAll();
    }



    @RequestMapping(value = "/getCurrResource/{bookid}", method = RequestMethod.GET)
    public @ResponseBody
    Resource getCurrResource(@PathParam(value = "bookid") @PathVariable int bookid) {
        return resourceRepository.findResourceByBookidLike(bookid);
    }

    @RequestMapping(value = "/canReview/{bookid}/{userid}", method = RequestMethod.GET)
    public int canReview(@PathParam(value = "bookid") @PathVariable int bookid,
                       @PathParam(value = "userid") @PathVariable int userid) {
        List <Review> r = reviewRepository.findReviewByBookidAndUserid(bookid, userid);
        if(r.size() ==0)
            return 1;
        return 0;
    }

    @RequestMapping(value = "/getReviewCurrResource/{bookid}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Review> getReviewCurrResource(@PathParam(value = "bookid") @PathVariable int bookid) {
        return reviewRepository.findReviewByBookidLike(bookid);
    }


    @RequestMapping(value = "/searchByAuthor/{author}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <Resource> searchByAuthor(@PathParam(value = "author") @PathVariable String author) {
        return resourceRepository.findResourceByAuthorIgnoreCaseContaining(author);
    }

    @RequestMapping(value = "/searchByTitle/{title}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <Resource> searchByTitle(@PathParam(value = "title") @PathVariable String title) {
        return resourceRepository.findResourceByTitleIgnoreCaseContaining(title);
    }

    @RequestMapping(value = "/searchByPublisher/{publisher}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <Resource> searchByPublisher(@PathParam(value = "publisher") @PathVariable String publisher) {
        return resourceRepository.findResourceByPublisherIgnoreCaseContaining(publisher);
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public void saveReview(@RequestBody Review review){
        reviewRepository.save(review);
    }

    @RequestMapping(value = "/reserveResource/{bookid}/{reservationdate}/{returndate}/{status}/{userid}", method = RequestMethod.POST)
    public void reserveResource(@PathParam(value = "bookid") @PathVariable int bookid,
                                @PathParam(value = "reservationdate") @PathVariable String reservationdate,
                                @PathParam(value = "returndate") @PathVariable String returndate,
                                @PathParam(value = "status") @PathVariable int status,
                                @PathParam(value = "userid") @PathVariable int userid) {

        Resourcereservation r = new Resourcereservation();
        r.setBookid(bookid);
        r.setReservationdate(reservationdate);
        r.setReturndate(returndate);
        r.setStatus(status);
        r.setUserid(userid);

        resourceReservationRepository.save(r);

        Resource res = resourceRepository.findResourceByBookidLike(bookid);
        res.setStatus(status);
        resourceRepository.save(res);
    }


    @RequestMapping(value = "/onSearchMR/{starttime}/{usagedateformat}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Meetingroom> onSearchMR(@PathParam(value = "starttime") @PathVariable int starttime,
                                                                     @PathParam(value = "usagedateformat") @PathVariable String usagedateformat){

        List<Meetingroom> mList = meetingRoomRepository.findAll();
        List<Meetingroomreservation> mrList = meetingRoomReservationRepository.findMeetingroomreservationByUsagedateAndStarttime(usagedateformat, starttime);
        List<Meetingroom> mList2 = new ArrayList<Meetingroom>();
        for(int i=0; i<mList.size(); i++){
            Meetingroomreservation mrrr = meetingRoomReservationRepository.findMeetingroomreservationByUsagedateAndStarttimeAndMrid(usagedateformat, starttime, mList.get(i).getMeetingroomid());
            if(mrrr == null)
                mList2.add(mList.get(i));
        }

        return mList2;
    }


    @RequestMapping(value = "/onReview/{reviewcontent}/{bookid}/{userid}/{currdate}", method = RequestMethod.POST)
    public void onReview(@PathParam(value = "reviewcontent") @PathVariable String reviewcontent,
                                                        @PathParam(value = "bookid") @PathVariable int bookid,
                                                        @PathParam(value = "userid") @PathVariable int userid,
                                                        @PathParam(value = "currdate") @PathVariable String currdate){

        Review r = new Review();
        r.setBookid(bookid);
        r.setReviewcontent(reviewcontent);
        r.setReviewdate(currdate);
        r.setUserid(userid);
        reviewRepository.save(r);
    }


    @RequestMapping(value = "/reserveMR/{meetingroomid}/{userid}/{reservationdate}/{usagedate}/{starttime}", method = RequestMethod.POST)
    public void reserveResource(@PathParam(value = "meetingroomid") @PathVariable int meetingroomid,
                                @PathParam(value = "userid") @PathVariable int userid,
                                @PathParam(value = "reservationdate") @PathVariable String reservationdate,
                                @PathParam(value = "usagedate") @PathVariable String usagedate,
                                @PathParam(value = "starttime") @PathVariable int starttime) {

        Meetingroomreservation mr = new Meetingroomreservation();
        mr.setMrid(meetingroomid);
        mr.setUserid(userid);
        mr.setResdate(reservationdate);
        mr.setUsagedate(usagedate);
        mr.setStarttime(starttime);

        meetingRoomReservationRepository.save(mr);

    }

    /*
    @RequestMapping(value = "/reserveMRRes", method = RequestMethod.POST)
    public void reserveMRRes(@RequestBody Meetingroomreservation meetingroomreservation){
        meetingRoomReservationRepository.save(meetingroomreservation);

        Meetingroom mr = meetingRoomRepository.findMeetingroomByMeetingroomidLike(meetingroomreservation.getMrid());
        //mr.setRoomstatus(2);
        meetingRoomRepository.save(mr);
    }
    */
}
