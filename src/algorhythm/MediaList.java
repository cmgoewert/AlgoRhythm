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
public class MediaList implements Serializable{
    private ArrayList<Song> theListOfMedia = null;
    private ExternalDataCntl parentExternalDataCntl = null;
    private SerializedDataCntl theSerializedDataCntl = null;
            
    public MediaList (){
        if(theListOfMedia == null){
            //buildTestUserList();

        }   
    }
    
    public void buildTestUserList(){
            theListOfMedia = new ArrayList<Song>();
            for (int i = 0; i < 100; i++){
            String songTitle = "Song Title "+i;
            String songLength = "10"+i;
            String songArtist = "Song Artist "+i;
            Song newSong = new Song(songTitle, songLength, songArtist);
            theListOfMedia.add(newSong);
        }
       
       
    }
    
    public ArrayList<Song> getListOfMedia(){
        if (theListOfMedia == null){
            theListOfMedia = new ArrayList<Song>();
        }
        return theListOfMedia;
    }
            /*consturctor if the list of media is null, then call buildtest media
            also need an acessor
            */
}
