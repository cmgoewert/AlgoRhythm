/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author cmg5831
 */
public class LoginUIv2 extends JFrame {
    
    private LoginCntl parentLoginCntl = null;
    private JPanel thePanel;
    private JPanel buttonPanel;
    private JPanel[] cellNumbers;
    private JButton submitButton;
    private JButton cancelButton;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    
    String username = "";
    
    public LoginUIv2(LoginCntl newParentLoginCntl){
        
        parentLoginCntl = newParentLoginCntl;
        
        this.setSize(400, 250);
        this.setTitle("My Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
     
        buttonPanel = new JPanel();
        thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(4,1,0,0));
        
        //make the panels addressable
        cellNumbers = new JPanel[4];
        for (int i = 0; i < 4; i++) {
            JPanel nextPanel = new JPanel();
            cellNumbers[i] = nextPanel;
            thePanel.add(nextPanel);
        }
        
        //construct UI components
        JButton cancelButton = new JButton("Cancel");
            cancelButton.setSize(30,40);
            cancelButton.addActionListener(new CancelListener());
        submitButton = new JButton("Submit");
            submitButton.setSize(30,40);
            submitButton.addActionListener(new SubmitListener());
        usernameTextField = new JTextField();
            usernameTextField.setPreferredSize( new Dimension( 90, 24 ) );
        passwordField = new JPasswordField();
            passwordField.setPreferredSize( new Dimension(90, 24));
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        
        
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        //cellNumbers[18].add(cancelButton);
        //cellNumbers[17].add(submitButton);
        cellNumbers[0].add(usernameLabel);
        cellNumbers[1].add(usernameTextField);
        cellNumbers[2].add(passwordLabel);
        cellNumbers[3].add(passwordField);
        this.add(thePanel);
        this.add(buttonPanel);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(thePanel, BorderLayout.CENTER);
        this.getRootPane().setDefaultButton(submitButton);
    }
    
    class CancelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, "Cancel button was clicked!");
            System.exit(0);
        }
    }
    
    class SubmitListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
            username = usernameTextField.getText();
            char[] password = passwordField.getPassword();
            boolean authenticated = LoginUIv2.this.parentLoginCntl.requestAuthenticate(username, password);
        
            if(authenticated){
                 System.out.println("Authenticated");
                LoginUIv2.this.parentLoginCntl.requestNavigationCntl();
            }else{
                System.out.println("NOT Authenticated");
            }
        }
    }
    
    public String getUsername(){
        return username;
    }
}
