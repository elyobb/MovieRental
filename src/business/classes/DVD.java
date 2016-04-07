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
    private boolean late;
    private Movie movie;
    public DVD(Movie movie, int serial){
        this.serialNo = serial;
        this.late = false;
        this.movie = movie;
    }
    
    public void setLateStatus(boolean late){
        this.late = late;
    }
    

    
    public Movie getMovie(){
        return this.movie;
    }
    
    public boolean getLateStatus(){
        return this.late;
    }
    
    public int getSerialNo(){
        return this.serialNo;
    }
}
