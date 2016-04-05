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
public class Customer {
    private String email;
    private String address;
    private int phoneNo;
    private String password;
    private String name;
    
    public Customer(String email, String address, int phone, String pass, String name){
        this.email = email;
        this.address = address;
        this.phoneNo = phone;
        this.password = pass;
        this.name = name;
    }
}
