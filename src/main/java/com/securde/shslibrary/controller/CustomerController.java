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
    public @ResponseBody
    Iterable<Meetingroom> getAllAvailMR() {
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
