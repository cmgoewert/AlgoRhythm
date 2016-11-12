/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author cmg5831
 */
public class MediaCntl {
    
    /*private = null,
        mediaList theMediaList
        mediaListUI theMediaListUI
        MideaUI theMediaUI
        mediaTableModel the
    */
    private MediaList theMediaList = null;
    private NavigationCntl theNavigationCntl = null;
    private MediaListUI theMediaListUI = null;
    private MediaUI theMediaUI = null;
    private RatingUI theRatingUI = null;
    private MediaTableModel theMediaTableModel = null;
    private Song tempSong;
    private int tempIndex = 0;
    
    public MediaCntl(NavigationCntl parentNavCntl){
        //System.out.println("MADE IT TO MEDIACNTL"); //test line
        theNavigationCntl = parentNavCntl;
        theMediaList = new MediaList();
        theMediaTableModel = new MediaTableModel(SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia());
        theMediaListUI = new MediaListUI(this);
        theMediaListUI.setVisible(true);
        
    }
    
    public MediaList getMediaList(){
        return theMediaList;
    }
    
    public MediaTableModel getMediaTableModel(){
        return theMediaTableModel;
    }
    
    public void getMediaUINoInfo(){
        theMediaUI = new MediaUI(this);
        //theMediaListUI.setVisible(false);
    }
    
    public void getMediaUI(int songRowToGet){
        tempIndex = songRowToGet;
        //theMediaListUI.setVisible(false);
        theMediaUI = new MediaUI(this, songRowToGet);
    }
    
    public int getCurrentSongIndex(){
        return tempIndex;
    }
    
    public void getMediaListUI(){
        theMediaUI.setVisible(false);
        theMediaUI.dispose();
        theMediaListUI.setVisible(true);            
    }
    
    public void getRatingUI(){
        theMediaUI.setVisible(false);
        theMediaUI.dispose();
        theRatingUI = new RatingUI(this);
        theRatingUI.setVisible(true);
    }
    
    public void returnMediaListUI(){
        theRatingUI.setVisible(false);
        theRatingUI.dispose();
        theMediaListUI.setVisible(true);
    }
    
    public void keepMediaListUI(){
        theMediaListUI.setVisible(false);
        theMediaListUI.dispose();
        theMediaListUI = new MediaListUI(this);
        theMediaListUI.setVisible(true);
    }
    
    public void requestNavigationCntl(){
        //theMediaListUI.setVisible(false); 
        theNavigationCntl.getNavigationCntl();
    }
    
    public void editSongInfo(int index, String newTitle, String newArtist, String newLength){
        //artistInfo = parentMediaCntl.getMediaList().getListOfMedia().get(songIndex).getArtist();
        tempSong = this.getMediaList().getListOfMedia().get(index);
        tempSong.changeInfo(newTitle, newLength, newArtist);
    }
    
    public void editSongInfo2(int index, String newTitle, String newArtist, String newGenre, String newYear, String newURL){
        tempSong = this.getMediaList().getListOfMedia().get(index);
        tempSong.changeInfo2(newTitle, newArtist, newGenre, newYear, newURL);
    }
    
    public void addNewSong(String newTitle, String newArtist, String newLength){
        Song newSong = new Song(newTitle, newLength, newArtist);
        theMediaList.getListOfMedia().add(newSong);
    }
    
    public void addNewSong2(String newTitle, String newArtist, String newGenre, String newYear, String newURL){
        
    }
    
    public void addNewRating(Rating newRating){
        tempSong = this.getMediaList().getListOfMedia().get(tempIndex);
        tempSong.addRating(newRating);
    }
    
    public double getAverageRating(){
        tempSong = this.getMediaList().getListOfMedia().get(tempIndex);
        double avg = tempSong.getAverageRating();
        return avg;
    }
    
    
    
    public String computeListOfRatings(){
        String ratingOutput = "";
        ArrayList<Rating> list = this.getMediaList().getListOfMedia().get(tempIndex).getTheListOfRatings();
        
        for(int i=0; i < list.size(); i++){
            ratingOutput = ratingOutput.concat(list.get(i).getRating() + "\n");

        }
        return ratingOutput;
        
    }
    
    public String returnListOfComments(){
        String theComment = "";
        ArrayList<Rating> list = this.getMediaList().getListOfMedia().get(tempIndex).getTheListOfRatings();
        
        for(int i=0; i < list.size(); i++){
            
            if(list.get(i).getComment().isEmpty()){
                System.out.println("comment is null");
            }else{
                theComment = theComment.concat("\"" + list.get(i).getComment() + "\""+
                        "  -"+list.get(i).getUsername()+ "\n");
            }
            
        }
        return theComment;
        
    }
    
    public String getUsername(){
        return theNavigationCntl.getTheUsername();
    }
}
