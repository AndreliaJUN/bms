package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import DataClass.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		
		String user_name=request.getParameter("user_name");
		User user=new User(user_name);
		UserDao dao=new UserDao();
		try {
			boolean f=dao.delete(user);
			if(f==true)
				request.getRequestDispatcher("delete_user_success.jsp").forward(request, response); 
			else
				request.getRequestDispatcher("delete_user_false.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
