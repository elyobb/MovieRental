/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.classes;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
    
    public void rent(Rental r, boolean paymentMade){
        String output = "";
        output += this.name + " wants to rent "+ r.getDVD().getMovie().getName() + r.getType();
        System.out.println(output);
        if(!paymentMade){
            System.out.println(this.name + "did not make the required payment. Aborting rental.");
            return;
        }
        else{
            System.out.println(this.name + " made the rental payment.");
        }
        rentals.add(r);
        System.out.println(this.name + " has successfully rented "+ r.getDVD().getMovie().getName());
                
                
    } 
    
    public void returnRental(Rental r, GregorianCalendar returnDate){
        
        System.out.println(this.name+ " wants to return "+ r.getDVD().getMovie().getName()+". . .");
        System.out.println(this.name + " provides the DVD serial: " + r.getDVD().getSerialNo()+".");
        
        r.setReturnDate(returnDate);
        GregorianCalendar cutOff = r.getRentDate();
        // the late return cutoff is 7 days 
        cutOff.add(Calendar.DAY_OF_YEAR, 07);
        
        if (returnDate.after(cutOff)){
            System.out.println("But the rental is overdue.");
            System.out.println(this.name +", you have been charged a late fee of $.01 / day.");
            
            int currDay = returnDate.get(Calendar.DAY_OF_YEAR);
            int cutoffDay = cutOff.get(Calendar.DAY_OF_YEAR);
            int diff = currDay - cutoffDay;
            
            System.out.println("Days late : " + diff);
            
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            Number rate = diff * .01;
            double rateDecimal = rate.doubleValue();
            
            System.out.println("Late fee Charge: $" + df.format(rateDecimal));
            r.getDVD().setLateStatus(true);
        }
        System.out.println(this.name + " has successfully returned " + r.getDVD().getMovie().getName());
        r.setRentedStatus(false);
        rentals.remove(r);
    }
    
    public void addRequest(Request r){
        requests.add(r);
    }
    
    public LinkedList<Rental> getRentals(){
        return this.rentals;
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
