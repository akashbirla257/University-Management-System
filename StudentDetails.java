package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class StudentDetails extends JFrame implements ActionListener {
 
    JLabel l1, l2, l3;
    JTable T1;
    JButton b1, b2, b3;
    JTextField t2;

    String x[] = {"Name", "Father's Name", "Date of Birth", "Age", "Addhar", "Email", "Class X(%)", "Class XII(%)", "Phone No", "Roll No", "Course", "Branch", "Address"};
    String y[][] = new String[20][13];
    int i = 0;
    int j = 0;

    StudentDetails() {
        super("Student Details");
        setSize(1260, 650);
        setLocation(100, 100);
        setLayout(null);

        l1 = new JLabel("Enter roll number to delete Student :");
        l1.setBounds(50, 360, 400, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        add(l1);

        t2 = new JTextField();
        t2.setBounds(400, 360, 200, 30);
        add(t2);

        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100, 30);
        add(b1);

        l2 = new JLabel("Add New Student");
        l2.setFont(new Font("serif", Font.BOLD, 20));
        l2.setBounds(50, 450, 400, 30);
        add(l2);

        b2 = new JButton("Add Student");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 150, 30);
        add(b2);

        l3 = new JLabel("Update Student Details");
        l3.setBounds(50, 490, 400, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        add(l3);

        b3 = new JButton("Update Student");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 490, 150, 30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
     
        try {
            Conn c1 = new Conn();
            String s1 = "select * from student";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("fathers_name");
                y[i][j++] = rs.getString("dob");
                y[i][j++] = rs.getString("age");
                y[i][j++] = rs.getString("addhar");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("class_x");
                y[i][j++] = rs.getString("class_xii");
                y[i][j++] = rs.getString("phone");
                y[i][j++] = rs.getString("rollno");
                y[i][j++] = rs.getString("course");
                y[i][j++] = rs.getString("branch");
                y[i][j++] = rs.getString("address");
                i++;
                j = 0;
            }
            T1 = new JTable(y, x);
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
       
        JScrollPane sp=new JScrollPane(T1);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.red);
        b1.addActionListener(this);
    }

    public static void main(String args[]) {
        new StudentDetails().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
    Conn c1=new Conn();
    if(ae.getSource()==b1){
        try{
            String a=t2.getText();
            String q="delete from student where rollno= '"+a+"'";
            c1.s.executeUpdate(q);
        } catch (SQLException ex) {
            System.out.println("error :"+ex);
        }
    }
    else if(ae.getSource() == b2){
            new AddStudent().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            new UpdateStudent().f.setVisible(true);
            this.setVisible(false);
        }
    }
}
