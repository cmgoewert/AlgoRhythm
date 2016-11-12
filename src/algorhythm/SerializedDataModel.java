/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;
import java.io.Serializable;
/**
 *
 * @author Luke
 */
public class SerializedDataModel implements Serializable {
    private UserList theUserList;
    private MediaList theMediaList;
    
    public SerializedDataModel(){
        if(theUserList == null){
            theUserList = new UserList();
        }    
        if(theMediaList == null){
            theMediaList = new MediaList();
        }   
    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
    public MediaList getMediaList(){
        return theMediaList;
    }
    
     public void setMediaList(MediaList newMediaList){
        theMediaList = newMediaList;
    }
    
    public void setUserList(UserList newUserList){
        theUserList = newUserList;
    }
   
    






//
    public SerializedDataModel(UserList newUserList){
        theUserList = newUserList;
        if(theUserList == null){
            theUserList = new UserList();
        }    
    }
    
    
    
    
    
    public SerializedDataModel(MediaList newMediaList){
        theMediaList = newMediaList;
        if(theMediaList == null){
            theMediaList = new MediaList();
        }       
    }
    
   
    
    
    
    public SerializedDataModel(UserList newUserList, MediaList newMediaList){
        theUserList = newUserList;
        theMediaList = newMediaList;
        if(theUserList == null){
            theUserList = new UserList();
        }  
        if(theMediaList == null){
            theMediaList = new MediaList();
        }    
    }
    
    public SerializedDataModel getSerializedDataModel(){
        return this;
    }
}
