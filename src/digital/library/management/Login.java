package digital.library.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton loginbtn,signupbtn;
    JTextField usertext;
    JPasswordField passwordtext;

    Login(){
        setLayout(null);
        setTitle("Login");

        JLabel username = new JLabel("Username:");
        username.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        username.setBounds(100,40,80,20);
        add(username);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        password.setBounds(100,80,80,20);
        add(password);

        usertext = new JTextField();
        usertext.setBounds(185,40,200,25);
        usertext.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(usertext);

        passwordtext = new JPasswordField();
        passwordtext.setBounds(185,80,200,25);
        passwordtext.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        add(passwordtext);

        loginbtn = new JButton("LOGIN");
        loginbtn.setBounds(180,130,100,30);
        loginbtn.addActionListener(this);
        add(loginbtn);

        signupbtn = new JButton("SIGN UP");
        signupbtn.setBounds(290,130,100,30);
        signupbtn.addActionListener(this);
        add(signupbtn);

        setSize(500,250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==loginbtn) {
                Conn c = new Conn();
                String username = usertext.getText();
                String password = passwordtext.getText();

                String query = "select * from admindetails where username = '" + username + "' and password = '" + password + "'";
                try {
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        setVisible(false);
                        new AdminMenu(username, password).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                    }
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
            else if(e.getSource()==signupbtn){
                setVisible(false);
                new Signup().setVisible(true);
            }


        }catch(Exception ae){
            System.out.println(ae);
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}
