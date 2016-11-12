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
public class NavigationCntl {
    
    private MainMenuUI theMainMenuUI = null;
    private MediaCntl theMediaCntl = null;
    private String navUsername = "";
    
    public NavigationCntl(String username){
        System.out.println("Made it to NavigationCntl");
        theMainMenuUI = new MainMenuUI(this);
        theMainMenuUI.setLocationRelativeTo(null);
        theMainMenuUI.setVisible(true);
        navUsername = username;
    }
    
    public String getTheUsername(){
        return navUsername;
    }
    
    public void requestMediaCntl(){
        theMainMenuUI.setVisible(false);
        theMediaCntl = new MediaCntl(this);
    }
   
    public void getNavigationCntl(){
        theMainMenuUI.setVisible(true);
    }
    
    public void importMedia(){
        ExternalDataCntl theExternalDataCntl = new ExternalDataCntl();
    }

}
