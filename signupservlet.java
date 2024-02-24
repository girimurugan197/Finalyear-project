package Finalyear-project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signupservlet
 */
@WebServlet("/signupservlet")

public class signupservlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String INSERT_QUERY ="insert into signuptable(name, email, password) VALUES(?,?,?)";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); // Corrected method name
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// jdbc connection
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		 try(Connection con = DriverManager.getConnection("jdbc:mysql:///registerform","root","Root");
	                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
	            //set the values
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3,  password);
	           

	            //execute the query
	            int count = ps.executeUpdate();

	            if(count==0) {
	                pw.println("Record not stored into database");
	            }else {
	                pw.print("<html>\r\n"
	                		+ "    <head>\r\n"
	                		+ "    	<meta charset=\"utf-8\">\r\n"
	                		+ "	    <title>Register</title>\r\n"
	                		+ "        <!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"adminhome.css\"> -->\r\n"
	                		+ "\r\n"
	                		+ "	    <!-- Latest compiled and minified CSS -->\r\n"
	                		+ "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n"
	                		+ "\r\n"
	                		+ "        <!-- Optional theme -->\r\n"
	                		+ "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\r\n"
	                		+ "\r\n"
	                		+ "        <!-- Latest compiled and minified JavaScript -->\r\n"
	                		+ "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\r\n"
	                		+ "\r\n"
	                		+ "        <style class=\"input\" type=\"text/css\">\r\n"
	                		+ "             form{\r\n"
	                		+ "                padding: 10px;\r\n"
	                		+ "                margin-left: 50px;\r\n"
	                		+ "                margin-bottom: 20px;\r\n"
	                		+ "                margin-top: 10px;\r\n"
	                		+ "                background: linear-gradient(45deg, #D98EFF,#8ED6FF,#E0FF8E,#FFCF8E);\r\n"
	                		+ "                background-size: 100% 400%;\r\n"
	                		+ "                animation:  animateGradient 5s ease-in-out infinite;\r\n"
	                		+ "                animation-delay: 2s;\r\n"
	                		+ "                border-radius: 20px;\r\n"
	                		+ "            }\r\n"
	                		+ "            label {\r\n"
	                		+ "                margin-right:10px;\r\n"
	                		+ "                width: 150px; /* Adjust this value to the desired width of your labels */\r\n"
	                		+ "                text-align: right;\r\n"
	                		+ "                padding-right: 10px;\r\n"
	                		+ "                padding-bottom: 10px;\r\n"
	                		+ "            }\r\n"
	                		+ "            #header{\r\n"
	                		+ "                position:fixed;\r\n"
	                		+ "                top:0px;\r\n"
	                		+ "                width: 100%;\r\n"
	                		+ "            }\r\n"
	                		+ "            input[type=\"text\"],input[type=\"number\"],input[type=\"email\"]{\r\n"
	                		+ "	\r\n"
	                		+ "	height: 25px;\r\n"
	                		+ "	width: 250px;\r\n"
	                		+ "	font-size: 15px;\r\n"
	                		+ "	margin-bottom: 20px;\r\n"
	                		+ "	background-color: #fff;\r\n"
	                		+ "	padding-left: 5px;\r\n"
	                		+ "}\r\n"
	                		+ "            #skills{\r\n"
	                		+ "                 margin-left:0px;\r\n"
	                		+ "                 margin-top:2px;\r\n"
	                		+ "            }\r\n"
	                		+ "\r\n"
	                		+ "            @keyframes animateGradient { \r\n"
	                		+ "                0%   {background-position: 0 0;}\r\n"
	                		+ "                50%  {background-position: 0 100%;}\r\n"
	                		+ "                100% {background-position: 0 0;}\r\n"
	                		+ "            }\r\n"
	                		+ "\r\n"
	                		+ "            \r\n"
	                		+ "            \r\n"
	                		+ "        </style> \r\n"
	                		+ "	</head>\r\n"
	                		+ "\r\n"
	                		+ "<body style=\"background-color:grey\">\r\n"
	                		+ "\r\n"
	                		+ "	<br>\r\n"
	                		+ "	<br>\r\n"
	                		+ "	<div>\r\n"
	                		+ "		<br>\r\n"
	                		+ "        <center>\r\n"
	                		+ "		<h1 >\r\n"
	                		+ "			<b style=\"color:white\">JOB REGISTRATION</b>\r\n"
	                		+ "		</h1>\r\n"
	                		+ "		</center>\r\n"
	                		+ "		<div class=\"container\">\r\n"
	                		+ "			<form action=\"SUBMIT\" method=\"get\">\r\n"
	                		+ "				<br>\r\n"
	                		+ "\r\n"
	                		+ "				<!--  <div style=\"margin-left:20px;margin-top:10px;font-size:30px\"> Student's Marks Information </div> -->\r\n"
	                		+ "				<!--  <h3 style=\"margin-left: 50px;\">FirstName</h3> -->\r\n"
	                		+ "				<div>\r\n"
	                		+ "					<div>\r\n"
	                		+ "						<label>FirstName:</label> <input class=\"input\" type=\"text\"\r\n"
	                		+ "							name=\"FirstName\" max=\"20\" required>\r\n"
	                		+ "						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
	                		+ "						<label>LastName:</label> <input class=\"input\" type=\"text\"\r\n"
	                		+ "							name=\"LastName\" max=\"20\" required><br><br>\r\n"
	                		+ "					</div>\r\n"
	                		+ "					<div>\r\n"
	                		+ "						<label>Email:</label> <input class=\"input\" type=\"email\"\r\n"
	                		+ "							name=\"Email\" required>\r\n"
	                		+ "						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
	                		+ "						<label>Mobile No:</label> <input class=\"input\" type=\"tel\"\r\n"
	                		+ "							name=\"numericField\" maxlength=\"10\" pattern=\"[0-9]{10}\" title=\"Please include only numbers in this field\" required><br><br>\r\n"
	                		+ "					</div>\r\n"
	                		+ "					<div>\r\n"
	                		+ "						<label>University/School:</label> <input class=\"input\" type=\"text\"\r\n"
	                		+ "							name=\"University\" required>\r\n"
	                		+ "						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
	                		+ "						<label>Degree:</label> <select id=\"Degree\" name=\"Degree\">\r\n"
	                		+ "							<option value=\"B.TECH,\">B.TECH</option>\r\n"
	                		+ "							<option value=\"B.E\">B.E</option>\r\n"
	                		+ "							<option value=\"BSC\">BSC</option>\r\n"
	                		+ "							<option value=\"B.COM\">B.COM</option>\r\n"
	                		+ "							<option value=\"M.Tech\">M.Tech</option>\r\n"
	                		+ "							<option value=\"M.E\">M.E</option>\r\n"
	                		+ "							<option value=\"MCA\">MCA</option>\r\n"
	                		+ "						</select><br>\r\n"
	                		+ "						<br>\r\n"
	                		+ "					</div>\r\n"
	                		+ "					<div>\r\n"
	                		+ "						<label>Domain:</label> <input class=\"input\" type=\"text\"\r\n"
	                		+ "							name=\"domain\" placeholder=\"Interested domain\"required>\r\n"
	                		+ "						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
	                		+ "						<label>Year of Graduation:</label> <select id=\"year\" name=\"year\">\r\n"
	                		+ "							<option value=\"2024\">2024</option>\r\n"
	                		+ "							<option value=\"2023\">2023</option>\r\n"
	                		+ "							<option value=\"2022\">2022</option>\r\n"
	                		+ "							<option value=\"2021\">2021</option>\r\n"
	                		+ "							<option value=\"2020\">2020</option>\r\n"
	                		+ "							<option value=\"2019\">2019</option>\r\n"
	                		+ "							<option value=\"2018\">2018</option>\r\n"
	                		+ "							\r\n"
	                		+ "						</select><br><br>\r\n"
	                		+ "					</div>\r\n"
	                		+ "					<div>\r\n"
	                		+ "					<label>Skills:</label> \r\n"
	                		+ "						<textarea name=\"Skills\" id=\"Skills\" rows=\"5\" cols=\"35\" placeholder=\"skills related your interested domain\" required></textarea><br>\r\n"
	                		+ "						<br>\r\n"
	                		+ "					</div>\r\n"
	                		+ "				</div>\r\n"
	                		+ "				<br>\r\n"
	                		+ "				<center>\r\n"
	                		+ "					<div>\r\n"
	                		+ "						<input type=\"submit\" class=\"btn btn-primary\" name=\"submit\"\r\n"
	                		+ "							value=\"SUBMIT\">\r\n"
	                		+ "					</div>\r\n"
	                		+ "					<br>\r\n"
	                		+ "				</center>\r\n"
	                		+ "			</form>\r\n"
	                		+ "			<!--    </div>    -->\r\n"
	                		+ "		</div>\r\n"
	                		+ "</body>\r\n"
	                		+ "</html>");
	            }

			
			pw.close();
		}  catch (SQLException e) {
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
