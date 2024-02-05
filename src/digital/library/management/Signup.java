package digital.library.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Signup extends JFrame implements ActionListener {

    JTextField nametext,emailtext,usertext;
    JPasswordField passwordtext,confirmtext;
    JButton signupbtn,exit;
    Signup(){
        setLayout(null);
        setTitle("Sign Up");

        JLabel name = new JLabel("Your Name:");
        name.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        name.setBounds(20,30,100,20);
        add(name);

        nametext = new JTextField();
        nametext.setBounds(125,30,250,25);
        nametext.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(nametext);

        JLabel email = new JLabel("E-Mail:");
        email.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        email.setBounds(20,65,100,20);
        add(email);

        emailtext = new JTextField();
        emailtext .setBounds(125,65,250,25);
        emailtext .setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(emailtext);

        JLabel username = new JLabel("Username:");
        username.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        username.setBounds(20,95,100,20);
        add(username);

        usertext = new JTextField();
        usertext.setBounds(125,95,250,25);
        usertext.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(usertext);


        JLabel password = new JLabel("Password:");
        password.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        password.setBounds(20,125,100,20);
        add(password);

        passwordtext = new JPasswordField();
        passwordtext.setBounds(125,125,250,25);
        passwordtext.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(passwordtext);

        JLabel confirm = new JLabel("Confirm");
        confirm.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        confirm.setBounds(20,155,100,20);
        add(confirm);

        confirmtext = new JPasswordField();
        confirmtext.setBounds(125,160,250,25);
        confirmtext.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(confirmtext);

        JLabel pass = new JLabel("Password:");
        pass.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        pass.setBounds(20,177,150,20);
        add(pass);


        signupbtn = new JButton("SIGN UP");
        signupbtn.setBounds(125,210,100,30);
        signupbtn.addActionListener(this);
        add(signupbtn);

        exit = new JButton("Back");
        exit.setBounds(275,210,100,30);
        exit.addActionListener(this);
        add(exit);


        setSize(450,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            String  name = nametext.getText();
            String email = emailtext.getText();
            String username = usertext.getText();
            String password = passwordtext.getText();
            String confirm = confirmtext.getText();
            if(!Objects.equals(password, confirm)){
                JOptionPane.showMessageDialog(null,"Password are not match");
            }
            else if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter your name");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your email id");
            }
            else if(username.equals("")){
                JOptionPane.showMessageDialog(null,"Username is required");
            }
            else if(password.equals("")){
                JOptionPane.showMessageDialog(null,"Password is required");
            }
        if(e.getSource()==signupbtn){
            try{
                Conn c = new Conn();
                String query = "insert into admindetails values('"+name+"','"+email+"','"+username+"','"+password+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Added Successfully");

                setVisible(false);
                new Login().setVisible(true);
            }catch(Exception ae){
                System.out.println(ae);
            }
        }
        else if(e.getSource()==exit){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Signup();
    }

}
