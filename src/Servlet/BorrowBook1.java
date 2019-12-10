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
 * Servlet implementation class BorrowBook1
 */
@WebServlet("/borrowBook1")
public class BorrowBook1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBook1() {
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
//		Book book =new Book(ISBN);
		BookDao dao=new BookDao();
		
		try {
			Book book2=dao.Find2(ISBN);
			if(book2!=null) {
				request.setAttribute("book", book2);
				this.getServletContext().setAttribute("book1",book2);
				request.getRequestDispatcher("borrow_show_book.jsp").forward(request,response);
			}
			else {
				request.getRequestDispatcher("").forward(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
