package com.securde.shslibrary.controller;

import com.securde.shslibrary.model.*;
import com.securde.shslibrary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    ResourceReservationRepository resourceReservationRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MeetingRoomReservationRepository meetingRoomReservationRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    /*
    //idk how benson ikaw na dito
    @GetMapping(path="/SearchAll")
    public @ResponseBody Iterable<Resource> getBookByAll(String key) {
        // This returns a JSON or XML with the users

        List<Book> books = new ArrayList();
        bookRepository.findAll().forEach(
                book->{
                    if(book.getAuthor().contains(key)||book.getTitle().contains(key)||book.getPublisher().contains(key)){
                        books.add(book);
                    }
                });
        return books;
    }
    */
    @RequestMapping(value = "/onSearchResources/{restype}/{options}/{searchitem}", method = RequestMethod.GET)
    public @ResponseBody Iterable <Resource> onSearchResources(@PathParam(value = "restype") @PathVariable int restype,
                                                            @PathParam(value = "options") @PathVariable int options,
                                                            @PathParam(value = "searchitem") @PathVariable String searchitem) {


        if(restype == 0){
            if(options == 0) {
                String searchitem2 = searchitem;
                String searchitem3 = searchitem;
                return resourceRepository.findResourceByAuthorOrPublisherOrTitle(searchitem, searchitem2, searchitem3);
            }
            else if(options == 1)
                return resourceRepository.findResourceByAuthorLike(searchitem);
            else if(options == 2)
                return resourceRepository.findResourceByPublisherLike(searchitem);
            else if(options == 3)
                return resourceRepository.findResourceByTitleLike(searchitem);
        }

        else{
            if(options == 1)
                return resourceRepository.findResourceByAuthorAndBooktype(searchitem, restype);
            else if(options == 2)
                return resourceRepository.findResourceByPublisherAndBooktype(searchitem, restype);
            else if(options == 3)
                return resourceRepository.findResourceByTitleAndBooktype(searchitem, restype);
        }
        return null;

    }

    @RequestMapping(value = "/getAllResources", method = RequestMethod.GET)
    public @ResponseBody Iterable <Resource> getAllResources() {
        return resourceRepository.findAll();
    }



    @RequestMapping(value = "/getCurrResource/{resid}", method = RequestMethod.GET)
    public @ResponseBody
    Resource getCurrResource(@PathParam(value = "resid") @PathVariable int resid) {
        return resourceRepository.findResourceByBookidLike(resid);
    }

    @RequestMapping(value = "/searchByAuthor/{author}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <Resource> searchByAuthor(@PathParam(value = "author") @PathVariable String author) {
        return resourceRepository.findResourceByAuthorLike(author);
    }

    @RequestMapping(value = "/searchByTitle/{title}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <Resource> searchByTitle(@PathParam(value = "title") @PathVariable String title) {
        return resourceRepository.findResourceByTitleLike(title);
    }

    @RequestMapping(value = "/searchByPublisher/{publisher}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <Resource> searchByPublisher(@PathParam(value = "publisher") @PathVariable String publisher) {
        return resourceRepository.findResourceByPublisherLike(publisher);
    }

    @RequestMapping(value = "/reserveResourceRes", method = RequestMethod.POST)
    public void reserveResourceRes(@RequestBody Resourcereservation resourcereservation){
        resourceReservationRepository.save(resourcereservation);

        Resource r = resourceRepository.findResourceByBookidLike(resourcereservation.getBookid());
        r.setStatus(2);

        resourceRepository.save(r);
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public void saveReview(@RequestBody Review review){
        reviewRepository.save(review);
    }

    @RequestMapping(value = "/allAvailMR", method = RequestMethod.GET)
    public @ResponseBody Iterable<Meetingroom> getAllAvailMR() {
        return meetingRoomRepository.findMeetingroomByRoomstatusLike(0);
    }

    @RequestMapping(value = "/reserveMRRes", method = RequestMethod.POST)
    public void reserveMRRes(@RequestBody Meetingroomreservation meetingroomreservation){
        meetingRoomReservationRepository.save(meetingroomreservation);

        Meetingroom mr = meetingRoomRepository.findMeetingroomByMeetingroomidLike(meetingroomreservation.getMrid());
        mr.setRoomstatus(2);
        meetingRoomRepository.save(mr);
    }
}
