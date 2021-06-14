package model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;





@Entity
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     
     private String username;
     private String password;
     private String firstname;
     private String lastname;
     private String address;
     private int phonenumber;
     private String email;
     
     
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinColumn(name = "user_id")
     private List<Payment> payments = new ArrayList<Payment>();

    public User() {
    }

    public User(String username, String password, String firstname, String lastname, String address, int phonenumber, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public User(int id, String username, String password, String firstname, String lastname, String address, int phonenumber, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phonenumber=" + phonenumber + ", email=" + email + ", payments=" + payments + '}';
    }
     
     
    

}


