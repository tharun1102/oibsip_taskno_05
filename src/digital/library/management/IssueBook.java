package digital.library.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueBook  extends JFrame implements ActionListener {
    JTextField t1,t2;
    JButton add,clear,back;
    String username,password;
    JDateChooser dateChooser,dateChooserr;
    IssueBook(String username,String password){
        this.username = username;
        this.password = password;

        setLayout(null);
        setTitle("Enter Book Details");

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

        JLabel issue = new JLabel("Issue Date :");
        issue.setBounds(50,140,150,30);
        issue.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(issue);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(210,145,150,25);
        add(dateChooser);

        JLabel due = new JLabel("Due Date :");
        due.setBounds(50,200,150,30);
        due.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(due);

        dateChooserr = new JDateChooser();
        dateChooserr.setBounds(210,205,150,25);
        add(dateChooserr);

        add = new JButton("ADD");
        add.setBounds(80,280,100,30);
        add.addActionListener(this);
        add(add);

        clear = new JButton("CLEAR");
        clear.setBounds(200,280,100,30);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("BACK");
        back.setBounds(320,280,100,30);
        back.addActionListener(this);
        add(back);



        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String bookid = t1.getText();
        String usid = t2.getText();
        String issue = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String due = ((JTextField) dateChooserr.getDateEditor().getUiComponent()).getText();

        if(e.getSource()==add){
            try{
                Conn c = new Conn();
                String query = "insert into issueddetails values('"+bookid+"','"+usid+"','"+issue+"','"+due+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Issued Successfully");

            }catch(Exception ae){
                System.out.println(ae);
            }
        }
        else if(e.getSource()==clear){
            t1.setText("");
            t2.setText("");
            ((JTextField) dateChooser.getDateEditor().getUiComponent()).setText("");
            ((JTextField) dateChooserr.getDateEditor().getUiComponent()).setText("");
        }
        else if(e.getSource()==back){
            setVisible(false);
            new AdminMenu(username,password).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new IssueBook("","");
    }

}
