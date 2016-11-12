/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author cmg5831
 */
public abstract class Media implements Serializable{
    

    private String genre = "";
    private String year = "";
    private String title = "";
    private String artist = "";
    private String lengthInSeconds = "";
    private ArrayList<Rating> theListOfRatings;
    
    public Media(){
        System.out.println("Called: Media()");
    }
    
    public Media(String importMediaString){
        String delimiter = "\\t";
        String[] tempMediaArray = importMediaString.split(delimiter);
        this.genre = tempMediaArray[0];
        this.title = tempMediaArray[1];
        this.year = tempMediaArray[3]; 
        this.artist = tempMediaArray[2];
    }
    
    public Media(String newTitle, String newArtist, String newGenre, String newYear){
        this.genre = newGenre;
        this.artist = newArtist;
        this.title = newTitle;
        this.year = newYear;
    }
    
    public String getMediaTitle(){
        return title;
    }
    
    public String getMediaYear(){
        return year;
    }
    
    public String getMediaGenre(){
        return genre;
    }
    
    public String getMediaArtist(){
        return artist;
    }
    
    public ArrayList<Rating> getRatings(){
        if(theListOfRatings == null){
            theListOfRatings = new ArrayList<Rating>();
        }
        
        return theListOfRatings;
    }
    
    public void editMediaInfo(String newLength, String newTitle, String newArtist){
        title = newTitle;
        lengthInSeconds = newLength;
        artist = newArtist;
    }
    
    public void editMediaInfo2(String newTitle, String newArtist, String newGenre, String newYear){
        title = newTitle;
        artist = newArtist;
        genre = newGenre;
        year = newYear;
    }
    
    public Media(String newLength, String newTitle, String newArtist){
        title = newTitle;
        lengthInSeconds = newLength;
        artist = newArtist;
    }
    
    public void addRating(Rating newRating){
        if(theListOfRatings == null){
            theListOfRatings = new ArrayList<Rating>();
            theListOfRatings.add(newRating);
            
        }
        else{
            theListOfRatings.add(newRating);
        }
    }
    
    public Media(String title, String lengthInSeconds){

        this.title = title;
        this.lengthInSeconds = lengthInSeconds;
        //System.out.println("Called: Media(String title, int lengthInSeconds)");
    }
    
    public String toString(){
        String mediaString = this.title+" "+this.lengthInSeconds;
        return mediaString;
    }
  
    
    
    public ArrayList<Rating> getTheListOfRatings(){
        if(theListOfRatings == null){
            theListOfRatings = new ArrayList<Rating>();
            return theListOfRatings;
            
        }
        else{
            return theListOfRatings;
        }
    }
    
    public double getAverageRating(){

        Integer sum = 0;
        if(theListOfRatings == null){
             return 0;
        }
        else{
            for(int i = 0; i < theListOfRatings.size(); i++){
                int numRate = Integer.parseInt(theListOfRatings.get(i).getRating());
                sum = sum + numRate;
           
            }
        
        double average = (double) sum / theListOfRatings.size(); 
        System.out.println(sum);
        System.out.println(average);

         return average;
        }
        
    }
}
