package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

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
		//Inicializaci�n del Hashmap.
        userpass.put("admin", "admin");
        userpass.put("user", "user");
	}
	
	



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession(false);
    	if(ses!=null){
    		ses.invalidate();
    		resp.sendRedirect("/Jbici-Prototipo/login.html");
    		
    	}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");

			if(userpass.containsKey(username) && userpass.get(username).compareTo(password) == 0 ){
				//Hardcode validation: admin & user view
				HttpSession sesion = request.getSession(true);
				Usuario user = new Usuario(username,password);
			    sesion.setAttribute("user", user);
			    
				if(username.compareTo("admin")==0){
					response.sendRedirect("/Jbici-Prototipo/admin/admin.html");
				}
				else if(username.compareTo("user")==0){
					response.sendRedirect("/Jbici-Prototipo/user/home.html");
				}
				
			}
			else{
				response.sendRedirect("/Jbici-Prototipo/error_login.html");
			}
					
	}

}
