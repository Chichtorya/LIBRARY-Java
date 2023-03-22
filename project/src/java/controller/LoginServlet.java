package controller;

import Object.Admin;
import model.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter pr = response.getWriter();
     String xName = request.getParameter("name");
     String xPass = request.getParameter("pass");
         String logResult = "";
     Admin x;
     AdminData t = new AdminData();
     x = t.login(xName, xPass);
     request.getSession().setAttribute("currUser", x);
 
     if(x==null) { 
       logResult = "Sorry, username and/or password are/is invalid!";  
            request.setAttribute("error", logResult);
          request.getRequestDispatcher("login.jsp").forward(request,response);
      }
      else {
    request.getRequestDispatcher("login.jsp").forward(request,response);
     }

      
  }
}
