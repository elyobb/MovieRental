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
public class DVD {
    private int serialNo;
    private boolean lost;
    private Movie movie;
    public DVD(Movie movie, int serial, boolean lost){
        this.serialNo = serial;
        this.lost = lost;
        this.movie = movie;
    }
}
