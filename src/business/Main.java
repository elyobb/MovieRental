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
        
        
        DVD dvd1 = new DVD(deadpool, 01);
        DVD dvd2 = new DVD(deadpool, 02); // this DVD is lost
        DVD dvd3 = new DVD(minions, 03);
        DVD dvd4 = new DVD(taken, 04);
        DVD dvd5 = new DVD(godzilla, 05);
        
        LinkedList<DVD> dvds = new LinkedList();
        dvds.add(dvd1);
        dvds.add(dvd2);
        dvds.add(dvd3);
        dvds.add(dvd4);
        dvds.add(dvd5);
        
        // set the current renting time to "now"
        GregorianCalendar now = new GregorianCalendar();
        now.setTimeInMillis(System.currentTimeMillis());
 
        // jimmy wants to rent deadpool
        Rental deadpool_rental = new Rental(jimmy, dvd1, now);
        jimmy.rent(deadpool_rental);
        
        // jimmy wants to rent minions
        Rental minions_rental = new Rental(jimmy, dvd3, now);
        jimmy.rent(minions_rental);
        
        // don wants to rent deadpool
        Rental deadpool_rental2 = new Rental(don, dvd2, now);
        don.rent(deadpool_rental2);
        Rental taken_rental = new Rental(don, dvd4, now);
        don.rent(taken_rental);
        
        // jimmy wants to return deadpool but it is past the due date
        Object retDateObj = now.clone();
        GregorianCalendar retDate = (GregorianCalendar)retDateObj;
        retDate.add(Calendar.DAY_OF_YEAR, 32);
        jimmy.returnRental(deadpool_rental, retDate);
        
    }
    
}
