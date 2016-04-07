/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.classes;

import java.util.GregorianCalendar;

/**
 *
 * @author bpbyt3
 */
public class Request {
    private GregorianCalendar requestDate;
    private GregorianCalendar responseDate;
    private ReqStatus status;
    private Customer customer;
    private Movie movie;

    public Request(Customer customer, Movie movie, GregorianCalendar reqDate, GregorianCalendar respDate, ReqStatus status){
        this.requestDate = reqDate;
        this.responseDate = respDate;
        this.status = status;
        this.customer = customer;
        this.movie = movie;
    }
    
}
