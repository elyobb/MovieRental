/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import business.classes.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author bpbyt3
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.simulateAllActivity();     
    }
    
}
