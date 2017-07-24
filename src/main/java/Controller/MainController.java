package Controller;

import com.sun.javafx.tools.packager.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after hello.Application path)
public class MainController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Meeting_RoomRepository meeting_roomRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/allBook")
    public @ResponseBody Iterable<Book> getAllBook() {
        // This returns a JSON or XML with the users
        return bookRepository.findAll();
    }

    @GetMapping(path="/allCustomer")
    public @ResponseBody Iterable<Customer> getAllCustomer() {
        // This returns a JSON or XML with the users
        return customerRepository.findAll();
    }

    @GetMapping(path="/allMeetingRoom")
    public @ResponseBody Iterable<Meeting_Room> getAllMeetingRoom() {
        // This returns a JSON or XML with the users
        return meeting_roomRepository.findAll();
    }

    @GetMapping(path="/allReview")
    public @ResponseBody Iterable<Review> getAllReview() {
        // This returns a JSON or XML with the users
        return reviewRepository.findAll();
    }

    @GetMapping(path="/allUser")
    public @ResponseBody Iterable<User> getAllUser() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/allAdmin")
    public @ResponseBody Iterable<Admin> getAllAdmin() {
        // This returns a JSON or XML with the users
        return adminRepository.findAll();
    }

    /*USER TYPE
	 * 0 - Admin
	 * 1 - Manager
	 * 2 - Staff
	 * 3 - Prof
	 * 4 - Student
	 */

    @GetMapping(path="/getLibMan")
    public @ResponseBody Iterable<User> getLibMan() {
        // This returns a JSON or XML with the users

        List<User> users = new ArrayList();
        userRepository.findAll().forEach(users::add);
        for(int i=0; i<users.size(); i++)
            if(users.get(i).getUser_type() != 1)
                users.remove(i);

        return users;
    }

    @GetMapping(path="/getLibStaff")
    public @ResponseBody Iterable<User> getLibStaff() {
        // This returns a JSON or XML with the users

        List<User> users = new ArrayList();
        userRepository.findAll().forEach(users::add);
        for(int i=0; i<users.size(); i++)
            if(users.get(i).getUser_type() != 2)
                users.remove(i);

        return users;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/addCustomer")
    public @ResponseBody String addNewCustomer (@RequestParam String first_name,
                                             @RequestParam String middle_initial,
                                             @RequestParam String last_name,
                                             @RequestParam String birthday,
                                             @RequestParam String secret_question,
                                             @RequestParam String secret_answer,
                                             @RequestParam int id_number,
                                             @RequestParam String password,
                                             @RequestParam int user_type,
                                             @RequestParam String email_address,
                                             @RequestParam String phone_number) {

        Customer c = new Customer();
        c.setFirst_name(first_name);
        c.setMiddle_initial(middle_initial);
        c.setLast_name(last_name);
        c.setBirthday(birthday);
        c.setSecret_question(secret_question);
        c.setSecret_answer(secret_answer);
        c.setCustomer_type(user_type);
        customerRepository.save(c);

        User u = new User();
        u.setId_number(id_number);
        u.setPassword(password);
        u.setEmail_address(email_address);
        u.setPhone_number(phone_number);
        u.setLock_status(0);
        u.setLogin_attempts(0);

        if(user_type == 1)
            u.setUser_type(1);
        else if(user_type == 2)
            u.setUser_type(2);
        userRepository.save(u);

        return "Customer Saved";
    }



    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/addAdmin")
    public @ResponseBody String addNewAdmin (@RequestParam String first_name,
                                            @RequestParam String middle_initial,
                                            @RequestParam String last_name,
                                            @RequestParam String birthday,
                                            @RequestParam String secret_question,
                                            @RequestParam String secret_answer,
                                            @RequestParam int id_number,
                                            @RequestParam String password,
                                            @RequestParam int user_type,
                                            @RequestParam String email_address,
                                            @RequestParam String phone_number) {

        Admin a = new Admin();
        a.setFirst_name(first_name);
        a.setMiddle_initial(middle_initial);
        a.setLast_name(last_name);
        a.setBirthday(birthday);
        a.setSecret_question(secret_question);
        a.setSecret_answer(secret_answer);
        a.setAdmin_type(user_type);
        adminRepository.save(a);

        User u = new User();
        u.setId_number(id_number);
        u.setPassword(password);
        u.setEmail_address(email_address);
        u.setPhone_number(phone_number);
        u.setLock_status(0);
        u.setLogin_attempts(0);

        if(user_type == 1)
            u.setUser_type(1);
        else if(user_type == 2)
            u.setUser_type(2);
        userRepository.save(u);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/addBook")
    public @ResponseBody String addNewBook (@RequestParam String title,
                                             @RequestParam int type,
                                             @RequestParam String author,
                                             @RequestParam String publisher,
                                             @RequestParam int year,
                                             @RequestParam String location,
                                             @RequestParam int status) {

        Book b = new Book();
        b.setTitle(title);
        b.setType(type);
        b.setAuthor(author);
        b.setPublisher(publisher);
        b.setYear(year);
        b.setLocation(location);
        b.setStatus(status);

        bookRepository.save(b);
        return "Book Saved";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/updateAdmin")
    public @ResponseBody String updateCustomer (@RequestParam int customer_id,
                                             @RequestParam String first_name,
                                             @RequestParam String middle_initial,
                                             @RequestParam String last_name,
                                             @RequestParam String birthday,
                                             @RequestParam String secret_question,
                                             @RequestParam String secret_answer) {

        Customer c = customerRepository.findOne(customer_id);

        c.setFirst_name(first_name);
        c.setMiddle_initial(middle_initial);
        c.setLast_name(last_name);
        c.setBirthday(birthday);
        c.setSecret_question(secret_question);
        c.setSecret_answer(secret_answer);
        customerRepository.save(c);

        return "cru";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/updateAdmin")
    public @ResponseBody String updateUser (@RequestParam int user_id,
                                                @RequestParam int id_number,
                                                @RequestParam String password,
                                                @RequestParam int user_type,
                                                @RequestParam String email_address,
                                                @RequestParam String phone_number) {
        User u = userRepository.findOne(user_id);

        u.setId_number(id_number);
        u.setPassword(password);
        u.setUser_type(user_type);
        u.setEmail_address(email_address);
        u.setPhone_number(phone_number);

        userRepository.save(u);

        return "User Updated";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/updateAdmin")
    public @ResponseBody String updateAdmin (@RequestParam int admin_id,
                                             @RequestParam String first_name,
                                             @RequestParam String middle_initial,
                                             @RequestParam String last_name,
                                             @RequestParam String birthday,
                                             @RequestParam String secret_question,
                                             @RequestParam String secret_answer) {

        Admin a = adminRepository.findOne(admin_id);

        a.setFirst_name(first_name);
        a.setMiddle_initial(middle_initial);
        a.setLast_name(last_name);
        a.setBirthday(birthday);
        a.setSecret_question(secret_question);
        a.setSecret_answer(secret_answer);
        adminRepository.save(a);

        return "cru";
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/updateBook")
    public @ResponseBody String updateBook (@RequestParam int book_id,
                                            @RequestParam String title,
                                            @RequestParam int type,
                                            @RequestParam String author,
                                            @RequestParam String publisher,
                                            @RequestParam int year,
                                            @RequestParam String location,
                                            @RequestParam int status) {

        Book b = bookRepository.findOne(book_id);
        b.setTitle(title);
        b.setType(type);
        b.setAuthor(author);
        b.setPublisher(publisher);
        b.setYear(year);
        b.setLocation(location);
        b.setStatus(status);

        bookRepository.save(b);

        return "Book Updated";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/deleteBook")
    public @ResponseBody String deleteBook (@RequestParam int book_id) {

        bookRepository.delete(book_id);

        return "Book Deleted";
    }




    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/unlockAccount")
    public @ResponseBody String unlockAccount (@RequestParam int user_id) {

        //0 == unlock
        //1 == lock

        User u = userRepository.findOne(user_id);
        u.setLock_status(0);

        userRepository.save(u);

        return "Unlocked";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/lockAccount")
    public @ResponseBody String lockAccount (@RequestParam int user_id) {

        //0 == unlock
        //1 == lock

        User u = userRepository.findOne(user_id);
        u.setLock_status(1);

        userRepository.save(u);

        return "Locked";
    }









}
