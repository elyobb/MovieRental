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
public class Rental {
    private GregorianCalendar rentDate;
    private GregorianCalendar returnDate;
    private RentStatus rentStatus;
    
    public Rental(GregorianCalendar rentDate, GregorianCalendar returnDate, RentStatus rentStatus){
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentStatus = rentStatus;
    }
}
