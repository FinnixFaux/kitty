package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


class frame extends JFrame implements ActionListener{
	
	JButton log;
	JButton cancel;
	JButton create;
	JTextField user;
	JPasswordField pass;
	JLabel pas;
	JLabel use;
	
	Color textbox = Color.decode("#665466");
	Color blue = Color.decode("#23B5FF");
	Color plum = Color.decode("#42273D");
	
	ImageIcon back = new ImageIcon (new ImageIcon("bg.png").getImage().getScaledInstance(350, 390, Image.SCALE_SMOOTH));
	ImageIcon logs = new ImageIcon (new ImageIcon("login.png").getImage().getScaledInstance(350, 390, Image.SCALE_SMOOTH));

	frame(){
		
		use = new JLabel();
		use.setText("Username");
		use.setBounds(90, -20, 150, 90);
		use.setVisible(true);
		use.setSize(120,150);
		use.setForeground(textbox);
		
		pas = new JLabel();
		pas.setText("Password");
		pas.setBounds(90, 60, 150, 90);
		pas.setVisible(true);
		pas.setSize(120,150);
		pas.setForeground(textbox);
		
		log = new JButton();
		log.setBounds(180, 250, 60, 30);
		log.addActionListener(this);
		log.setOpaque(false);
		log.setContentAreaFilled(false);
		log.setBorder(new LineBorder(textbox));
		log.setForeground(textbox);
		log.setFocusable(false);
		log.setText("Login");
		
		cancel = new JButton();
		cancel.setBounds(90, 250, 60, 30);
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
		create.setText("Create Account");
		create.setFocusable(false);
		create.setForeground(plum);
	    
		user = new JTextField();
		user.setBounds(90, 70, 150, 40);
		user.setBackground(textbox);
		user.setBorder(null);
		user.setForeground(plum);

		pass = new JPasswordField();
		pass.setBounds(90, 150, 150, 40);
		pass.setBackground(textbox);
		pass.setBorder(null);
		pass.setForeground(plum);
		
		this.setContentPane(new JLabel(back));
		this.add(pas);
		this.add(use);
		this.add(user);
		this.add(pass);
		this.add(log);
		this.add(cancel);
		this.add(create);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		setIconImage(logs.getImage());
		setVisible(true);
		setSize(350, 390);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("login ★");
	    setResizable(false); 
	    
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(create)) {
			new createframe();
			this.dispose();	
		}
		
		if(e.getSource().equals(log)) {
			if(username.equals(user.getText()) && password.equals(new String (pass.getPassword()))) {
				JOptionPane.showMessageDialog(this, "Successfully Login!");
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Incorrect Username/Password!", "Incorrect Credentials", JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource().equals(cancel)) {
			int res = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
			if(res == JOptionPane.YES_OPTION) {
				this.dispose();
			
			}
		}
		
	}
}
