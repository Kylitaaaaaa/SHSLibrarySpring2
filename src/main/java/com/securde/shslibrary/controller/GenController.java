package com.securde.shslibrary.controller;

import com.securde.shslibrary.model.Meetingroomreservation;
import com.securde.shslibrary.model.RandomStringGenerator;
import com.securde.shslibrary.model.Resourcereservation;
import com.securde.shslibrary.model.User;
import com.securde.shslibrary.repository.MeetingRoomReservationRepository;
import com.securde.shslibrary.repository.ResourceReservationRepository;
import com.securde.shslibrary.repository.UserRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value="/gen")
public class GenController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ResourceReservationRepository resourceReservationRepository;

    @Autowired
    private MeetingRoomReservationRepository meetingRoomReservationRepository;

    @RequestMapping(value = "/allAdmin", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<User> getAllAdmin() {
        return userRepository.findAll();

    }


    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <User> getLibMans(@PathParam(value = "type") @PathVariable int type) {
        return userRepository.findUserByUsertypeLike(type);
    }

    @RequestMapping(value = "/unlockUser/{uid}/{currPrev}", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <User> unlockUser(@PathParam(value = "uid") @PathVariable int uid,
                               @PathParam(value = "currPrev") @PathVariable int currPrev) {
        User u = userRepository.findOne(uid);
        u.setLockstatus(0);
        u.setLoginattempts(0);
        userRepository.save(u);
        return userRepository.findUserByUsertypeLike(currPrev);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <User> create(@RequestBody User user){

        RandomStringGenerator gen = new RandomStringGenerator();
        String p=gen.genString(10);
        System.out.println(p+"     PASSSWORD");
        user.setPassword(passwordEncoder.encode(p));
        user.setSecretanswer(passwordEncoder.encode(user.getSecretanswer()));
        String birthday=user.getBirthday();
        String month = birthday.substring(5,7);
        String day = birthday.substring(8,10);
        String year = birthday.substring(0,4);
        String newBirthday= (month+"/"+day+"/"+year);
        user.setBirthday(newBirthday);
        userRepository.save(user);

        return  userRepository.findAll();
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



        Row headerSheet1=sheet1.createRow(0);
        Cell headerCell1Sheet1= headerSheet1.createCell(0);
        Cell headerCell2Sheet1= headerSheet1.createCell(1);
        Cell headerCell3Sheet1= headerSheet1.createCell(2);
        Cell headerCell4Sheet1= headerSheet1.createCell(3);
        Cell headerCell5Sheet1= headerSheet1.createCell(4);
        Cell headerCell6Sheet1= headerSheet1.createCell(5);
        Cell headerCell7Sheet1= headerSheet1.createCell(6);
        headerCell1Sheet1.setCellValue("reservationid");
        headerCell2Sheet1.setCellValue("bookid");
        headerCell3Sheet1.setCellValue("userid");
        headerCell4Sheet1.setCellValue("reservationdate");
        headerCell5Sheet1.setCellValue("returndate");
        headerCell6Sheet1.setCellValue("status");


        Row headerSheet2=sheet2.createRow(0);
        Cell headerCell1Sheet2= headerSheet2.createCell(0);
        Cell headerCell2Sheet2= headerSheet2.createCell(1);
        Cell headerCell3Sheet2= headerSheet2.createCell(2);
        Cell headerCell4Sheet2= headerSheet2.createCell(3);
        Cell headerCell5Sheet2= headerSheet2.createCell(4);
        Cell headerCell6Sheet2= headerSheet2.createCell(5);
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
            cell5.setCellValue(resourceReservationsList.get(i).getReturndate());
            Cell cell6 = row.createCell(colNum++);
            cell6.setCellValue(resourceReservationsList.get(i).getStatus());

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
            System.out.println("WRITING FILES!!!");
            FileOutputStream outputStream = new FileOutputStream("C:/Users/DELL-PC/Desktop/SECURDE/SHSLibrarySpring/RESERVATION.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}