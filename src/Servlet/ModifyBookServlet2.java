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
 * Servlet implementation class ModifyBookServlet2
 */
@WebServlet("/modifyBookServlet2")
public class ModifyBookServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBookServlet2() {
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
		String ISBN2=request.getParameter("ISBN2");
		String price=request.getParameter("price");
		String state=request.getParameter("state");
		Book book2 =new Book(book_name,author,ISBN2,price,state);
		BookDao dao2=new BookDao();
		

		String ISBN3=this.getServletContext().getAttribute("ISBN3").toString();
//		System.out.println(ISBN3);
		try {
			boolean f=dao2.Modify(book2,ISBN3);
			
			if(f==true) {
				request.getRequestDispatcher("modify_book_success.jsp").forward(request, response);
				
			}else {
				request.getRequestDispatcher("modify_book_fail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
