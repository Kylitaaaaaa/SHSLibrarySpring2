package Controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Thea on 19/07/2017.
 */

@Entity
//@Table()
public class Customer {

    @Id
    private int customer_id;
    private String first_name;
    private String last_name;
    private String middle_initial;
    private String birthday;
    private String secret_question;
    private String secret_answer;
    private int customer_type;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_initial() {
        return middle_initial;
    }

    public void setMiddle_initial(String middle_initial) {
        this.middle_initial = middle_initial;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSecret_question() {
        return secret_question;
    }

    public void setSecret_question(String secret_question) {
        this.secret_question = secret_question;
    }

    public String getSecret_answer() {
        return secret_answer;
    }

    public void setSecret_answer(String secret_answer) {
        this.secret_answer = secret_answer;
    }

    public int getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(int customer_type) {
        this.customer_type = customer_type;
    }
}

