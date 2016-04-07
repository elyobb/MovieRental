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
public class Review {
    private double rating;
    private String review;
    private Rental rental;
    public Review(Rental rental, double rating, String review){
        this.review = review;
        this.rating = rating;
        this.rental = rental;
    }
    
    public double getRating(){
        return rating;
    }
    
    public String getReview(){
        return review;
    }
    
    public Rental getRental(){
        return rental;
    }

}
