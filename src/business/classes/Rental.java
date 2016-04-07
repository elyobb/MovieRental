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
    private RentStatus rentStatus;
    private DVD dvd;
    private Customer customer;
    private Review review;
    
    public Rental(Customer customer, DVD dvd, GregorianCalendar rentDate, GregorianCalendar returnDate, RentStatus rentStatus){
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentStatus = rentStatus;
        this.dvd = dvd;
        this.customer = customer;
        this.review = null;
    }
    
    // make sure the rental can only have 1 review
    public void addReview(Review r){
        if (review != null){
            System.out.println("A Rental may only have at most 1 review");
            return;
        }
        review = r;
    }
}
