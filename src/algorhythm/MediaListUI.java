/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;

import javax.swing.WindowConstants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author cmg5831
 */
public class MediaListUI extends JFrame {
    /*
    declare mediaCntl,
    jbutton back button,
    jbutton gobutton,
    jubtton deletebutton,
    jpanel button panel,
    jpanel table panel,
    jtable themediatable,
    jscrollpane the scrollpane
    */
    private MediaCntl theMediaCntl = null;
    private JButton backButton;
    private JButton goButton;
    private JButton deleteButton;
    private JButton addMediaButton;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JTable theMediaTable;
    private JScrollPane theScrollPane;
    private JPanel[] cellNumbers;
    private JOptionPane nothingSelected;
    
    public MediaListUI(MediaCntl parentMediaCntl){
        theMediaCntl = parentMediaCntl;
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        backButton = new JButton("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        addMediaButton = new JButton("Add Media");
        addMediaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        
        goButton = new JButton("View & Edit Media");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
    
        buttonPanel = new JPanel();
       
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addMediaButton);
        buttonPanel.add(goButton);

        //build media table panel
        theMediaTable = new JTable(this.theMediaCntl.getMediaTableModel());
        theMediaTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        theMediaTable.getColumnModel().getColumn(1).setPreferredWidth(15);
        theMediaTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        //then do col 1 and 2, 15 and 20 respectively

        theScrollPane = new JScrollPane(theMediaTable);
        theScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        theScrollPane.setPreferredSize(new Dimension(300, 320));
        theMediaTable.setFillsViewportHeight(true);

        tablePanel = new JPanel();
        tablePanel.add(theScrollPane);

        //put it all together
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
  
    }
    
    
    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(theMediaTable.getSelectedRow() == -1){
            
           MediaListUI.this.theMediaCntl.keepMediaListUI();
           JOptionPane.showMessageDialog(null, "Please select a Media!");        
        }
        else{
        int selectedTableRow = theMediaTable.getSelectedRow();
        int selectedModelRow = theMediaTable.convertRowIndexToModel(selectedTableRow);
        MediaListUI.this.theMediaCntl.getMediaUI(selectedModelRow);
        }
    }
    
       
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt){
        MediaListUI.this.theMediaCntl.getMediaUINoInfo();
    }
    
     private void backButtonActionPerformed(java.awt.event.ActionEvent evt){
         this.setVisible(false);
         MediaListUI.this.theMediaCntl.requestNavigationCntl();
 
    }
     
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt){
        int selectedTableRow = theMediaTable.getSelectedRow();
        int selectedModelRow = theMediaTable.convertRowIndexToModel(selectedTableRow);
        MediaListUI.this.theMediaCntl.getMediaList().getListOfMedia().remove(selectedModelRow);
        this.theMediaCntl.getMediaTableModel().fireTableDataChanged();
    }
}
