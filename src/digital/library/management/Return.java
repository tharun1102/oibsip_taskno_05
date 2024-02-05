package digital.library.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Return extends JFrame implements ActionListener {
    JTextField t1,t2;
    JButton r,clear,back;
    JDateChooser dateChooser;
    String username,password;
    Return(String username,String password){
        this.username = username;
        this.password = password;

        setTitle("Return Book");
        setSize(500,400);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        JLabel bid = new JLabel("Book ID :");
        bid.setBounds(50,20,150,30);
        bid.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(bid);

        t1 = new JTextField();
        t1.setBounds(210,25,250,25);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t1);

        JLabel usid = new JLabel("User/Student ID :");
        usid.setBounds(50,80,160,30);
        usid.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(usid);

         t2 = new JTextField();
        t2.setBounds(210,85,250,25);
        t2.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t2);

        JLabel ret = new JLabel("Return Date :");
        ret.setBounds(50,140,150,30);
        ret.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(ret);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(210,145,150,25);
        add(dateChooser);


        r = new JButton("RETURN");
        r.setBounds(80,280,100,30);
        r.addActionListener(this);
        add(r);

        clear = new JButton("CLEAR");
        clear.setBounds(200,280,100,30);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("BACK");
        back.setBounds(320,280,100,30);
        back.addActionListener(this);
        add(back);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String bookid = t1.getText();
        String usid = t2.getText();
        String ret = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        if(e.getSource()==r){
            try{
                Conn c = new Conn();
                String query1 = "insert into returndetails values('"+bookid+"','"+usid+"','"+ret+"')";
                c.s.executeUpdate(query1);


                String query2 = "delete from issueddetails where user_studentid = '"+usid+"'";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Returned Succesfully");
                new AdminMenu(username,password).setVisible(true);

            }catch(Exception ae){
                System.out.println(ae);
            }
        }
        else if(e.getSource()==clear){
            t1.setText("");
            t2.setText("");
            ((JTextField) dateChooser.getDateEditor().getUiComponent()).setText("");
        }
        else if(e.getSource()==back){
            setVisible(false);
            new AdminMenu(username,password).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Return("","");
    }

}
