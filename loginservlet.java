package Finalyear-project;




    import java.io.IOException;
    import java.io.PrintWriter;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import java.sql.ResultSet;
    import java.sql.Statement;
    
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    import com.mysql.cj.jdbc.result.ResultSetMetaData;
    
    /**
     * Servlet implementation class LoginServlet
     */
    @WebServlet("/login1servlet")
    public class loginservlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
    
        /**
         * Default constructor. 
         */
        public loginservlet() {
            // TODO Auto-generated constructor stub
        }
    
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter(); // Corrected method name
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            // jdbc connection
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerform", "root", "Root");
                
            
                Statement st = conn.createStatement();
                String query = " select * from signuptable where email='" + email + "' and password='" + password + "'";
                String query1 = "select * from information where email=?";
                PreparedStatement ps=conn.prepareStatement(query1);
                ps.setString(1, email);
                
                ResultSet n = ps.executeQuery();
                ResultSet rs = st.executeQuery(query);
                
                
                if (rs.next()) {
                    request.setAttribute("error", "");
                    out.println("<html><body>");
                    out.println("<table border=\"1\"><tr><th>Name</th><th>Email</th><th>Mobile</th><th>University</th><th>Degree</th><th>Domain</th><th>Year</th><th>Skills</th></tr>");
                    while(n.next())
                    {
                        out.print("<tr><td>"+n.getString(1) +" "+n.getString(2)+"</td>"+"<td>" +n.getString(3)+"<br>"+"</td>"+"<td>"+n.getString(4)+"<br>"+"</td>"+"<td>"+n.getString(5)+"<br>"+"</td>"+"<td>"+n.getString(6)+"<br>"+"</td>"+"<td>"+n.getString(7)+"<br>"+"</td>"+"<td>"+n.getString(8)+"<br>"+"</td>"+"<td>"+n.getString(9)+"<br>"+"</td></tr>");
                    }
                    out.println("</table>");
                    out.println("</body></html>");
                    
                } else 
                {	
                    request.setAttribute("error", "INVALID EMAIL OR PASSWORD");
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);
                    //out.print("<h1>" + email + ":please enter correct credentials</h1><br>");
                    
            }
                rs.close();
                st.cancel();
                conn.close();
            } catch (ClassNotFoundException e) {
                out.print("<h1>Login Failed exception!</h1><br>");
                e.printStackTrace();
            } catch (SQLException e) {
                out.print("<h1>Login Failed ex!</h1><br>");
                e.printStackTrace();
            }
    
        }
    
        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            doGet(request, response);
        }
    
    }
    
    
        
    
    
}
