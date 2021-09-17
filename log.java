import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet(urlPatterns = {"/log"})
public class log extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           
        PrintWriter out=response.getWriter();
     try {
 String u=request.getParameter("uname");
 String p=request.getParameter("pwd");
 System.out.print(u+" "+p);
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","18");
 String q="select password,username from record where username=? and password=?";
 PreparedStatement st=con.prepareStatement(q);
 st.setString(1,u);
 st.setString(2,p);

 ResultSet rs=st.executeQuery();
 if(rs.next())
 {
     String p1=rs.getString(2);
     String u1=rs.getString(1);
     
 if(p.equals(p1)&&u.equals(u1))
 {
 response.sendRedirect("booking.html");
 }
 else
 out.println("invalid credentials");
 }
     }
 catch (Exception ex) {
 out.println(ex);
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
