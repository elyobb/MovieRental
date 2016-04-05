/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.classes;

import java.util.LinkedList;

/**
 *
 * @author bpbyt3
 */


public class Movie {
    private Rating rating;
    private Genre genre;
    private int year;
    private String name;
    
    private LinkedList<Actor> actors;
    
    
    public Movie(Rating rating, Genre genre, int yr, String name){
        this.rating = rating;
        this.genre = genre;
        this.year = yr;
        this.name = name;
        
        this.actors = new LinkedList();
    }
    
    public String getName(){
        return name;
    }
    
    public void addActor(Actor a){
        actors.add(a);
    }
}
