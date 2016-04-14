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
    private LinkedList<Keyword> keywords;
    
    public Movie(Rating rating, Genre genre, int yr, String name){
        this.rating = rating;
        this.genre = genre;
        this.year = yr;
        this.name = name;
        this.keywords = new LinkedList();
        this.actors = new LinkedList();
    }
    
    public String getInfo(){
        String info = "";
        info += "Name: " + this.name + "\n";
        info += "Genre: " + this.getGenre().toString() + "\n";
        info += "Year: " + this.year + "\n";
        info += "Keywords: ";
        for (Keyword k : keywords){
            info += k.getName() + ", ";
        }
        info += "\n";
        info += "Actors: ";
        for (Actor a: actors){
            info += a.getName() + ", ";
        }
        info += "\n";
        return info;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public Rating getRating(){
        return this.rating;
    }
    
    public Genre getGenre(){
        return this.genre;
    }
    
    public void addActor(Actor a){
        actors.add(a);
    }
    
    public void addKeyword(Keyword k){
        keywords.add(k);
    }
    
    public LinkedList<Keyword> getKeywords(){
        return this.keywords;
    }
    
    public LinkedList<Actor> getActors(){
        return this.actors;
    }
}
