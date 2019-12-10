package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDao;
import DAO.RecordDao;
import DataClass.Book;
import DataClass.Record;
import DataClass.User;

/**
 * Servlet implementation class BorrowBookServlet2
 */
@WebServlet("/borrowBookServlet2")
public class BorrowBookServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBookServlet2() {
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
	    //设置编码格式
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		
		String puanduan=request.getParameter("jieshu");
//		Book book=(Book)request.getAttribute("book");
		Book book=(Book)this.getServletContext().getAttribute("book1");
	
		User user=(User)this.getServletContext().getAttribute("user");
		
//		User user=(User)request.getAttribute("user");
		RecordDao dao=new RecordDao();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		Date dt1=new Date();
		Date dt2=new Date();
		dt2.setMonth(dt1.getMonth()+2);
		String str1 = sdf.format(dt1);
		String str2 = sdf.format(dt2);
		

		if(puanduan.equals("yes")&&book.getBook_state().equals("可借")) {
			Record record=new Record(book.getBook_name(),book.getBook_ISBN(),user.getUser_name(),str1,str2,"未还","不预约");
			try {
				Record record2=dao.Insert(record);
				
				
				if(record2!=null) {
					BookDao dao2=new BookDao();
					dao2.Modify2(book.getBook_ISBN(),"已借出");
					request.getRequestDispatcher("borrow_book_success.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("borrow_book_false.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			request.getRequestDispatcher("borrow_book_false.jsp").forward(request, response);
		}
	}

}
