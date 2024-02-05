package digital.library.management;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class AdminMenu extends JFrame implements ActionListener {
   JButton view_books,view_users,issued_book,issue_book,add_user,add_book,return_book,userStudentLoginDetails,return_details,admin_details;
    String username,password;
   AdminMenu(String username,String password){
       this.username = username;
       this.password = password;
        setLayout(null);
        setTitle("Admin Menu");

        view_books= new JButton("View Books");
        view_books.setBounds(20,30,120,40);
        view_books.addActionListener(this);
        add(view_books);

        view_users= new JButton("View Users/Students");
        view_users.setBounds(150,30,160,40);
        view_users.addActionListener(this);
        add(view_users);

        issued_book= new JButton("View Issued Book");
        issued_book.setBounds(320,30,150,40);
        issued_book.addActionListener(this);
        add(issued_book);

        issue_book= new JButton("Issue Book");
        issue_book.setBounds(480,30,160,40);
        issue_book.addActionListener(this);
        add(issue_book);

        add_book= new JButton("Add Book");
        add_book.setBounds(20,100,120,40);
        add_book.addActionListener(this);
        add(add_book);

        add_user= new JButton("Add users/Students");
        add_user.setBounds(150,100,160,40);
        add_user.addActionListener(this);
        add(add_user);

        return_book= new JButton("Return Book");
        return_book.setBounds(320,100,150,40);
        return_book.addActionListener(this);
        add(return_book);


        return_details= new JButton("View Return Details");
       return_details.setBounds(480,100,160,40);
       return_details.addActionListener(this);
       add(return_details);

        admin_details = new JButton("View Admin Details");
        admin_details.setBounds(250,170,160,40);
        admin_details.addActionListener(this);
        add(admin_details);


        setSize(680,280);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == view_books) {
                JFrame f = new JFrame("Book List");
                f.setLayout(null);
                getContentPane().setBackground(Color.white);
                f.setSize(900, 500);
                f.setLocationRelativeTo(null);
                f.setVisible(true);

                JTable table = new JTable();

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bookdetails");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ae) {
                    System.out.println(ae);
                }

                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(0, 0, 900, 600);
                f.add(jsp);
            } else if (e.getSource() == view_users) {
                JFrame f = new JFrame("User/Student List");
                f.setLayout(null);
                getContentPane().setBackground(Color.white);
                f.setSize(900, 500);
                f.setLocationRelativeTo(null);
                f.setVisible(true);

                JTable table = new JTable();

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from userstudentdetails");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ae) {
                    System.out.println(ae);
                }

                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(0, 0, 900, 600);
                f.add(jsp);
            } else if (e.getSource() == issued_book) {
                JFrame f = new JFrame("Issued Books");
                f.setLayout(null);
                getContentPane().setBackground(Color.white);
                f.setSize(900, 500);
                f.setLocationRelativeTo(null);
                f.setVisible(true);

                JTable table = new JTable();

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from issueddetails");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ae) {
                    System.out.println(ae);
                }

                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(0, 0, 900, 600);
                f.add(jsp);

            } else if (e.getSource() == issue_book) {
                setVisible(false);
                new IssueBook(username, password).setVisible(true);

            } else if (e.getSource() == add_user) {
                setVisible(false);
                new AddUserStudent(username, password).setVisible(true);

            } else if (e.getSource() == add_book) {
                setVisible(false);
                new Addbook(username, password).setVisible(true);

            } else if (e.getSource() == return_book) {
                setVisible(false);
                new Return(username, password).setVisible(true);
            }

            else if (e.getSource() == return_details) {

                JFrame a = new JFrame("Returned Books");
                a.setLayout(null);
                getContentPane().setBackground(Color.white);
                a.setSize(700, 400);
                a.setLocationRelativeTo(null);
                a.setVisible(true);

                JTable table = new JTable();

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from returndetails");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ae) {
                    System.out.println(ae);
                }

                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(0, 0, 700, 600);
                a.add(jsp);
            }

        else if (e.getSource() == admin_details) {
            JFrame f = new JFrame("Admin List");
            f.setLayout(null);
            getContentPane().setBackground(Color.white);
            f.setSize(900, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

            JTable table = new JTable();

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from admindetails");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                System.out.println(ae);
            }

            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0, 0, 900, 600);
            f.add(jsp);
        }
    }

    public static void main(String[] args) {
        new AdminMenu("","");
    }

}
