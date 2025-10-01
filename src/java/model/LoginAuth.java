/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dto.UserDto;
import database.DbConnection;
import java.sql.*;

/**
 *
 * @author Vishnu Patidar
 */
public class LoginAuth {

    public boolean isLogin(UserDto user) {

        String email = user.getEmail();
        String password = user.getPassword();

        String tablePassword = null;

        try {

            Statement st = DbConnection.getStatement();

            String query = "select * from donorslist where email='" + email + "'";

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                tablePassword = rs.getString(8);
                
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        System.out.print(tablePassword);

        if (email != null && password != null && !email.trim().isEmpty() && email.endsWith(".com")&& password.equals(tablePassword)) {
            return true;
        }
        return false;
    }
}
