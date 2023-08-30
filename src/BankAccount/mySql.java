/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class mySql {
        
    public static void main(String[] args){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","mysql");
        System.out.println("Connection Successful");
        PreparedStatement pst;
        ResultSet rs;
        Statement st=null;
        
        Calendar cal = Calendar.getInstance();
        int res = cal.getActualMaximum(Calendar.DATE);
   //     System.out.println(cal.getTime());
        System.out.println( + res);
        
        LocalDate currentDate = LocalDate.now();
        int dom = currentDate.getDayOfMonth(); // 17
        System.out.println(+dom);
      
        
      
        if(res == dom){
          
          
          
          double anualRate=10;
          double monthRate=anualRate/12;
      
          
          String sql="Select * From customer";
          
          st=con.createStatement();
          rs=st.executeQuery(sql);
          
           while(rs.next()){
                
                
                String add1=rs.getString("amount");
                double balance=Double.parseDouble(add1);
              //  System.out.println(balance);
                String add2=rs.getString("acc");
              //   System.out.println(add2);
                
                double bal=(balance*monthRate)/100;
               //  System.out.println(bal);
                double Bal1=bal+balance;
                System.out.println(Bal1);

                 try{
                   

                    String sql2="Update customer set amount='"+Bal1+"'Where acc='"+add2+"'"; 
                    pst=con.prepareStatement(sql2);
                    pst.execute();
                  //  JOptionPane.showMessageDialog(null, "Deposite Successfully.");



                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

                    }
              
          
          
          
          
          
          
          
          
    
      }else{
          System.out.println("true");
          
        
      }
        
        
        
        
        
        
        
        
        
        
        
        
    }   catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(mySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
      

      
      
}
    
}
