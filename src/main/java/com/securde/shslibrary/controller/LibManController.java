package com.securde.shslibrary.controller;

import com.securde.shslibrary.model.Meetingroomreservation;
import com.securde.shslibrary.model.Resource;
import com.securde.shslibrary.model.Resourcereservation;
import com.securde.shslibrary.repository.MeetingRoomReservationRepository;
import com.securde.shslibrary.repository.ResourceRepository;
import com.securde.shslibrary.repository.ResourceReservationRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping(value="/libman")
public class LibManController {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceReservationRepository resourceReservationRepository;

    @Autowired
    private MeetingRoomReservationRepository meetingRoomReservationRepository;

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

    @RequestMapping(value = "/createResource", method = RequestMethod.POST)
    public @ResponseBody Iterable <Resource> createResource(@RequestBody Resource resource){
        resourceRepository.save(resource);
        return  resourceRepository.findAll();
    }

    @RequestMapping(value = "/saveResourceRes", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <Resourcereservation> saveResourceRes(@RequestBody Resourcereservation resourcereservation){
        if(resourcereservation.getStatus() ==0){
            resourceReservationRepository.delete(resourcereservation.getResid());
            Resource temp = resourceRepository.findResourceByBookidLike(resourcereservation.getBookid());
            temp.setStatus(0);
            temp.setReturndate(null);
            resourceRepository.save(temp);
        }
        else{
            Resourcereservation r = resourceReservationRepository.findResourcereservationByResidLike(resourcereservation.getResid());
            r.setStatus(resourcereservation.getStatus());
            resourceReservationRepository.save(r);

            Resource temp = resourceRepository.findResourceByBookidLike(resourcereservation.getBookid());
            temp.setStatus(resourcereservation.getStatus());
            resourceRepository.save(temp);
        }

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
        Resourcereservation resourcereservation= resourceReservationRepository.findResourcereservationByResidLike(resid);
            Resource temp = resourceRepository.findResourceByBookidLike(resourcereservation.getBookid());
            temp.setStatus(0);
            temp.setReturndate(null);
            resourceRepository.save(temp);
            resourceReservationRepository.delete(resourcereservation.getResid());

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


    @RequestMapping (value="/xml", method=RequestMethod.POST)
    public @ResponseBody
    void generateXML (){
        Iterable <Resourcereservation> resourceReservations =  resourceReservationRepository.findAll();
        ArrayList<Resourcereservation> resourceReservationsList = new ArrayList<Resourcereservation>();
        resourceReservations.forEach(resourceReservationsList::add);

        Iterable <Meetingroomreservation> meetingroomreservations =  meetingRoomReservationRepository.findAll();
        ArrayList<Meetingroomreservation> meetingroomreservationsList = new ArrayList<Meetingroomreservation>();
        meetingroomreservations.forEach(meetingroomreservationsList::add);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("Resource Reservations");
        XSSFSheet sheet2 = workbook.createSheet("Meeting Room Reservations");



        Row headerSheet1=sheet1.createRow(1);
        Cell headerCell1Sheet1= headerSheet1.createCell(1);
        Cell headerCell2Sheet1= headerSheet1.createCell(2);
        Cell headerCell3Sheet1= headerSheet1.createCell(3);
        Cell headerCell4Sheet1= headerSheet1.createCell(4);
        Cell headerCell5Sheet1= headerSheet1.createCell(5);
        Cell headerCell6Sheet1= headerSheet1.createCell(6);
        Cell headerCell7Sheet1= headerSheet1.createCell(7);
        headerCell1Sheet1.setCellValue("reservationid");
        headerCell2Sheet1.setCellValue("bookid");
        headerCell3Sheet1.setCellValue("userid");
        headerCell4Sheet1.setCellValue("reservationdate");
        headerCell5Sheet1.setCellValue("borrowdate");
        headerCell6Sheet1.setCellValue("returndate");
        headerCell7Sheet1.setCellValue("status");


        Row headerSheet2=sheet2.createRow(1);
        Cell headerCell1Sheet2= headerSheet1.createCell(1);
        Cell headerCell2Sheet2= headerSheet1.createCell(2);
        Cell headerCell3Sheet2= headerSheet1.createCell(3);
        Cell headerCell4Sheet2= headerSheet1.createCell(4);
        Cell headerCell5Sheet2= headerSheet1.createCell(5);
        Cell headerCell6Sheet2= headerSheet1.createCell(6);
        headerCell1Sheet2.setCellValue("meetingroomreservationid");
        headerCell2Sheet2.setCellValue("meetingroomid");
        headerCell3Sheet2.setCellValue("reservationdate");
        headerCell4Sheet2.setCellValue("starttime");
        headerCell5Sheet2.setCellValue("usagedate");
        headerCell6Sheet2.setCellValue("userid");


        int rowNum = 1;
        for (int i=0;i<resourceReservationsList.size();i++) {
            Row row = sheet1.createRow(rowNum++);
            int colNum = 0;
            Cell cell = row.createCell(colNum++);
            cell.setCellValue(resourceReservationsList.get(i).getResid());
            Cell cell2 = row.createCell(colNum++);
            cell2.setCellValue(resourceReservationsList.get(i).getBookid());
            Cell cell3 = row.createCell(colNum++);
            cell3.setCellValue(resourceReservationsList.get(i).getUserid());
            Cell cell4 = row.createCell(colNum++);
            cell4.setCellValue(resourceReservationsList.get(i).getReservationdate());
            Cell cell5 = row.createCell(colNum++);
            cell5.setCellValue(resourceReservationsList.get(i).getBorrowdate());
            Cell cell6 = row.createCell(colNum++);
            cell6.setCellValue(resourceReservationsList.get(i).getReturndate());
            Cell cell7= row.createCell(colNum++);
            cell7.setCellValue(resourceReservationsList.get(i).getStatus());

        }


        rowNum = 1;
        for (int i=0;i<meetingroomreservationsList.size();i++) {
            Row row = sheet2.createRow(rowNum++);
            int colNum = 0;
            Cell cell = row.createCell(colNum++);
            cell.setCellValue(meetingroomreservationsList.get(i).getMrresid());
            Cell cell2 = row.createCell(colNum++);
            cell2.setCellValue(meetingroomreservationsList.get(i).getMrid());
            Cell cell3 = row.createCell(colNum++);
            cell3.setCellValue(meetingroomreservationsList.get(i).getResdate());
            Cell cell4 = row.createCell(colNum++);
            cell4.setCellValue(meetingroomreservationsList.get(i).getStarttime());
            Cell cell5 = row.createCell(colNum++);
            cell5.setCellValue(meetingroomreservationsList.get(i).getUsagedate());
            Cell cell6 = row.createCell(colNum++);
            cell6.setCellValue(meetingroomreservationsList.get(i).getUserid());

        }


        try {
            FileOutputStream outputStream = new FileOutputStream("Reservation");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}