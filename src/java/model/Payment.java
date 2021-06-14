package model;



import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Payment {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     private Date datetime;
     private double total;
     private boolean payed;
     
     
     @ManyToOne(optional = false,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_fk"))
     private User user;
     
     
     @ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinTable(name = "payment_item", joinColumns = @JoinColumn(name = "payment_id",nullable = false, updatable = false),
        inverseJoinColumns = @JoinColumn(name = "item_id", nullable = false, updatable = false))
     private List<Item> items = new ArrayList<Item>();

    public Payment() {
    }

    public Payment(double total, boolean payed, User user) {
        this.total = total;
        this.payed = payed;
        this.user = user;
    }
    
    
    

    public Payment(Date datetime, double total, boolean payed, User user) {
        this.datetime = datetime;
        this.total = total;
        this.payed = payed;
        this.user = user;
    }

    public Payment(int id, Date datetime, double total, boolean payed, User user) {
        this.id = id;
        this.datetime = datetime;
        this.total = total;
        this.payed = payed;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public double getTotal() {
        return total;
    }

    public boolean isPayed() {
        return payed;
    }

    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", datetime=" + datetime + ", total=" + total + ", payed=" + payed + ", user=" + user + ", items=" + items + '}';
    }
    
    
     
     
     

}