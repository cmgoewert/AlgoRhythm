/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chandler
 */
public class MainMenuUI extends JFrame {
    
    private NavigationCntl parentNavCntl = null;
    private JPanel mainMenuPanel;
    private JPanel buttonPanel;
    private JPanel importPanel;
    private JButton closeButton;
    private JButton mediaListButton;
    private JButton importButton;
   
    public MainMenuUI(NavigationCntl newParentNavCntl) {
        parentNavCntl = newParentNavCntl;
        initComponents();
    }
    
    private void initComponents(){
        this.setSize(350, 400);
        this.setTitle("Main Menu");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        mediaListButton = new JButton("        Media List        ");
            mediaListButton.setSize(100,40);
            mediaListButton.addActionListener(new MediaListener());
        closeButton = new JButton("Close ALGORHYTHM");
            closeButton.setSize(30,40);
            closeButton.addActionListener(new CancelListener());
        importButton = new JButton("     Import Songs     ");
            importButton.setSize(100,40);
            importButton.addActionListener(new ImportListener());
        
        buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        mainMenuPanel = new JPanel();
        mainMenuPanel.add(mediaListButton);
        importPanel = new JPanel();
        importPanel.add(importButton);
        
        
            
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(mainMenuPanel, BorderLayout.NORTH);
        this.getContentPane().add(importPanel, BorderLayout.CENTER);
        
        
    }
    
    class CancelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, "Cancel button was clicked!");
            System.exit(0);
        }
    }
    
    class MediaListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
                MainMenuUI.this.parentNavCntl.requestMediaCntl();
        }
    }
    
    class ImportListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
                parentNavCntl.importMedia();
        }
    }
    
    
    
    //add a button import media 
    // parentNavigationCntl.importMedia(); on action
}
