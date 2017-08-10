package com.securde.shslibrary.controller;

import com.securde.shslibrary.model.Meetingroom;
import com.securde.shslibrary.model.Meetingroomreservation;
import com.securde.shslibrary.model.Resource;
import com.securde.shslibrary.model.Resourcereservation;
import com.securde.shslibrary.repository.MeetingRoomRepository;
import com.securde.shslibrary.repository.MeetingRoomReservationRepository;
import com.securde.shslibrary.repository.ResourceRepository;
import com.securde.shslibrary.repository.ResourceReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="/libstaff")
public class LibStaffController {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceReservationRepository resourceReservationRepository;

    @Autowired
    private MeetingRoomReservationRepository meetingRoomReservationRepository;

    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    @RequestMapping(value = "/allResources", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @RequestMapping(value = "/allResourcesRes", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Resourcereservation> getAllResourceRes() {
        return resourceReservationRepository.findAll();
    }

    @RequestMapping(value = "/allMRRes", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Meetingroomreservation> getAllMRRes() {
        return meetingRoomReservationRepository.findAll();
    }

    @RequestMapping(value = "/allAvailMR", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Meetingroom> getAllAvailMR() {
        //return meetingRoomRepository.findMeetingroomByRoomstatusLike(0);
        return null;
    }

    @RequestMapping(value = "/createResource", method = RequestMethod.POST)
    public @ResponseBody Iterable <Resource> createResource(@RequestBody Resource resource){
        resourceRepository.save(resource);
        return  resourceRepository.findAll();
    }

    @RequestMapping(value = "/saveResourceRes", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <Resourcereservation> saveResourceRes(@RequestBody Resourcereservation resourcereservation){
        Resourcereservation r = resourceReservationRepository.findOne(resourcereservation.getResid());
        r.setStatus(resourcereservation.getStatus());
        resourceReservationRepository.save(r);
        return  resourceReservationRepository.findAll();
    }



    @RequestMapping(value = "/saveRoomRes", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <Meetingroomreservation> saveRoomRes(@RequestBody Meetingroomreservation meetingroomreservation){
        meetingRoomReservationRepository.save(meetingroomreservation);
        return  meetingRoomReservationRepository.findAll();
    }


    @RequestMapping(value = "/removeResource/{resid}", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <Resource> removeResource(@PathParam(value = "resid") @PathVariable int resid) {
        resourceRepository.delete(resid);

        return resourceRepository.findAll();
    }

    @RequestMapping(value = "/removeResourceRes/{resid}", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <Resourcereservation> removeResourceRes(@PathParam(value = "resid") @PathVariable int resid) {
        resourceReservationRepository.delete(resid);

        return resourceReservationRepository.findAll();
    }

    @RequestMapping(value = "/removeResourceMRRes/{resid}", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <Meetingroomreservation> removeResourceMRRes(@PathParam(value = "resid") @PathVariable int resid) {
        meetingRoomReservationRepository.delete(resid);

        return meetingRoomReservationRepository.findAll();
    }

    @RequestMapping(value =  "/getCurrResource/{resid}", method = RequestMethod.GET)
    public @ResponseBody
    Resource getCurrResource(@PathParam(value = "resid") @PathVariable int resid) {
        return resourceRepository.findOne(resid);
    }

    @RequestMapping(value =  "/getCurrResourceRes/{resid}", method = RequestMethod.GET)
    public @ResponseBody
    Resourcereservation getCurrResourceRes(@PathParam(value = "resid") @PathVariable int resid) {
        return resourceReservationRepository.findOne(resid);
    }

    @RequestMapping(value =  "/getCurrRoomRes/{resid}", method = RequestMethod.GET)
    public @ResponseBody
    Meetingroomreservation getCurrRoomRes(@PathParam(value = "resid") @PathVariable int resid) {
        return meetingRoomReservationRepository.findOne(resid);
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



}