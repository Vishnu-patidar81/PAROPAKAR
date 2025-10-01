package controller;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.UserDto;
import javax.servlet.http.HttpSession;
import model.LoginAuth;
/**
 *
 * @author Vishnu Patidar
 */
public class LoginChecker extends HttpServlet {

     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
 res.sendRedirect("login.html");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {  
        String Email=req.getParameter("email");
        String Password=req.getParameter("password");
        
        
            

        
        UserDto user=new UserDto();
       user.setEmail(Email);
        user.setPassword(Password);
        

        
       
       LoginAuth LgAuth=new LoginAuth();
       boolean isLogged=LgAuth.isLogin(user);
       
       
//       System.out.println(Email);    
//       System.out.println(user.getEmail());
//       System.out.println(user.getPassword());
//       System.out.println(Password);
       
       
//       System.out.println(isLogged);
       
       if(isLogged){
         HttpSession session=req.getSession(true);
         session.setAttribute("Email", Email);
         
//           System.out.println(session.getId());

         
         res.sendRedirect("profile.jsp");
            
        }
        else{
           
      res.sendRedirect("RegisterChecker");
    }
         
        
        
        
        
        
        
    }

   
}
