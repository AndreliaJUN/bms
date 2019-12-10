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
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
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
		
		String book_name=request.getParameter("book_name");
		String author=request.getParameter("author");
		String ISBN=request.getParameter("ISBN");
		String price=request.getParameter("price");
		String state=request.getParameter("state");
		Book book =new Book(book_name,author,ISBN,price,state);
		BookDao dao=new BookDao();
		try {
			boolean f=dao.Insert(book);
			if(f==true)
			{
				request.getRequestDispatcher("add_book_success.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("add_book_false.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
