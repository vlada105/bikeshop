/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Brand;
import model.Category;
import model.Frame;
import model.Item;
import model.Payment;
import model.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author VLADA
 */
public class Upiti {
    
    public static void addBrand(Brand newBrand) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.save(newBrand);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    public static void addCategory(Category newCategory) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.save(newCategory);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    
    public static void addFrame(Frame newFrame) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.save(newFrame);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    
    public static List<Brand> getAllBrands() {
        List<Brand> brendovi;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();

        String hql = "from Brand";
        Query query = sesija.createQuery(hql);
        brendovi = query.list();

        sesija.getTransaction().commit();
        sesija.close();
        return brendovi;
    }
    
    
    
    
    
    
    
    
    
    public static void deleteBrand(Brand b) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.delete(b);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    
    
    public static List<Category> getAllCategories() {
        List<Category> kategorije;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();

        String hql = "from Category";
        Query query = sesija.createQuery(hql);
        kategorije = query.list();

        sesija.getTransaction().commit();
        sesija.close();
        return kategorije;
    }
    
    public static void deleteCategory(Category c) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.delete(c);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    
    public static List<Frame> getAllFrames() {
        List<Frame> frames;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();

        String hql = "from Frame";
        Query query = sesija.createQuery(hql);
        frames = query.list();

        sesija.getTransaction().commit();
        sesija.close();
        return frames;
    }
    
    public static void deleteFrame(Frame f) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.delete(f);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    public static Brand getBrandByID(int brand_id){
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        Brand b = (Brand) sesija.get(Brand.class, brand_id);
        
        sesija.getTransaction().commit();
        sesija.close();
        return b;
        
    }
    
    public static Category getCategoryByID(int category_id){
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        Category c =  (Category) sesija.get(Category.class, category_id);
        
        sesija.getTransaction().commit();
        sesija.close();
        return c;
        
    }
    
    public static Frame getFrameByID(int frame_id){
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        Frame f =  (Frame) sesija.get(Frame.class, frame_id);
        
        sesija.getTransaction().commit();
        sesija.close();
        return f;
        
    }
    
    
    
    
    public static void addItem(Item newItem) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.save(newItem);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    
    public static List<Item> getAllItems() {
        List<Item> items;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();

        String hql = "from Item";
        Query query = sesija.createQuery(hql);
        items = query.list();

        sesija.getTransaction().commit();
        sesija.close();
        return items;
    
    }
    
    
    public static void deleteItem(Item i) {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        sesija.delete(i);
        sesija.getTransaction().commit();
        sesija.close();
    }
    
    
    public static List<Item> getItemsForBrandID(int id) {
        List<Item> items;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        String hql = "from Item where brand_id = :id";
        Query query = sesija.createQuery(hql);
        query.setParameter("id", id);
        items = query.list();
        sesija.getTransaction().commit();
        sesija.close();
        return items;
    }
    
    public static List<Item> getItemsForCategoryID(int id) {
        List<Item> items;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        String hql = "from Item where category_id = :id";
        Query query = sesija.createQuery(hql);
        query.setParameter("id", id);
        items = query.list();
        sesija.getTransaction().commit();
        sesija.close();
        return items;
    }
    
    
    
    public static List<Item> getItemsForFrameID(int id) {
        List<Item> items;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        String hql = "from Item where frame_id = :id";
        Query query = sesija.createQuery(hql);
        query.setParameter("id", id);
        items = query.list();
        sesija.getTransaction().commit();
        sesija.close();
        return items;
    }
    
    
    
    public static Item getItemByID(int item_id){
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        Item i = (Item) sesija.get(Item.class, item_id);
        
        sesija.getTransaction().commit();
        sesija.close();
        return i;
        
    }
    
    public static User getUserByUsername(String username){
        
        List<User> users;
        
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        
        String hql = "from User where username = :uname";
        Query query = sesija.createQuery(hql);
        query.setParameter("uname", username);
        users = query.list();
        
        User u = users.get(0);
        
        sesija.getTransaction().commit();
        sesija.close();
        return u;
        
    }
    
    public static List<Payment> getPaymentsForUserID(int id) {
        List<Payment> payments;
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        String hql = "from Payment where user_id = :id";
        Query query = sesija.createQuery(hql);
        query.setParameter("id", id);
        payments = query.list();
        sesija.getTransaction().commit();
        sesija.close();
        return payments;
    }
    
    public static void deleteOrderByID(String order_id)
            throws SQLException {
        
        Connection conn = DBConnection.getConn();
        String sql ="delete from payment where id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, order_id);
            
            pst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
        
    
    
    
    
    
}
