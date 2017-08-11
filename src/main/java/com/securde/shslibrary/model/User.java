package com.securde.shslibrary.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;


/**
 * Created by Thea on 19/07/2017.
 */

@Entity
@Table(name = "user")
public class User implements UserDetails{
    @Id
    @Column(name = "userid", nullable = false, updatable = false)
    private int userid;
    private int usertype;

    @Column(name = "idnumber", nullable = false, updatable = false)
    private int idnumber;
    private String password;
    private String emailaddress;
    private String phonenumber;
    private int lockstatus;
    private int loginattempts;
    private String firstname;
    private String lastname;
    private String middleinitial;
    private String birthday;
    private String secretquestion;
    private String secretanswer;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "userrole", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
//    private Set<Role> roles;


    public User(int userid, int usertype, int idnumber, String password, String emailaddress, String phonenumber, int lockstatus, int loginattempts, String firstname, String lastname, String middleinitial, String birthday, String secretquestion, String secretanswer) {
        this.userid = userid;
        this.usertype = usertype;
        this.idnumber = idnumber;
        this.password = password;
        this.emailaddress = emailaddress;
        this.phonenumber = phonenumber;
        this.lockstatus = lockstatus;
        this.loginattempts = loginattempts;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middleinitial = middleinitial;
        this.birthday = birthday;
        this.secretquestion = secretquestion;
        this.secretanswer = secretanswer;
    }

    public User() {
    }

    public User(User user) {
        this.emailaddress = user.getEmailaddress();
        this.phonenumber = user.getPhonenumber();
        this.lockstatus = user.getLockstatus();
        this.loginattempts = user.getLoginattempts();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.middleinitial = user.getMiddleinitial();
        this.birthday = user.getBirthday();
        this.secretquestion = user.getSecretquestion();
        this.secretanswer = user.getSecretanswer();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return Integer.toString(idnumber);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }



    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getLockstatus() {
        return lockstatus;
    }

    public void setLockstatus(int lockstatus) {
        this.lockstatus = lockstatus;
    }

    public int getLoginattempts() {
        return loginattempts;
    }

    public void setLoginattempts(int loginattempts) {
        this.loginattempts = loginattempts;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddleinitial() {
        return middleinitial;
    }

    public void setMiddleinitial(String middleinitial) {
        this.middleinitial = middleinitial;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSecretquestion() {
        return secretquestion;
    }

    public void setSecretquestion(String secretquestion) {
        this.secretquestion = secretquestion;
    }

    public String getSecretanswer() {
        return secretanswer;
    }

    public void setSecretanswer(String secretanswer) {
        this.secretanswer = secretanswer;
    }

    /*
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    */
}
