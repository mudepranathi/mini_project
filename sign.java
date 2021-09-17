
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet(urlPatterns = {"/sign"})
public class sign extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String u=request.getParameter("name");
 String u=request.getParameter("uname");
 String e=request.getParameter("mail");
 String p=request.getParameter("pwd");
 String l=request.getParameter("quali");
 String lm=request.getparameter("lname");
 String fm=request.getParameter("fname");
 String ph=request.getParameter("pno");
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","18");
 String q="insert into record values (?,?,?,?,?,?,?)";
 PreparedStatement st=con.prepareStatement(q);
 st.setString(1,u);
 st.setString(2,p);
 st.setString(3,e);
 st.setString(4,l);
 st.setString(5,fm);
 st.setString(6,lm);
 st.setString(7,ph);
           st.executeUpdate();
  out.println("Name : "+u);
  out.println("Password : "+p);
 
     }
 catch (Exception ex) {
              out.println(ex);
     
    }
}
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
