package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 19/07/2017.
 */
@Entity
public class Admin {
    @Id
    private int admin_id;
    private String first_name;
    private String last_name;
    private String middle_initial;
    private String birthday;
    private String secret_question;
    private String secret_answer;
    private int admin_type;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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

    public int getAdmin_type() {
        return admin_type;
    }

    public void setAdmin_type(int admin_type) {
        this.admin_type = admin_type;
    }
}

