package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path="/addUser")
    public @ResponseBody String addNewUser (
                                             @RequestParam String id_number,
                                             @RequestParam String password,
                                             @RequestParam String user_type,
                                             @RequestParam String email_address,
                                             @RequestParam String phone_number) {

        User u = new User();
        u.setId_number(Integer.parseInt(id_number));
        u.setPassword(password);
        u.setEmail_address(email_address);
        u.setPhone_number(phone_number);
        u.setLock_status(0);
        u.setLogin_attempts(0);
        u.setUser_type(Integer.parseInt(user_type));

//        if(user_type == 1)
//            u.setUser_type(1);
//        else if(user_type == 2)
//            u.setUser_type(2);
        userRepository.save(u);
        return "Saved";
    }

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


}
