package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import database.DbConnection;
import dto.RegisterDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegisterAuth;

/**
 *
 * @author Vishnu Patidar
 */
public class RegisterChecker extends HttpServlet {

     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
 resp.sendRedirect("register.html");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {  
        String Name=req.getParameter("name");
        String MobileNo=req.getParameter("mobile");
        String Email=req.getParameter("email");
        String Group=req.getParameter("blood");
        String Age=req.getParameter("age");
        String Address=req.getParameter("area");
        String Pincode=req.getParameter("pincode");
        String Password=req.getParameter("password");
        String HealthInfo=req.getParameter("diseases");
        
        RegisterDto reg=new RegisterDto();
        reg.setUsername(Name);
        reg.setMobile(MobileNo);
        reg.setBlood(Group);
        reg.setAge(Age);
        reg.setAddress(Address);
        reg.setPincode(Pincode);
        reg.setPassword(Password);
        reg.setDiseases(HealthInfo);
        reg.setEmail(Email);
        
        RegisterAuth regAuth=new RegisterAuth();
        boolean Registered= regAuth.isRegister(reg);
        
        if(Registered){
            res.sendRedirect("LoginChecker");
        }
        else{
            res.sendRedirect("RegisterChecker");
        }
    }}
