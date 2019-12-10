package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ManagerDao;
import DAO.UserDao;
import DataClass.Manager;
import DataClass.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //…Ë÷√±‡¬Î∏Ò Ω
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		
		String shenfen=request.getParameter("shenfen");
		if(shenfen.equals("manager")) {
			String manager_name=request.getParameter("name");
			String manager_password=request.getParameter("password");
			Manager manager=new Manager(manager_name,manager_password);
			ManagerDao dao1=new ManagerDao();
			try {
				boolean f=dao1.find(manager);
				if(f==true)
					request.getRequestDispatcher("manager.jsp").forward(request,response);
				else
					request.getRequestDispatcher("register.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		else {
			String user_name=request.getParameter("name");
			String user_password=request.getParameter("password");
			User user=new User(user_name,user_password);
//			request.setAttribute("user", user);
			this.getServletContext().setAttribute("user",user);
			UserDao dao2=new UserDao();
			try {
				boolean ff=dao2.find(user);
				if(ff==true) {
					request.getRequestDispatcher("user.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("user_no_find.jsp").forward(request, response);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
