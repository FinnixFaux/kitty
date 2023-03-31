package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

class createframe extends JFrame implements ActionListener {
	
	JButton cancel;
	JButton create;
	JTextField user;
	JPasswordField pass;
	JPasswordField confirmpass;
	String username;
	char[] password;
	char[] confirmpassword;
	
	Color textbox = Color.decode("#665466");
	Color blue = Color.decode("#23B5FF");
	Color plum = Color.decode("#42273D");
	
    createframe (){
		
		cancel = new JButton();
		cancel.setBounds(90, 250, 150, 30);
		cancel.addActionListener(this);
		cancel.setText("Cancel");
		cancel.setOpaque(false);
		cancel.setContentAreaFilled(false);
		cancel.setBorder(new LineBorder(textbox));
		cancel.setForeground(textbox);
		cancel.setFocusable(false);
		
		create = new JButton();
		create.setBounds(90, 210, 150, 30);
		create.addActionListener(this);
		create.setBackground(blue);
		create.setBorder(null);
		create.setText("Register");
		create.setFocusable(false);
		create.setForeground(plum);
	    
		user = new JTextField();
		user.setBounds(90, 60, 150, 30);
		user.setBackground(textbox);
		user.setBorder(null);
		user.setForeground(plum);

		pass = new JPasswordField();
		pass.setBounds(90, 110, 150, 30);
		pass.setBackground(textbox);
		pass.setBorder(null);
		pass.setForeground(plum);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(90, 160, 150, 30);
		confirmpass.setBackground(textbox);
		confirmpass.setBorder(null);
		confirmpass.setForeground(plum);
		
		this.add(user);
		this.add(pass);
		this.add(cancel);
		this.add(create);
		this.add(confirmpass);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		setVisible(true);
		setSize(550, 390);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Register ★");
	    setResizable(false);
        
    }
		
    @Override
    public void actionPerformed(ActionEvent e) {

        String username = user.getText();
        char[] password = pass.getPassword();
        char[] confirmpassword = confirmpass.getPassword();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(createframe.this, "Please enter a username.");
            
        } else if (password.length == 0) {
            JOptionPane.showMessageDialog(createframe.this, "Please enter a password.");
            
        } else if (!passwordMatches(password, confirmpassword)) {
            JOptionPane.showMessageDialog(createframe.this, "Passwords do not match.");
            
        } else {

            if (e.getSource().equals(cancel)) {
                this.dispose();
                new frame();
                
            } else {
            	
                String storedUsername = username;
                String storedPassword = new String(password);

                JOptionPane.showMessageDialog(createframe.this, "Registration successful.");
                new frame();
                this.dispose();
            }
        }
    }
         
    private boolean passwordMatches(char[] pass, char[] confirmpass) {
        if (pass.length != confirmpass.length) {
            return false;
        }
        for (int i = 0; i < pass.length; i++) {
            if (pass[i] != confirmpass[i]) {
                return false;
            }
        }
        return true;
    }
}