/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.classes;

/**
 *
 * @author bpbyt3
 */


public class Movie {
    private Rating rating;
    private Genre genre;
    private int year;
    private String name;
    
    
    public Movie(Rating rating, Genre genre, int yr, String name){
        this.rating = rating;
        this.genre = genre;
        this.year = yr;
        this.name = name;
    }
}
