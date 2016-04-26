/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.classes;

import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 *
 * @author bpbyt3
 */
public class Rental {
    private GregorianCalendar rentDate;
    private GregorianCalendar returnDate;
    private boolean rentStatus;
    private DVD dvd;
    private Customer customer;
    private Review review;
    private boolean byMail;
    
    public Rental(Customer customer, DVD dvd, GregorianCalendar rentDate, boolean byMail){
        this.rentDate = rentDate;
        this.returnDate = new GregorianCalendar(); // this will be changed upon return
        this.rentStatus = true; // this will be changed on return
        this.dvd = dvd;
        this.customer = customer;
        this.review = null;
        this.byMail = byMail; 
    }
    
    // make sure the rental can only have 1 review
    public void addReview(Review r){
        if (review != null){
            System.out.println("A Rental may only have at most 1 review");
            return;
        }
        review = r;
    }
    
    public void setReturnDate(GregorianCalendar date){
        this.returnDate = date;
    }
    
    public void setRentedStatus(boolean status){
        this.rentStatus = status;
    }
    
 
    
    public Review getReview(){
        return this.review;
    }
    
    public GregorianCalendar getRentDate(){
        return this.rentDate;
    }
    
    public GregorianCalendar getReturnDate(){
        return this.returnDate;
    }
    
    public DVD getDVD(){
        return this.dvd;
    }
    
    public boolean getRentStatus(){
        return this.rentStatus;
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public String getType(){
        if(byMail){
            return " by Mail . . .";
        }
        else{
            return " in-store . . .";
        }
    }
}
