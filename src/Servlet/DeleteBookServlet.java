package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDao;
import DataClass.Book;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/deleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
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
		
		String ISBN=request.getParameter("ISBN");
	   Book book =new Book(ISBN);
	   BookDao dao=new BookDao();
	   try {
		boolean f=dao.Delete(book);
		if(f==true) {
			request.getRequestDispatcher("delete_book_success.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("delete_book_false.jsp").forward(request, response);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	   
	}

}
