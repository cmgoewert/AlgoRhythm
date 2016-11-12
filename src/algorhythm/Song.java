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
public class Song extends Media implements Serializable{
    
   
   private String spotifyURL = "";
    
    public Song(){
        System.out.println("Called: Song()");
    }
    
    public Song(String importSongString){
        super(importSongString);
        String delimiter = "\\t";
        String[] tempSongArray = importSongString.split(delimiter);
        try{
            this.spotifyURL = tempSongArray[4];
            
        }catch(ArrayIndexOutOfBoundsException e){
            
        }       
    }
    
    
    public Song(String newTitle, String newLength, String newArtist){
        super(newTitle, newLength, newArtist);
        System.out.println("Called: Song(String newTitle, int newLength, String newArtist)");
    }
    
    public Song(String newTitle, String newArtist, String newGenre, String newYear, String newURL){
        super(newTitle, newArtist, newGenre, newYear);
        spotifyURL = newURL;
    }
    
    public String getTitle(){
        return super.getMediaTitle();
    }
    
    public String getLength(){
        return super.getMediaYear();
    }
    
    public String getArtist(){
        return super.getMediaArtist();
    }
    
    public String getGenre(){
        return super.getMediaGenre();
    }
    
    public String getYear(){
        return super.getMediaYear();
    }
    
    public String getURL(){
        return spotifyURL;
    }
    public void changeInfo(String newTitle, String newLength, String newArtist){
        this.editMediaInfo(newLength, newTitle, newArtist);
    }
    
    public void changeInfo2(String newTitle, String newArtist, String newGenre, String newYear, String newURL){
        this.editMediaInfo2(newTitle, newArtist, newGenre, newYear);
        this.spotifyURL = newURL;
    }
    
    public static int getFakeNumber(){
        return 100;
    }
    
    public String toString(){
        String songString = super.toString();
        return songString;
    }
    
    public boolean equals(Object theObject){
        
        Song song2compare = (Song) theObject;
        if(this.toString().equals(song2compare.toString()))
            return true;
        else
            return false;
    }
}
