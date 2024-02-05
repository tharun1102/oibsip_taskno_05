package digital.library.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Addbook extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JButton add,clear,back;
    String username,password;
    Addbook(String username,String password){
        this.username = username;
        this.password = password;
    setLayout(null);
    setTitle("Enter Book Details");

        JLabel bid = new JLabel("Book ID :");
        bid.setBounds(80,20,100,30);
        bid.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(bid);

        t1 = new JTextField();
        t1.setBounds(210,25,300,25);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t1);

        JLabel bookname = new JLabel("Book Name :");
        bookname.setBounds(80,80,100,30);
        bookname.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(bookname);

        t2 = new JTextField();
        t2.setBounds(210,85,300,25);
        t2.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t2);

        JLabel publisher = new JLabel("Publisher :");
        publisher.setBounds(80,140,100,30);
        publisher.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(publisher);

        t3 = new JTextField();
        t3.setBounds(210,145,300,25);
        t3.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t3);

        JLabel publisheryear = new JLabel("Publish year :");
        publisheryear.setBounds(80,200,120,30);
        publisheryear.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(publisheryear);

        t4 = new JTextField();
        t4.setBounds(210,205,300,25);
        t4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t4);

        JLabel price = new JLabel("Price :");
        price.setBounds(80,260,100,30);
        price.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(price);

        t5 = new JTextField();
        t5.setBounds(210,265,300,25);
        t5.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t5);

        add = new JButton("ADD");
        add.setBounds(110,340,100,30);
        add.addActionListener(this);
        add(add);

        clear = new JButton("CLEAR");
        clear.setBounds(230,340,100,30);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("BACK");
        back.setBounds(350,340,100,30);
        back.addActionListener(this);
        add(back);

    setSize(600,500);
    setLocationRelativeTo(null);
    setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bookid = t1.getText();
        String bookname = t2.getText();
        String publisher = t3.getText();
        String publishyear = t4.getText();
        String price = t5.getText();
        Date date = new Date();


        if(e.getSource()==add){
            try{
                Conn c = new Conn();
                String query = "insert into bookdetails values('"+bookid+"','"+bookname+"','"+publisher+"','"+publishyear+"','"+price+"','"+date+"')";
                c.s.executeUpdate(query);

               JOptionPane.showMessageDialog(null,"Added Successfully");

            }catch(Exception ae){
                System.out.println(ae);
            }

        }
       else if(e.getSource()==clear){
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");

        }
       else if(e.getSource()==back){
           setVisible(false);
            new AdminMenu(username, password).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Addbook("","");
    }

}
