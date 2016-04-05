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

    public Request(GregorianCalendar reqDate, GregorianCalendar respDate, ReqStatus status){
        this.requestDate = reqDate;
        this.responseDate = respDate;
        this.status = status;
    }
    
}
