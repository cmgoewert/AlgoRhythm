/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.WindowConstants;

/**
 *
 * @author cmg5831
 */
public class MediaUI extends JFrame{
    private MediaCntl parentMediaCntl = null;
    private JButton backButton;
    private JButton goButton;
    private JButton rateButton;
    private JPanel buttonPanel;
    private JPanel infoPanel;
    private JLabel artistLabel;
    private JLabel lengthLabel;
    private JLabel genreLabel;
    private JLabel yearLabel;
    private JLabel urlLabel;
    private JLabel titleLabel;
    private JTextField theArtist;
    private JTextField theYear;
    private JTextField theGenre;
    private JTextField theURL;
    private JTextField theSong;
    private JTextField theLength;
    private JPanel[] cellNumbers;
    private int index = -1;
    private SerializedDataCntl parentSerializedDataCntl = null;
    
    public MediaUI(MediaCntl newMediaCntl){
        parentMediaCntl = newMediaCntl;
        this.setVisible(true);
        initCustomComponents(false, 0);
    }
    
    public MediaUI(MediaCntl newMediaCntl, int songRow){
        parentMediaCntl = newMediaCntl;
        index = songRow;
        initCustomComponents(true, songRow);
        System.out.println("MADE IT YEA");
        this.setVisible(true);
    }
    
    public void initCustomComponents(boolean hasInfo, int songIndex){
        this.setSize(350, 200);
        this.setTitle("Song Info");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        goButton = new JButton("Save");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        
        backButton = new JButton("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        rateButton = new JButton("Rate");
        rateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               rateButtonActionPerformed(evt);
            }
        });
        
        buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(goButton);        
        infoPanel = new JPanel();
        
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5,2,0,0));
        
        //make the panels addressable
        cellNumbers = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            JPanel nextPanel = new JPanel();
            cellNumbers[i] = nextPanel;
            infoPanel.add(nextPanel);
        }
        
       
       
        titleLabel = new JLabel("Song: ");
        artistLabel = new JLabel("Artist: ");
        lengthLabel = new JLabel("Length: ");
        yearLabel = new JLabel("Year: ");
        urlLabel = new JLabel("Spotify URL: ");
        genreLabel = new JLabel("Genre: ");
        
        theURL = new JTextField(13);
        theURL.setEditable(true);
        
        theGenre = new JTextField(13);
        theGenre.setEditable(true);
        
        theYear = new JTextField(13);
        theYear.setEditable(true);

        theSong = new JTextField(13);
        theSong.setEditable(true);

        theArtist = new JTextField(13);
        theArtist.setEditable(true);

        theLength = new JTextField(13);
        theLength.setEditable(true);
        
        if(hasInfo){
            System.out.println(songIndex);
            String songInfo;
                songInfo = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia().get(songIndex).getTitle();
            String lengthInfo;
                lengthInfo = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia().get(songIndex).getLength();
            String artistInfo;
                artistInfo = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia().get(songIndex).getArtist();
            String yearInfo;
                yearInfo = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia().get(songIndex).getYear();
            String genreInfo;
                genreInfo = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia().get(songIndex).getGenre();
            String urlInfo;
                urlInfo = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia().get(songIndex).getURL();
            theSong.setText(songInfo);
            theArtist.setText(artistInfo);
            theLength.setText(lengthInfo);
            theYear.setText(yearInfo);
            theGenre.setText(genreInfo);
            theURL.setText(urlInfo);
            buttonPanel.add(rateButton);
        }
        
        

        
        cellNumbers[2].add(artistLabel);
        cellNumbers[3].add(theArtist);
        cellNumbers[4].add(genreLabel);
        cellNumbers[5].add(theGenre);
        cellNumbers[0].add(titleLabel);
        cellNumbers[1].add(theSong);
        cellNumbers[6].add(yearLabel);
        cellNumbers[7].add(theYear);
        cellNumbers[8].add(urlLabel);
        cellNumbers[9].add(theURL);
       
        
        //
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(infoPanel, BorderLayout.CENTER);
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt){
        MediaUI.this.parentMediaCntl.getMediaListUI();
        this.setVisible(false);
    }
    
    private void rateButtonActionPerformed(java.awt.event.ActionEvent evt){
        MediaUI.this.parentMediaCntl.getRatingUI();
        this.setVisible(false);
    }
    
    private void goButtonActionPerformed(ActionEvent evt){
//        if(index == -1){
//            MediaUI.this.parentMediaCntl.addNewSong(theSong.getText(),theArtist.getText(),theLength.getText());
//            MediaUI.this.parentMediaCntl.getMediaTableModel().fireTableDataChanged();
//        }
//        else{
//            MediaUI.this.parentMediaCntl.editSongInfo(index, theSong.getText(),theArtist.getText(),theLength.getText());
//            MediaUI.this.parentMediaCntl.getMediaTableModel().fireTableDataChanged();
//
//        }       
        if(index == -1){
            MediaUI.this.parentMediaCntl.addNewSong2(theSong.getText(),theArtist.getText(),theGenre.getText(),theYear.getText(),theURL.getText());
            MediaUI.this.parentMediaCntl.getMediaTableModel().fireTableDataChanged();
        }
        else{
            MediaUI.this.parentMediaCntl.editSongInfo2(index, theSong.getText(),theArtist.getText(),theGenre.getText(),theYear.getText(),theURL.getText());
            MediaUI.this.parentMediaCntl.getMediaTableModel().fireTableDataChanged();

        }          
    }
}
