package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDao;
import DAO.RecordDao;
import DataClass.Book;

/**
 * Servlet implementation class YuYueServlet
 */
@WebServlet("/yuYueServlet")
public class YuYueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YuYueServlet() {
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
		
		String ISBN=request.getParameter("ISBN");
		Book book=new Book(ISBN);
		BookDao dao=new BookDao();
		try {
			Book book2=dao.Find2(ISBN);
			if(book2!=null&&book2.getBook_state().equals("已借出")) {
				//如果查找的该书并且书已经被借走了，那么可以预约，修改书的状态为预约
				boolean f=dao.Modify2(ISBN, "已借出且已被预约");
				if(f==true) {
					RecordDao dao2=new RecordDao();
					boolean f2=dao2.Modify2(ISBN);
					if(f2==true) {
						request.getRequestDispatcher("yuyue_book_success.jsp").forward(request, response);
					}
				
				}else {
					request.getRequestDispatcher("yuyue_book_fail.jsp").forward(request,response);
				}
			}
			else {
				request.getRequestDispatcher("bukeyuyue.jsp").forward(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
