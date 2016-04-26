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
public class Controller {
    private LinkedList<DVD> dvds;
    private LinkedList<Customer> customers;
    private LinkedList<Request> requests;
    
    
    public Controller(){
        this.dvds = new LinkedList();
        this.customers = new LinkedList();
        this.requests = new LinkedList();
    }
    
    public void simulateAllActivity(){
         // create some movies
        Movie deadpool = new Movie(Rating.R, Genre.Action, 2016, "Deadpool");
        Movie minions = new Movie(Rating.PG, Genre.Comedy, 2015, "Minions");
        Movie taken = new Movie(Rating.PG_13, Genre.Drama, 2008, "Taken");
        Movie godzilla = new Movie(Rating.G, Genre.Horror, 1975, "Terror of Mechagodzilla");
        
        // add keywords
        Keyword gripping = new Keyword("Gripping");
        Keyword intense = new Keyword("Intense");
        Keyword lighthearted = new Keyword("Light-hearted");
        Keyword family = new Keyword("Family");
        Keyword epic = new Keyword("Epic");
        Keyword suspenseful = new Keyword("Suspenseful");
        Keyword hilarious = new Keyword("Hilarious");
        
        // give keywords to their movies
        deadpool.addKeyword(hilarious);
        deadpool.addKeyword(intense);
        minions.addKeyword(family);
        minions.addKeyword(hilarious);
        minions.addKeyword(lighthearted);
        taken.addKeyword(gripping);
        taken.addKeyword(suspenseful);
        godzilla.addKeyword(epic);
          
    
        // create actors
        Actor ryanReynolds = new Actor("Ryan Reynolds", Gender.Male);
        Actor sandraBullock = new Actor("Sandra Bullock", Gender.Female);
        Actor michaelKeaton = new Actor("Michael Keaton", Gender.Male);
        Actor liamNeeson = new Actor("Liam Neeson", Gender.Male);
        Actor tomokoAi = new Actor("Tomoko Ai", Gender.Female);
        Actor akihikoHirata = new Actor("Akihiko Hirata", Gender.Male);
        
        // add actors to respective movies
        deadpool.addActor(ryanReynolds);
        minions.addActor(sandraBullock);
        minions.addActor(michaelKeaton);
        taken.addActor(liamNeeson);
        godzilla.addActor(tomokoAi);
        godzilla.addActor(akihikoHirata);
        
        
        
        // create some customers
        Customer jimmy = new Customer("slippinjimmy@yahoo.com", "501 Alameda Ave, LA, CA", 
                "555-867-5309", "saulgoodman", "Jimmy McGill");
        Customer don = new Customer("", "1000 Madison Ave, NYC, NY", "555-123-4567", 
                "SCDP1963", "Dick Whitman");
        
        addCustomer(jimmy);
        addCustomer(don);
        
        DVD dvd1 = new DVD(deadpool, 01);
        DVD dvd2 = new DVD(deadpool, 02); // this DVD is lost
        DVD dvd3 = new DVD(minions, 03);
        DVD dvd4 = new DVD(taken, 04);
        DVD dvd5 = new DVD(godzilla, 05);
        
        addDVD(dvd1);
        addDVD(dvd2);
        addDVD(dvd3);
        addDVD(dvd4);
        addDVD(dvd5);
        
        // first let's see all the DVDs in our inventory
        System.out.println("\nA customer wants to check what is available to rent.");
        displayAvailableDVDs();
        
        
        
        // set the current renting time to "now"
        GregorianCalendar now = new GregorianCalendar();
        now.setTimeInMillis(System.currentTimeMillis());
        
        // jimmy wants to search for a movie like deadpool
        search(jimmy, "pool");
        
        // jimmy wants to rent deadpool
        Rental deadpool_rental = new Rental(jimmy, dvd1, now, false);
        makeRental(jimmy, deadpool_rental, true); // jimmy has the money for the payment
        
        System.out.println("\n");
        
        
        // jimmy searches for a family movie
        search(jimmy, "Family");
        
        // jimmy wants to rent minions
        Rental minions_rental = new Rental(jimmy, dvd3, now, false);
        makeRental(jimmy, minions_rental, true); // jimmy still has enough money
        
        System.out.println("\n");
        
        // don wants to rent deadpool
        Rental deadpool_rental2 = new Rental(don, dvd2, now, true);
        makeRental(don, deadpool_rental2, true); // don has the required funds
        
        System.out.println("\n");
        
        Rental taken_rental = new Rental(don, dvd4, now, true);
        makeRental(don, taken_rental, true);
        
        System.out.println("\n");
        
        /* Let's check back in on the inventory.
        At this point only thing left available is Terror of Mechagodzilla */
        displayAvailableDVDs();
        
        System.out.println("\n");
        
        // for whatever reason, don also wants the other copy of deadpool
        search(don, "Deadpool");
        System.out.println("All copies of Deadpool are unavailable. Don must take out a request.");
        Request deadpoolReq = new Request(don, deadpool, now);
        addRequest(deadpoolReq);
        
        System.out.println("\n");
        
        // jimmy wants to return deadpool but it is past the due date
        Object retDateObj = now.clone();
        GregorianCalendar retDate = (GregorianCalendar)retDateObj;
        retDate.add(Calendar.DAY_OF_YEAR, 32); // 22 days past 10 day loan cycle
        jimmy.returnRental(deadpool_rental, retDate);
        
        System.out.println("\n");
        
        // now the Request for deadpool by don can be honored and delivered
        honorRequest(deadpoolReq, now);
        
        System.out.println("\n");
        
        // don wants to return his deadpool and it is not overdue
        Object retDateObj2 = now.clone();
        GregorianCalendar retDate2 = (GregorianCalendar)retDateObj2;
        don.returnRental(deadpool_rental2, retDate2);
        
        System.out.println("\n");
        
        // don wants to return taken but it is past the due date
        Object retDateObj3 = now.clone();
        GregorianCalendar retDate3 = (GregorianCalendar)retDateObj3;
        retDate3.add(Calendar.DAY_OF_YEAR, 11); // 1 day past 10 day loan cycle
        don.returnRental(taken_rental, retDate3);
        
        System.out.println("\n");
        
        // jimmy wants to return minions
        Object retDateObj4 = now.clone();
        GregorianCalendar retDate4 = (GregorianCalendar)retDateObj4;
        retDate4.add(Calendar.DAY_OF_YEAR, 101); // 91 days past 10 day loan cycle
        jimmy.returnRental(minions_rental, retDate4);
        
       System.out.println("\n");
        
        // don comes back and wants to rent godzilla in store
        Rental godzilla_rental = new Rental(don, dvd5, now, false);
        makeRental(don, godzilla_rental, false);  // he does not have the funds
        
         /* Finally, let's display the available DVDs showing the fact that all previously
        rented DVDs are now returned */
        System.out.println("\nA customer wants to check what is available to rent.");
        displayAvailableDVDs();
        // in the final output we see that even godzilla is still available because Don failed to rent it
    }
    
    
    public void addDVD(DVD dvd){
        this.dvds.add(dvd);
    }
    
