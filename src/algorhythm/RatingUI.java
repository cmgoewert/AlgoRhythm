package algorhythm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class RatingUI extends JFrame {
    
    private MediaCntl parentMediaCntl = null;
    private JPanel buttonPanel;
    private JPanel ratingPanel;
    private JPanel buttonGroup;
    private JPanel averagePanel;
    private JPanel commentPanel;
    private JPanel commentListPanel;
    private JPanel userRatingsPanel;
    private JPanel[] cellNumbers;
    private JLabel commentLabel;
    private JLabel ratingLabel;
    private JLabel previousCommentsLabel;
    private JLabel allRatings;
    private JLabel average;
    private JTextArea userComment;
    private JTextArea avgRatingField;
    private JTextArea selectedComment;
    private JButton backButton;
    private JButton submitButton;
    private JScrollPane theScrollPane;
    private JScrollPane theScrollPane2;
    private JScrollPane theScrollPane3;
    private JRadioButton rate1;
    private JRadioButton rate2;
    private JRadioButton rate3;
    private JRadioButton rate4;
    private JRadioButton rate5;
    private ButtonGroup group;
    private String previousComments;
    private String ratingsList;

    public RatingUI(MediaCntl newMediaCntl){
        parentMediaCntl = newMediaCntl;
        initComponents();
    }
    
    private void initComponents(){
        this.setSize(900, 420);
        this.setTitle("Rating");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        submitButton = new JButton("Submit");
            submitButton.setSize(30,40);
            submitButton.addActionListener(new RatingListener());
        backButton = new JButton("Back");
            backButton.setSize(30,40);
            backButton.addActionListener(new BackListener());
        
        buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(submitButton);
               
        ratingPanel = new JPanel();
        ratingPanel.setLayout(new GridLayout(3,2,0,0));
        
        cellNumbers = new JPanel[5];
        for (int i = 0; i < 5; i++) {
            JPanel nextPanel = new JPanel();
            cellNumbers[i] = nextPanel;
            ratingPanel.add(nextPanel);
        }       
        
     commentListPanel = new JPanel();
            previousCommentsLabel = new JLabel("Previous Comments:");
            selectedComment = new JTextArea(100, 300);
            selectedComment.setEditable(false);
            previousComments = RatingUI.this.parentMediaCntl.returnListOfComments();
            RatingUI.this.selectedComment.setText(previousComments);
            theScrollPane = new JScrollPane(selectedComment);
                theScrollPane.setPreferredSize(new Dimension(300, 100));
                theScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            commentListPanel.add(previousCommentsLabel);
            commentListPanel.add(theScrollPane);
        
        commentPanel = new JPanel();
            commentLabel = new JLabel("    Comment:");
            userComment = new JTextArea(100, 300);            
                userComment.setEditable(true);
            theScrollPane3 = new JScrollPane(userComment);
                theScrollPane3.setPreferredSize(new Dimension(300, 100));
                theScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            commentPanel.add(commentLabel);
            commentPanel.add(theScrollPane3);
                          
        buttonGroup = new JPanel();
            ratingLabel = new JLabel("Rating:");
                rate1 = new JRadioButton("1");
                rate2 = new JRadioButton("2");
                rate3 = new JRadioButton("3");
                rate4 = new JRadioButton("4");
                rate5 = new JRadioButton("5");
            buttonGroup.add(ratingLabel);
                buttonGroup.add(rate1);
                buttonGroup.add(rate2);
                buttonGroup.add(rate3);
                buttonGroup.add(rate4);
                buttonGroup.add(rate5);
        group = new ButtonGroup();
            group.add(rate1);
            group.add(rate2);
            group.add(rate3);
            group.add(rate4);
            group.add(rate5);
        
        userRatingsPanel = new JPanel();
            allRatings = new JLabel("      Previous Ratings:");
            avgRatingField = new JTextArea(100, 300);
                avgRatingField.setEditable(false);
                ratingsList = this.parentMediaCntl.computeListOfRatings();
                avgRatingField.setText(ratingsList);
            theScrollPane2 = new JScrollPane(avgRatingField);
                theScrollPane2.setPreferredSize(new Dimension(300, 100));
                theScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            userRatingsPanel.add(allRatings);
            userRatingsPanel.add(theScrollPane2);
            
            averagePanel = new JPanel();
                average = new JLabel("Average Rating: " + this.parentMediaCntl.getAverageRating());
                averagePanel.add(average);
            
        cellNumbers[3].add(userRatingsPanel);
        cellNumbers[1].add(commentListPanel);
        cellNumbers[2].add(buttonGroup);
        cellNumbers[0].add(commentPanel);
        cellNumbers[4].add(averagePanel);
    
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(ratingPanel, BorderLayout.CENTER);
        this.getRootPane().setDefaultButton(submitButton);           
    }
    
    class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            RatingUI.this.parentMediaCntl.getMediaUI(RatingUI.this.parentMediaCntl.getCurrentSongIndex());
            RatingUI.this.setVisible(false);
        }
    }

    class RatingListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String comment = userComment.getText();
            String rating = "0";
            
            if(group.getSelection() != null){
                if(rate1.isSelected()){
                    rating = "1";
                }
                else if(rate2.isSelected()){
                    rating = "2";
                }
                else if(rate3.isSelected()){
                    rating = "3";
                }
                else if(rate4.isSelected()){
                    rating = "4";
                }
                else if(rate5.isSelected()){
                    rating = "5";
                }
                System.out.println(rating);
                System.out.println(comment);
   
                Rating ratingToPass = new Rating(parentMediaCntl.getUsername(), comment, rating);
                RatingUI.this.parentMediaCntl.addNewRating(ratingToPass);
                RatingUI.this.parentMediaCntl.returnMediaListUI();
            }
            else{
                JOptionPane.showMessageDialog(null, "You must enter a rating!");
            }
            
        }
    }
}

