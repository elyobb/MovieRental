/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import business.classes.*;
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
        // add all to controller
        
        
    }
    
}
