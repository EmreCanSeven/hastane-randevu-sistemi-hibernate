package main;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.Doktor;
import model.Hasta;
import model.User;
 
public class DbOperations {
 
 
    // Method Used To Create The Hibernate's SessionFactory Object
    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
 
        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        // Creating Hibernate Session Factory Instance
        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);      
        return factoryObj;
    }
 
    // Method 1: This Method Used To Create A New User Record In The Database Table
    public static long createRecordUser(User userObj) {
        Session sessionObj = getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        sessionObj.save(userObj);
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
        return userObj.getId();
    }
    
    public static void createRecordHasta(Hasta hastaobj) {
        Session sessionObj = getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        sessionObj.save(hastaobj);
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
//        return hastaobj.getId();
    }
 
    public static <T> void createRecordGenel(T obj) {
        Session sessionObj = getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        sessionObj.save(obj);
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
//        return hastaobj.getId();
    }
 
    public static <T> void createRecordGenel(T obj1, T obj2) {
        Session sessionObj = getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        sessionObj.save(obj1);
        sessionObj.save(obj2);
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
//        return hastaobj.getId();
    }
    
    // Method 2: This Method Is Used To Display The Records From The Database Table
    @SuppressWarnings("unchecked")
    public static List displayRecords() {
        Session sessionObj = getSessionFactory().openSession();
        List studentsList = sessionObj.createQuery("FROM User").list();
 
        // Closing The Session Object
        sessionObj.close();
        return studentsList;
    }
 
    // Method 3: This Method Is Used To Update A Record In The Database Table
//    public static void updateRecord(User userObj) {
//        Session sessionObj = getSessionFactory().openSession();
// 
//        //Creating Transaction Object  
//        Transaction transObj = sessionObj.beginTransaction();
//        User stuObj = (User) sessionObj.load(User.class, userObj.getId());
//        stuObj.setKullaniciAdi(userObj.getKullaniciAdi());
//        stuObj.setPassword(userObj.getPassword());
// 
//        // Transaction Is Committed To Database
//        transObj.commit();
// 
//        // Closing The Session Object
//        sessionObj.close();
//    }
 
    // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
    public static void deleteRecord(Integer userId) {
        Session sessionObj = getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        User studObj = findRecordById(userId);
        sessionObj.delete(studObj);
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
 
    }
 
    // Method 4(b): This Method To Find Particular Record In The Database Table
    public static User findRecordById(Integer userId) {
        Session sessionObj = getSessionFactory().openSession();
        User stu = (User) sessionObj.load(User.class, userId);
 
        // Closing The Session Object
        sessionObj.close();
        return stu;
    }
 
    // Method 5: This Method Is Used To Delete All Records From The Database Table
    public static void deleteAllRecords() {
        Session sessionObj = getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        Query queryObj = sessionObj.createQuery("DELETE FROM User");
        queryObj.executeUpdate();
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
    }
    
    
    // Method 4(b): This Method To Find Particular Record In The Database Table
    public static Doktor findDoktorById(Long id) {
        Session sessionObj = getSessionFactory().openSession();
        Doktor doktor = (Doktor) sessionObj.load(Doktor.class, id);
 
        // Closing The Session Object
        sessionObj.close();
        return doktor;
    }
    
//    public static List<Doktor> findDoktorListByDogumYeri(String sehir) {
//        Session sessionObj = getSessionFactory().openSession();
//        
// 
//        //criteria tanıml a  parametre olarak dogum yeri için sehir verilecek
//        
//        
//        // Closing The Session Object
//        sessionObj.close();
//        return doktorList;
//    }
}