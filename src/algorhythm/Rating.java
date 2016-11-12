/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;

/**
 *
 * @author cmg5831
 */
public class Rating {
    
    private String rating = "";
    private String username = "";
    private String comment = "";
    
    public Rating(){
        
    }
    
    
    public Rating(String newUsername){
        username = newUsername;
    }
    
    public Rating(String newUsername, String newRating){
        username = newUsername;
        rating = newRating;
    }
    
    public Rating(String newUsername, String newComment, String newRating){
        username = newUsername;
        rating = newRating;
        comment = newComment;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getRating(){
        return rating;
    }
    
    public String getComment(){
        return comment;
    }
}
