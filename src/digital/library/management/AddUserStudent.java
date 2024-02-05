package digital.library.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class AddUserStudent extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JButton add,clear,back;
    String username,password;
    Choice c;
    JDateChooser dateChooser;
    AddUserStudent(String username,String password){
        this.username = username;
        this.password = password;
        setLayout(null);
        setTitle("Enter User/Student Details");

        JLabel usid = new JLabel("User/Student ID :");
        usid.setBounds(50,20,150,30);
        usid.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(usid);

        t1 = new JTextField();
        t1.setBounds(210,25,300,25);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t1);

        JLabel name = new JLabel("User/Student Name :");
        name.setBounds(50,80,160,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(name);

        t2 = new JTextField();
        t2.setBounds(210,85,300,25);
        t2.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t2);

        JLabel fname = new JLabel("Father Name :");
        fname.setBounds(50,140,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(fname);

        t3 = new JTextField();
        t3.setBounds(210,145,300,25);
        t3.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t3);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(210,205,150,25);
        add(dateChooser);


        JLabel education = new JLabel("Education :");
        education.setBounds(50,260,150,30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        add(education);

        c = new Choice();
        c.add("--select--");
        c.add("Non-Graduate");
        c.add("Graduate");
        c.add("Post-Graduate");
        c.add("Student");
        c.add("Others");
        c.setBounds(210,265,150,25);
        add(c);

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
        String usid = t1.getText();
        String name = t2.getText();
        String fname = t3.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String education = c.getSelectedItem();
        Date date = new Date();


        if(e.getSource()==add){
            try{
                Conn c = new Conn();
                String query = "insert into userstudentdetails values('"+usid+"','"+name+"','"+fname+"','"+dob+"','"+education+"','"+date+"')";
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
            ((JTextField) dateChooser.getDateEditor().getUiComponent()).setText("");


        }
        else if(e.getSource()==back){
            setVisible(false);
            new AdminMenu(username, password).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new AddUserStudent("","");
    }

}

