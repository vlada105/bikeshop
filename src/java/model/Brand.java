
package model;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 *
 * @author VLADA//@Table(name="BRAND")
 */

@Entity
public class Brand {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
