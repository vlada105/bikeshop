package model;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;







@Entity
public class Frame  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String material;

    public Frame() {
    }

    public Frame(String material) {
        this.material = material;
    }

    public Frame(int id, String material) {
        this.id = id;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Frame{" + "id=" + id + ", material=" + material + '}';
    }
     
    
    
    
    


}


