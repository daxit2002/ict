/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package crudservlet;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class crud extends HttpServlet {
Connection c = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet crud</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost/student?autoReconnect=true&useSSL=false","root","root");
                Statement s = c.createStatement();
                String data = "select * from stud";
                ResultSet r = s.executeQuery(data);
                out.println("<table border=2px>");
                out.println("<tr>");
                out.println("<th>id</th>");
                out.println("<th>name</th>");
                out.println("<th>gender</th>");
                out.println("<th>city</th>");
                out.println("<th>mobile_no</th>");
                out.println("</tr>");
                
                while(r.next()){
                    System.out.println(r.getString("s_name"));
                    out.println("<tr>");
                    out.println("<td>"+r.getString("s_roll_no")+"</td>");
                    out.println("<td>"+r.getString("s_name")+"</td>");
                    out.println("<td>"+r.getString("s_gender")+"</td>");
                    out.println("<td>"+r.getString("s_city")+"</td>");
                    out.println("<td>"+r.getString("s_mo_no")+"</td>");
                    out.println("<td><a href=delete?s_roll_no="+r.getInt("s_roll_no")+">Delete</a></td>");
                    out.println("<td><a href=update?s_roll_no="+r.getInt("s_roll_no")+">edit</a></td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                
                c.close();
            }catch(Exception e){
                
            }
            out.println("<h1>Servlet crud at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
