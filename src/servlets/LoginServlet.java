package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Hashmap con usuarios para la demo.(Admin y usuario comun)
	private HashMap<String,String> userpass = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor del Servlet
     */
    public LoginServlet() {
        super();
    }
    
    

	@Override
	public void init() throws ServletException {
		super.init();
		//Inicialización del Hashmap.
        userpass.put("admin", "admin");
        userpass.put("user", "user");
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			if(userpass.containsKey(username) && userpass.get(username).compareTo(password) == 0 ){
				out.print("<h1><center>Bien ahí papá!</center></h1>");
			}
			else{
				out.print("<h1><center>Te re kbio kaker</center></h1>");
				out.print("<h1><center><a href='/Jbici-Prototipo/login.html'>Volvé a Intentarlo!</a></center></h1>");
			}
			
			out.println("</body>");
		
		out.println("</html>");
		out.close();
		
	}

}
