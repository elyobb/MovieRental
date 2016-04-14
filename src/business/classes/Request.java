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

    public Request(Customer customer, Movie movie, GregorianCalendar reqDate){
        this.requestDate = reqDate;
        this.status = status;
        this.customer = customer;
        this.movie = movie;
        this.status = ReqStatus.requested;
    }
    
    public GregorianCalendar getReqDate(){
        return this.requestDate;
    }
    
    public void setReqStatus(ReqStatus newStatus){
        this.status = newStatus;
    }
    
    public GregorianCalendar getRespDate(){
        return this.responseDate;
    }
    
    public void setRespDate(GregorianCalendar respDate){
        this.responseDate = respDate;
    }
    
    public ReqStatus getReqStatus(){
        return this.status;
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public Movie getMovie(){
        return movie;
    }
    
    
}
