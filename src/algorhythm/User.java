/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;


import java.io.Serializable;
/**
 *
 * @author cmg5831
 */
public class User implements Serializable{
    private String username = null;
    private char[] password = null;
    
    public User(String newUsername, char[] newPassword){
        username = newUsername;
        password = newPassword;
    }
    
    public String getUsername(){
        return username;
    }
    
    public char[] getPassword(){
        return password;
    }
}
