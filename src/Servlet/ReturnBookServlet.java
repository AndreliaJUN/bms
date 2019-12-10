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
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/returnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
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
		/*
		 * 还书 输入号找到那本书（ISBN）将图书状态改为可借 
		 * 和相应的借书记录（ISBN，“未还”）将归还日期改为当前日期
		 */

		
		String ISBN=request.getParameter("ISBN");
		Book book=new Book(ISBN);
		BookDao dao=new BookDao();
		User user=(User)this.getServletContext().getAttribute("user");
		Record record1=new Record();
		
		
		
		try {
			//修改图书状态为可借
			boolean f=dao.Modify2(ISBN, "可借");
			//找到相应的借书记录
			//修改还书时间
			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			   Date dt=new Date();
			   String str = sdf.format(dt);
			   RecordDao dao2=new RecordDao();
			   boolean f2=dao2.Modify(str, ISBN, "未还");
			   if(f==true&&f2==true) {
				   request.getRequestDispatcher("return_book_success.jsp").forward(request, response);
			   }else {
				   request.getRequestDispatcher("return_book_fail.jsp").forward(request, response);
			   }
			  
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
     
		
//		Date dt1=;
		
		
//		
	}

}
