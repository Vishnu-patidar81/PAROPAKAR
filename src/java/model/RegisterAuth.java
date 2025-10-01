/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dto.RegisterDto;
import java.sql.Statement;
import database.DbConnection;
import java.sql.SQLException;
/**
 *
 * @author Vishnu Patidar
 */
public class RegisterAuth {

    public boolean isRegister(RegisterDto reg) {
        String username = reg.getUsername();
        String mobile = reg.getMobile();
        String blood = reg.getBlood();
        String age = reg.getAge();
        String address = reg.getAddress();
        String pincode = reg.getPincode();
        String password = reg.getPassword();
        String diseases = reg.getDiseases();
        String email = reg.getEmail();

       try{
        Statement st=DbConnection.getStatement();
        System.out.print(st);
        
        String query=" INSERT INTO donorslist (username,mobile,email,blood,age,address,pincode,password,diseases) VALUES ('"+username+"','"+mobile+"','"+email+"','"+blood+"','"+age+"','"+address+"','"+pincode+"','"+password+"','"+diseases+"')";
        
        int result=st.executeUpdate(query);

            return result>0;
}
         catch(SQLException e){
                 return false;
                 }
    }
}
