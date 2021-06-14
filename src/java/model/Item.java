package model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;







@Entity
public class Item {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     private String name;
     private double price;
     private String description;
     private int quantity;
     private String img;
     
     
    @ManyToOne(optional = false,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", foreignKey = @ForeignKey(name = "brand_fk"))
    private Brand brand;
    
    
    @ManyToOne(optional = false,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "category_fk"))
    private Category category;
     
     
    @ManyToOne(optional = false,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "frame_id", foreignKey = @ForeignKey(name = "frame_fk"))
    private Frame frame;

    
    
    public Item() {
    }

    public Item(String name, double price, String description, int quantity, String img, Brand brand, Category category, Frame frame) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.img = img;
        this.brand = brand;
        this.category = category;
        this.frame = frame;
    }

    public Item(int id, String name, double price, String description, int quantity, String img, Brand brand, Category category, Frame frame) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.img = img;
        this.brand = brand;
        this.category = category;
        this.frame = frame;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImg() {
        return img;
    }

    public Brand getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", quantity=" + quantity + ", img=" + img + ", brand=" + brand + ", category=" + category + ", frame=" + frame + '}';
    }
    
}