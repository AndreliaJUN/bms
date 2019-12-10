package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RecordDao;
import DataClass.Record;

/**
 * Servlet implementation class XuJieServlet
 */
@WebServlet("/xuJieServlet")
public class XuJieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuJieServlet() {
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
		RecordDao dao=new RecordDao();
		
		
		try {
			Record record=dao.Find3(ISBN, "未还");
			
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        //将字符串转换为日期型
			Date dt1=sdf.parse(record.getReturn_date());
			Date dt2=new Date();
			dt2.setMonth(dt1.getMonth()+2);
			String str1 = sdf.format(dt1);
			String str2 = sdf.format(dt2);
			boolean f=dao.Modify3(str2, ISBN, "未还");
			
			if(f==true) {
				request.getRequestDispatcher("reborrow_book_success.jsp").forward(request,response);
			}
			else {
				request.getRequestDispatcher("reborrow_book_fail.jsp").forward(request,response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
