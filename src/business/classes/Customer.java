/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 *
 * @author bpbyt3
 */
public class Customer {
    private String email;
    private String address;
    private String phoneNo;
    private String password;
    private String name;
    private LinkedList<Request> requests;
    private LinkedList<Rental> rentals;
    
    public Customer(String email, String address, String phone, String pass, String name){
        this.email = email;
        this.address = address;
        this.phoneNo = phone;
        this.password = pass;
        this.name = name;
        this.requests = new LinkedList();
        this.rentals = new LinkedList();
    }
    
    public void rent(Rental r){
        rentals.add(r);
    } 
    
    public void returnRental(Rental r, GregorianCalendar returnDate){
        r.setReturnDate(returnDate);
        GregorianCalendar cutOff = r.getRentDate();
        cutOff.add(Calendar.DAY_OF_YEAR, 10);
        
        if (returnDate.after(cutOff)){
            System.out.println("You have been charged a late fee of $.01 / day late");
            
            int currDay = returnDate.get(Calendar.DAY_OF_YEAR);
            int cutoffDay = cutOff.get(Calendar.DAY_OF_YEAR);
            int diff = currDay - cutoffDay;
            
            double rate = diff * .01;
            
            System.out.println("Charge: $" + rate);
            
            
            r.getDVD().setLateStatus(true);
        }
        r.setRentedStatus(false);
    }
    
    public void addRequest(Request r){
        requests.add(r);
    }
    
    public LinkedList<Request> getRequests(){
        return this.requests;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getphoneNum(){
        return this.phoneNo;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getName(){
        return this.name;
    }
}