    public void addRequest(Request r){
        System.out.println(r.getCustomer().getName() + " takes out a request for " +
        r.getMovie().getName());
        this.requests.add(r);
    }
    
    public void honorRequest(Request r, GregorianCalendar time){
        r.setRespDate(time);
        r.setReqStatus(ReqStatus.responded);
        
        System.out.println("The request for " + r.getMovie().getName()
        + " has been honored. The movie is now available.");
        
    }
    public void addCustomer(Customer c){
        this.customers.add(c);
    }
    
    public DVD findDVD(int serial){
        
        for(DVD dvd : this.dvds){
            if(dvd.getSerialNo() == serial){
                return dvd;
            } 
        }
        return null; // DVD not found
    }
    
    public void displayAvailableDVDs(){
        System.out.println("\n***********************************");
        System.out.println("Available DVDs to rent:");
        
        for (DVD dvd : dvds){
            boolean isRented = false;
            for(Customer c : this.customers){
                for(Rental r : c.getRentals()){
                    if (r.getDVD().getSerialNo() == dvd.getSerialNo()){
                        isRented = true;
                    }
                }
            }
            System.out.println("DVD ID: "+ dvd.getSerialNo());
            System.out.println(dvd.getMovie().getInfo());
            if (isRented){
                System.out.println("Status: Unavailable");
                
            }
            else{
                System.out.println("Status: Available");
            }
            System.out.println("");
        }
        System.out.println("***********************************\n");
    }
  
    
    public void search(Customer cust, String data){
       
        System.out.println(cust.getName()+ " searches for movies containing '"+ data + "'\n");
        
        for (DVD dvd: dvds){
            if(dvd.getMovie().contains(data)){
                boolean isRented = false;
                for(Customer c : this.customers){
                    for(Rental r : c.getRentals()){
                        if (r.getDVD().getSerialNo() == dvd.getSerialNo()){
                            isRented = true;
                        }
                    }
                }
                System.out.println("DVD ID: "+ dvd.getSerialNo());
                System.out.println(dvd.getMovie().getInfo());
                if (isRented){
                    System.out.println("Status: Unavailable");
                }
                else{
                    System.out.println("Status: Available");
                }
                System.out.println("");

               
            }
        }
        
    }
    
    public void makeRental(Customer c, Rental r, boolean paymentMade){
            c.rent(r, paymentMade);           

    }
}
